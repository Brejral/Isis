package com.brejral.isis.game;

import java.util.List;

import com.brejral.isis.game.player.Player;
import com.brejral.isis.game.ui.GameUIHelper;
import com.brejral.isis.game.ui.bridge.SpaceBridge;
import com.brejral.isis.game.ui.map.MapVertex;
import com.brejral.isis.game.ui.ship.MiningShip;

public class GameHelper {
	public static Game GAME;

	/*
	 * SETTERS
	 */

	public static void setGame(Game game) {
		GAME = game;
	}

	/*
	 * GETTERS
	 */

	public static Game getGame() {
		return GAME;
	}

	/*
	 * Game Getters
	 */

	public static List<Player> getPlayers() {
		return GAME.getPlayers();
	}

	public static Player getCurrentPlayerForTurn() {
		return GAME.getCurrentPlayerForTurn();
	}

	public static String getBuildType() {
		return GAME.getBuildType();
	}

	public static boolean isSetupPhase() {
		return GAME.isSetupPhase();
	}

	public static boolean isSecondSetupRound() {
		return GAME.isSecondSetupRound();
	}

	public static void mapVertexSelected(MapVertex vertex) {
		Player player = GameHelper.getCurrentPlayerForTurn();
		if (isSetupPhase()) {
			if (getBuildType().equals("MiningShip")) {
				MiningShip ship = player.getNextAvailableMiningShip();
				ship.setVertex(vertex);
				setBuildType("SpaceBridge");
				System.out.println(vertex.getVertices().size());
			} else if (getBuildType().equals("SpaceBridge")) {
				SpaceBridge bridge = player.getNextAvailableSpaceBridge();
				//bridge.setVertex(vertex);
			}
		} else {
			
		}
		GameUIHelper.updateMap();
	}
	
	/*
	 * Game Setters
	 */
	
	public static void setBuildType(String buildType) {
		GAME.setBuildType(buildType);
	}
}
