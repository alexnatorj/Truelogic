package br.com.truelogic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.truelogic.dto.PlayerInputDTO;
import br.com.truelogic.dto.ResponseDTO;
import br.com.truelogic.service.PlayerService;

@RestController
@CrossOrigin
@RequestMapping(value = "/player", produces = "application/json")
public class PlayerController {

	@Autowired
	private PlayerService playerService;
	
	
	@RequestMapping(value="/players", method = {RequestMethod.POST})
	public ResponseEntity<ResponseDTO> player(@RequestBody PlayerInputDTO players) throws Exception  {
		
		ResponseDTO dto = new ResponseDTO();
		if (players == null || players.getPlayers() == null || players.getPlayers().isEmpty()) {
			dto.addError("Empty dataset");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
		}
		try {
			dto = playerService.playerTriage(players.getPlayers());
			return ResponseEntity.ok(dto);
		} catch (Exception e) {
			dto.addError("These players are not allowed");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
		}
	}
	
}
