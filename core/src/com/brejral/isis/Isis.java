package com.brejral.isis;

import java.util.Random;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.brejral.isis.game.ui.GameScreen;

public class Isis extends Game {
	public static Random RAND = new Random(System.currentTimeMillis());
	SpriteBatch batch;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		this.setScreen(new GameScreen());
	}

	@Override
	public void render () {
		super.render();
	}
	
	public static int nextInt(int min, int max) {
		return RAND.nextInt((max - min) + 1) + min;
	}
}
