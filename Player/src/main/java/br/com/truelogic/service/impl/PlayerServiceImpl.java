package br.com.truelogic.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import br.com.truelogic.constants.PlayerConstant;
import br.com.truelogic.dto.ResponseDTO;
import br.com.truelogic.model.Player;
import br.com.truelogic.repository.PlayerRepository;
import br.com.truelogic.service.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService {

	
	@Autowired
	private PlayerRepository playerRepository;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Override
	public ResponseDTO playerTriage(List<Player> players) {
		ResponseDTO responseDto = new ResponseDTO();
		
		List<Player> experts = players.stream().filter(p -> 
			p.getType().equalsIgnoreCase(PlayerConstant.EXPERT)).collect(Collectors.toList());
		

		List<Player> novices = players.stream().filter(p -> 
			p.getType().equalsIgnoreCase(PlayerConstant.NOVICE)).collect(Collectors.toList());
		

		List<Player> unkowns = players.stream().filter(p -> 
			!p.getType().equalsIgnoreCase(PlayerConstant.EXPERT) &&
			!p.getType().equalsIgnoreCase(PlayerConstant.NOVICE)).collect(Collectors.toList());
		
		for (Player p : experts) {
			save(p);
			responseDto.addToDatabase(p);
		}
		
		for (Player p : novices) {
			sendQueue(p);
			responseDto.addToKafka(p);
		}
		
		for (Player p : unkowns) {
			responseDto.addToNotFit(p);
		}
		
		return responseDto;
	}
	
	@Override
	public Player save(Player empresa) {
		return playerRepository.save(empresa);
	}
	
	@Override
	public void sendQueue(Player player) {
		String msg = new Gson().toJson(player);
		kafkaTemplate.send("novice-players", msg);
	}

	
	

	
	

}
