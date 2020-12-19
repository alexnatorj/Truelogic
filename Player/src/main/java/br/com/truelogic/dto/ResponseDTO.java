package br.com.truelogic.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.truelogic.model.Player;

public class ResponseDTO {

	private List<String> result;
	
	public ResponseDTO() {
		result = new ArrayList<>();
	}

	public void addToDatabase(Player player) {
		result.add( "player " + player.getName() + " stored in DB");
	}
	
	public void addToKafka(Player player) {
		result.add( "player " + player.getName() + " sent to Kafka topic");
	}

	public void addToNotFit(Player player) {
		result.add( "player " + player.getName() + " did not fit");
	}

	public void addError(String error) {
		result.add(error);
	}
	
	public List<String> getResult() {
		return result;
	}

	public void setResult(List<String> result) {
		this.result = result;
	}

	
}
