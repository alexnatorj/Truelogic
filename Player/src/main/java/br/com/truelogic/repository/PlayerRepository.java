package br.com.truelogic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.truelogic.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

}
