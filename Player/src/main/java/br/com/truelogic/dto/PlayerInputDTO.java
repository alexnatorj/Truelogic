package br.com.truelogic.dto;

import java.util.List;

import br.com.truelogic.model.Player;

public class PlayerInputDTO {

	private List<Player> players;
	
	public PlayerInputDTO() {
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	
}
