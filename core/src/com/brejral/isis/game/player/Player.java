package com.brejral.isis.game.player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.badlogic.gdx.graphics.Color;
import com.brejral.isis.game.ui.bridge.SpaceBridge;
import com.brejral.isis.game.ui.ship.MiningShip;
import com.brejral.isis.game.ui.ship.Station;
import com.brejral.isis.game.user.User;

public class Player {
	private User user;
	private Color color;
	private List<MiningShip> miningShips = new ArrayList<MiningShip>();
	private List<Station> stations = new ArrayList<Station>();
	private List<SpaceBridge> spaceBridges = new ArrayList<SpaceBridge>();
	private HashMap<String, Integer> resources = new HashMap<String, Integer>();
	private boolean isTurn = false;
	private int points = 0;

	public Player(User user, Color color) {
		this.user = user;
		this.color = color;
		initializeLists();
	}
	
	private void initializeLists() {
		for (int i = 0; i < 15; i++) {
			spaceBridges.add(new SpaceBridge());
			if (i < 5) {
			miningShips.add(new MiningShip());
			}
			if (i < 4) {
				stations.add(new Station());
			}
		}
	}
	
	public void setIsTurn(boolean isTurn) {
		this.isTurn = isTurn;
	}
	
	public boolean isTurn() {
		return isTurn;
	}
	
	public String getName() {
		return user.getName();
	}
	
	public int getNumberOfResources() {
		int value = 0;
		for (Entry<String, Integer> entry : resources.entrySet()) {
			value += entry.getValue();
		}
		return value;
	}
	
	public int getNumberOfResource(String resourceName) {
		return resources.get(resourceName);
	}
	
	public void addResource(String resourceName) {
		addResource(resourceName, 1);
	}
	
	public void addResource(String resourceName, int value) {
		resources.put(resourceName, resources.get(resourceName) + value);
	}
	
	public void subtractResouce(String resourceName) {
		subtractResource(resourceName, 1);
	}
	
	public void subtractResource(String resourceName, int value) {
		resources.put(resourceName, resources.get(resourceName) - value);
	}
	
	public Color getColor() {
		return color;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void addPoints(int value) {
		points += value;
	}
}
