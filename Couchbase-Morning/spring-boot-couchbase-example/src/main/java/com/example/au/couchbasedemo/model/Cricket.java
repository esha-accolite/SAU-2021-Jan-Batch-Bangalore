package com.example.au.couchbasedemo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

@Document
public class Cricket {
	
	@Id
	private String playerId;
	private String playerName;
	private Float playerAvg;
	private Integer runs;
	private Integer wickets;
	
	public Cricket(String playerId, String playerName, Float playerAvg, Integer runs, Integer wickets) {
		this.playerId = playerId;
		this.playerName = playerName;
		this.playerAvg = playerAvg;
		this.runs = runs;
		this.wickets = wickets;
	}

	public String getPlayerId() {
		return playerId;
	}

	public void setPLayerId(String playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Float getPlayerAvg() {
		return playerAvg;
	}

	public void setPlayerAvg(Float playerAvg) {
		this.playerAvg = playerAvg;
	}
	
	public Integer getruns() {
		return runs;
	}

	public void setruns(Integer runs) {
		this.runs = runs;
	}
	
	public	Integer getwickets() {
		return wickets;
	}

	public void setwickets(Integer wickets) {
		this.wickets = wickets;
	}

}
