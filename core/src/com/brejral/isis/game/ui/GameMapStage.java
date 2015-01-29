package com.brejral.isis.game.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.brejral.isis.game.ui.info.GameInfoPanel;
import com.brejral.isis.game.ui.map.GameMap;

public class GameMapStage extends Stage implements GestureListener {
	public static ShapeRenderer SHAPE_RENDERER = new ShapeRenderer();
	private GameMap map;
	private GameInfoPanel infoPanel;

	public GameMapStage() {
		super();
		GameUIHelper.setGameMapStage(this);
		this.setViewport(new ExtendViewport(getWidth(), getHeight(), new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight())));
		this.getViewport().setScreenBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		map = new GameMap(5);
		GameUIHelper.setMap(map);
		infoPanel = new GameInfoPanel();
		GameUIHelper.setInfoPanel(infoPanel);
		addActorsToStage();
	}

	public void addActorsToStage() {
		this.addActor(map);
	}
	
	public GameMap getMap() {
		return map;
	}
	
	public float getWidth() {
		return map != null ? map.getWidth() : super.getWidth();
	}
	
	public float getHeight() {
		return map != null ? map.getHeight() : super.getHeight();
	}

	@Override
	public void addActor(Actor actor) {
		if (actor.getX() + actor.getWidth() > this.getWidth()) {
			this.setWidth(actor.getX() + actor.getWidth());
		}
		if (actor.getY() + actor.getHeight() > this.getHeight()) {
			this.setHeight(actor.getY() + actor.getHeight());
		}
		super.addActor(actor);
	}
	
	public void setWidth(float value) {
		((ExtendViewport)this.getViewport()).setMinWorldWidth(value);
	}
	
	public void setHeight(float value) {
		((ExtendViewport)this.getViewport()).setMinWorldHeight(value);
	}

	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean tap(float x, float y, int count, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean longPress(float x, float y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		OrthographicCamera cam = (OrthographicCamera)this.getCamera();
		float zoom = cam.zoom;
		cam.translate(-deltaX * zoom, deltaY * zoom, 0);
		cam.update();
		// These values likely need to be scaled according to your world
		// coordinates.
		// The left boundary of the map (x)
		int mapLeft = (int) (-3);
		// The right boundary of the map (x + width)
		int mapRight = (int) ((3 + this.getWidth()));
		// The bottom boundary of the map (y)
		int mapBottom = (int) (-3);
		// The top boundary of the map (y + height)
		int mapTop = (int) ((3 + this.getHeight()));
		// The camera dimensions, halved
		float cameraHalfWidth = cam.viewportWidth * zoom * .5f;
		float cameraHalfHeight = cam.viewportHeight * zoom * .5f;
		// Move camera after player as normal
		float cameraLeft = cam.position.x - cameraHalfWidth;
		float cameraRight = cam.position.x + cameraHalfWidth;
		float cameraBottom = cam.position.y - cameraHalfHeight;
		float cameraTop = cam.position.y + cameraHalfHeight;

		// Horizontal axis
		if (cameraHalfWidth * 3 / 2 > mapRight - mapLeft) {
			cam.position.x = mapLeft - (cameraHalfWidth * 3 / 2 - (mapRight - mapLeft)) / 2 + cameraHalfWidth;
		} else if (cameraLeft < mapLeft) {
			cam.position.x = mapLeft + cameraHalfWidth;
		} else if (cameraRight > mapRight + (cameraHalfWidth / 2)) {
			cam.position.x = mapRight + (cameraHalfWidth / 2) - cameraHalfWidth;
		}

		// Vertical axis
		if (cameraHalfHeight * 2 > mapTop - mapBottom) {
			cam.position.y = mapBottom - (cameraHalfHeight * 2 - (mapTop - mapBottom)) / 2 + cameraHalfHeight;
		} else if (cameraBottom < mapBottom) {
			cam.position.y = mapBottom + cameraHalfHeight;
		} else if (cameraTop > mapTop) {
			cam.position.y = mapTop - cameraHalfHeight;
		}
		cam.update();
		return false;
	}

	@Override
	public boolean panStop(float x, float y, int pointer, int button) {
		return false;
	}

	@Override
	public boolean zoom(float initialDistance, float distance) {
		return false;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2,
			Vector2 pointer1, Vector2 pointer2) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		OrthographicCamera cam = (OrthographicCamera)this.getCamera();
		float maxZoomY = (getHeight() + 6) / cam.viewportHeight;
		float maxZoomX = (getWidth() + 6) * 4 / cam.viewportWidth / 3;
		float maxZoom = Math.max(maxZoomX, maxZoomY);
		cam.zoom += 0.1 * amount;
		if (cam.zoom > maxZoom) {
			cam.zoom = maxZoom;
		}
		if (cam.zoom < 0.5f) {
			cam.zoom = 0.5f;
		}
		pan(0, 0, 0, 0);
		return false;
	}
	
	public void resize(int width, int height) {
		getViewport().update(width, height);
		scrolled(0);
	}
}
