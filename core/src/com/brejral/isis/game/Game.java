package com.brejral.isis.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.badlogic.gdx.graphics.Color;
import com.brejral.isis.Isis;
import com.brejral.isis.game.player.Player;
import com.brejral.isis.game.ui.GameUIHelper;
import com.brejral.isis.game.ui.map.GameMap;
import com.brejral.isis.game.user.User;

public class Game {
	public static String[] resources = {"Water", "Platinum", "Carbon", "Uranium", "Plasma"};
	private List<Player> players = new ArrayList<Player>();
	private boolean isSetupPhase = true;
	private boolean isSecondSetupRound = false;
	private String buildType = "";
	private List<Integer> dice = new ArrayList<Integer>();
	
	public Game() {
		players.add(new Player(new User("Player 1"), Color.BLUE));
		players.add(new Player(new User("Player 2"), Color.GREEN));
		players.add(new Player(new User("Player 3"), Color.RED));
		
		setPlayerOrder();
		startGame();
	}
	
	private void setPlayerOrder() {
		Collections.shuffle(players, Isis.RAND);
	}
	
	private void startGame() {
		players.get(0).setIsTurn(true);
		buildType = "MiningShip";
	}
	
	public Game(List<Player> players) {
		this.players = players;
	}
	
	public List<Player> getPlayers() {
		return players;
	}
	
	public String getBuildType() {
		return buildType;
	}
	
	public void setBuildType(String buildType) {
		this.buildType = buildType;
	}
	
	public int getNumberOfPlayers() {
		return players.size();
	}
	
	public GameMap getMap() {
		return GameUIHelper.getMap();
	}
	
	public boolean isSetupPhase() {
		return isSetupPhase;
	}
	public boolean isSecondSetupRound() {
		return isSecondSetupRound;
	}
	
	public Player getCurrentPlayerForTurn() {
		for (Player player : players) {
			if (player.isTurn()) {
				return player;
			}
		}
		return null;
	}
	
	public void nextTurn() {
		Player player = getCurrentPlayerForTurn();
		player.setIsTurn(false);
		int index = players.indexOf(player);
		if (isSetupPhase && isSecondSetupRound) {
			if (index == 0) {
				isSetupPhase = false;
				isSecondSetupRound = false;
			} else {
				index--;
			}
		} else {
			if (index == getNumberOfPlayers() - 1) {
				if (isSetupPhase) {
					isSecondSetupRound = true;
				} else {
					index = 0;
				}
			} else {
				index++;
			}
		}
		players.get(index).setIsTurn(true);
	}
	
	public void rollDice() {
		dice.clear();
		dice.add(Isis.nextInt(1, 6));
		dice.add(Isis.nextInt(1, 6));
	}
}
