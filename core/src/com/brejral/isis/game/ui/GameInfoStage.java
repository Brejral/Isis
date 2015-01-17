package com.brejral.isis.game.ui;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.brejral.isis.game.ui.info.GameInfoPanel;

public class GameInfoStage extends Stage {
	GameInfoPanel infoPanel;

	public GameInfoStage() {
		super(new ScreenViewport());
		infoPanel = new GameInfoPanel();
		addActorsToStage();
	}
	
	public void addActorsToStage() {
		addActor(infoPanel);
	}
	
	public void resize(int width, int height) {
		getViewport().update(width, height);
		getCamera().position.x = width/2;
		getCamera().position.y = height/2;
		infoPanel.resize(width, height);
	}
}
