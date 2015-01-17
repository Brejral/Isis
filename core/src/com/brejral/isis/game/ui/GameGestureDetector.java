package com.brejral.isis.game.ui;

import com.badlogic.gdx.input.GestureDetector;

public class GameGestureDetector extends GestureDetector {
	private GameMapStage stage;
	
	public GameGestureDetector(GameMapStage stage) {
		super(stage);
		this.stage = stage;
	}
	
	@Override
	public boolean scrolled(int amount) {
		return stage.scrolled(amount);
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return stage.mouseMoved(screenX, screenY);
	}
}
