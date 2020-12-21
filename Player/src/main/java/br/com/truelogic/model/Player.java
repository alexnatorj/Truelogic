package br.com.truelogic.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="player")
public class Player implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -836371056906908938L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_seq")
	@SequenceGenerator(name = "player_seq", sequenceName = "player_seq", allocationSize = 1, initialValue = 1)
	private Integer idPlayer;
	
	@NotNull
	@Column(nullable = false)
	private String name;
	
	@NotNull
	@Column(name="type", nullable = false)
	private String type;

	public Integer getIdPlayer() {
		return idPlayer;
	}

	public void setIdPlayer(Integer idPlayer) {
		this.idPlayer = idPlayer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPlayer == null) ? 0 : idPlayer.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (idPlayer == null) {
			if (other.idPlayer != null)
				return false;
		} else if (!idPlayer.equals(other.idPlayer))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Player [idPlayer=" + idPlayer + ", name=" + name + ", type=" + type + "]";
	}
	
	
	
}
