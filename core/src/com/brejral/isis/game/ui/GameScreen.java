package com.brejral.isis.game.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.brejral.isis.game.Game;
import com.brejral.isis.game.GameHelper;

public class GameScreen implements Screen {
	public static ExtendViewport VIEWPORT;
	private InputMultiplexer inputMultiplexer;
	private GameMapStage mapStage;
	private GameInfoStage infoStage;
	
	public GameScreen() {
		GameHelper.setGame(new Game());
		mapStage = new GameMapStage();
		infoStage = new GameInfoStage();
		GameUIHelper.startGame();
	}

	public GameMapStage getGameStage() {
		return mapStage;
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(.5f, .5f, .5f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		mapStage.act(Gdx.graphics.getDeltaTime());
		infoStage.act(Gdx.graphics.getDeltaTime());
		
		mapStage.draw();
		infoStage.draw();
	}

	@Override
	public void resize(int width, int height) {
		mapStage.resize(width, height);
		infoStage.resize(width, height);
	}

	@Override
	public void show() {
		inputMultiplexer = new InputMultiplexer();
		inputMultiplexer.addProcessor(new GameGestureDetector(mapStage));
		inputMultiplexer.addProcessor(mapStage);
		inputMultiplexer.addProcessor(infoStage);
		Gdx.input.setInputProcessor(inputMultiplexer);
		mapStage.scrolled(6);
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
}
