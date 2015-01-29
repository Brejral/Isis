package com.brejral.isis.game.ui;

import java.util.List;

import com.brejral.isis.game.GameHelper;
import com.brejral.isis.game.player.Player;
import com.brejral.isis.game.ui.info.GameInfoPanel;
import com.brejral.isis.game.ui.map.GameMap;
import com.brejral.isis.game.ui.map.MapVertex;
import com.brejral.isis.game.ui.ship.MiningShip;

public class GameUIHelper {
	public static GameScreen GAME_SCREEN;
	public static GameMapStage GAME_MAP_STAGE;
	public static GameInfoStage GAME_INFO_STAGE;
	public static GameMap MAP;
	public static GameInfoPanel INFO_PANEL;
	
	/*
	 * SETTERS
	 */
	
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
	 * GameMap Getters
	 */
	
	public static List<MapVertex> getMapVertices() {
		return MAP.getMapVertices();
	}
	
	/*
	 * UI Updaters
	 */
	
	public static void startGame() {
		updateMapForSetupMiningShipSelection();
	}
	
	public static void updateMap() {
		if (GameHelper.isSetupPhase()) {
			if (GameHelper.getBuildType().equals("MiningShip")) {
				updateMapForSetupMiningShipSelection();
			} else if (GameHelper.getBuildType().equals("SpaceBridge")) {
				updateMapForSetupSpaceBridgeSelection();
			}
		}
	}
	
	public static void updateMapForSetupMiningShipSelection() {
		for (MapVertex vert : getMapVertices()) {
			vert.setCanBeSelected(vert.canPlaceShip());
		}
	}

	public static void updateMapForSetupSpaceBridgeSelection() {
		MiningShip ship = GameHelper.getCurrentPlayerForTurn().getMiningShip(GameHelper.isSecondSetupRound() ? 1 : 0);
		for (MapVertex vert : getMapVertices()) {
			vert.setCanBeSelected(ship.getVertex().containsMapVertex(vert));
		}
	}
}
