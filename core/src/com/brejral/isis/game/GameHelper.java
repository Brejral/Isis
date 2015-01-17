package com.brejral.isis.game;

import java.util.List;

import com.brejral.isis.game.player.Player;
import com.brejral.isis.game.ui.GameInfoStage;
import com.brejral.isis.game.ui.GameMapStage;
import com.brejral.isis.game.ui.GameScreen;
import com.brejral.isis.game.ui.info.GameInfoPanel;
import com.brejral.isis.game.ui.map.GameMap;

public class GameHelper {
	public static Game GAME;
	public static GameScreen GAME_SCREEN;
	public static GameMapStage GAME_MAP_STAGE;
	public static GameInfoStage GAME_INFO_STAGE;
	public static GameMap MAP;
	public static GameInfoPanel INFO_PANEL;
	
	/*
	 * SETTERS
	 */
	
	public static void setGame(Game game) {
		GAME = game;
	}
	
	public static void setGameScreen(GameScreen gameScreen) {
		GAME_SCREEN = gameScreen;
	}
	
	public static void setGameMapStage(GameMapStage gameMapStage) {
		GAME_MAP_STAGE = gameMapStage;
	}
	
	public static void setGameInfoStage(GameInfoStage gameInfoStage) {
		GAME_INFO_STAGE = gameInfoStage;
	}
	
	public static void setMap(GameMap map) {
		MAP = map;
	}
	
	public static void setInfoPanel(GameInfoPanel infoPanel) {
		INFO_PANEL = infoPanel;
	}
	
	/*
	 * GETTERS
	 */
	
	public static Game getGame() {
		return GAME;
	}
	
	public static GameScreen getGameScreen() {
		return GAME_SCREEN;
	}
	
	public static GameMapStage getGameMapStage() {
		return GAME_MAP_STAGE;
	}
	
	public static GameInfoStage getGameInfoStage() {
		return GAME_INFO_STAGE;
	}
	
	public static GameMap getMap() {
		return MAP;
	}
	
	public static GameInfoPanel getInfoPanel() {
		return INFO_PANEL;
	}
	
	/*
	 * Game Getters
	 */
	
	public static List<Player> getPlayers() {
		return GAME.getPlayers();
	}
}
