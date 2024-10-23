package com.pl.premier_league.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pl.premier_league.model.Player;
import com.pl.premier_league.repository.PlayerRepository;

@Service
public class PlayerService {
	
	
	@Autowired
	private PlayerRepository playerRepository;
	
	public PlayerService(PlayerRepository playerRepository) {
	     this.playerRepository = playerRepository;
	}
	
	
	
	
	public List<Player> getAllPlayers(){
		return playerRepository.findAll();
	}
	
	
	public Player savePlayer(Player player) {
			   return playerRepository.save(player);
	}
	
	
	public List<Player> getPlayersByName(String name) {
		return  playerRepository.findById(name).stream().filter(player -> player.getName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
	}
	
	

	
	
	public List<Player> getPlayersByNation(String nation) {
		return  playerRepository.findAll().stream().filter(player -> player.getNation().toLowerCase().contains(nation.toLowerCase())).collect(Collectors.toList());
	}
	
	public List<Player> getPlayersByTeam(String team) {
		return  playerRepository.findAll().stream().filter(player -> player.getTeam().toLowerCase().contains(team.toLowerCase())).collect(Collectors.toList());
	}
	
	public List<Player> getPlayersByPosition(String position) {
		return  playerRepository.findAll().stream().filter(player -> player.getPos().toLowerCase().contains(position.toLowerCase())).collect(Collectors.toList());
	}
	
	public List<Player> getPlayersByTeamAndPosition(String team,String position) {
		return  playerRepository.findAll().stream().filter(player -> team.equals(player.getTeam()) && position.equals(player.getPos())).collect(Collectors.toList());
	}
	
	public Player updatePlayer(Player updatedPlayer) {
		
		Optional<Player> existingPlayer = playerRepository.findByName(updatedPlayer.getName());
		if(existingPlayer.isPresent())
		{
			Player playerToUpdate = existingPlayer.get();
			playerToUpdate.setName(updatedPlayer.getName());
			playerToUpdate.setNation(updatedPlayer.getNation());
			playerToUpdate.setPos(updatedPlayer.getPos());
			playerToUpdate.setTeam(updatedPlayer.getTeam());
			
			playerRepository.save(playerToUpdate);
			
			return playerToUpdate;
			
		}
		
		return null;
		
		
	}
	
	public void deletePlayer(String name) {
		playerRepository.deleteByName(name);
	}




	 public Player addPlayer(Player player) {
	        playerRepository.save(player);
	        return player;
	    }
	
	

}
