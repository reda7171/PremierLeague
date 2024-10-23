package com.pl.premier_league.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pl.premier_league.model.Player;


@Repository
public interface PlayerRepository extends JpaRepository<Player, String> {

	List<Player> getPlayersByName(String name);
	Optional<Player> findByName(String name);
	void deleteByName(String name);
 
}
