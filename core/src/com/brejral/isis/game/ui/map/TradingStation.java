package com.brejral.isis.game.ui.map;

public class TradingStation {
	private String resource;
	
	public TradingStation(String resource) {
		this.resource = resource;
	}
	
	public String getResource() {
		return resource;
	}
	
	public int getTradeInNumber() {
		if (resource.equals("All")) {
			return 3;
		}
		return 2;
	}

}
