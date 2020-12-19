package br.com.truelogic.service;

import java.util.List;

import br.com.truelogic.dto.ResponseDTO;
import br.com.truelogic.model.Player;

public interface PlayerService {

	Player save(Player player);

	void sendQueue(Player player);
	
	ResponseDTO playerTriage(List<Player> players);
	
}
