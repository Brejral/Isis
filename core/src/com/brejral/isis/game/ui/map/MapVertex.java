package com.brejral.isis.game.ui.map;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.brejral.isis.game.GameHelper;
import com.brejral.isis.game.player.Player;
import com.brejral.isis.game.ui.GameUIConstants;
import com.brejral.isis.game.ui.GameUIHelper;
import com.brejral.isis.game.ui.ship.MiningShip;
import com.brejral.isis.game.ui.ship.Ship;

public class MapVertex extends Actor {
	public static Texture VERTEX_TEX = new Texture("images/Vertex.png");
	public static Texture VERTEX_HIGHLIGHT_TEX = new Texture("images/VertexHighlight.png");
	private List<MapTile> tiles = new ArrayList<MapTile>();
	private List<MapVertex> vertices = new ArrayList<MapVertex>();
	private List<MapVertex> bridgeVertices = new ArrayList<MapVertex>();
	private TradingStation tradingStation = null;
	private boolean isTouched = false, canBeSelected = false;
	private Ship ship;

	public MapVertex(float x, float y) {
		setSize(75, 75);
		setOrigin(x, y);
		setPosition(x, y, Align.center);
		setTouchable(Touchable.enabled);
		addListeners();
	}
	
	public void addListeners() {
		addListener(new ClickListener() {
			@Override
			public void enter(InputEvent event, float x, float y, int pointer,
					Actor fromActor) {
				isTouched = true;
				super.enter(event, x, y, pointer, fromActor);
			}
			
			@Override
			public void exit(InputEvent event, float x, float y, int pointer,
					Actor toActor) {
				isTouched = false;
				super.exit(event, x, y, pointer, toActor);
			}
			@Override
			public void clicked(InputEvent event, float x, float y) {
				GameHelper.mapVertexSelected((MapVertex) event.getTarget());
				super.clicked(event, x, y);
			}
		});
	}
	
	public boolean canPlaceShip() {
		for (MapVertex vertex : vertices) {
			if (vertex.hasShip()) {
				return false;
			}
		}
		return true;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
		ship.setVertex(this);
	}

	public Ship getShip() {
		return ship;
	}
	
	public boolean hasShip() {
		return ship != null;
	}
	
	public void addTile(MapTile tile) {
		tiles.add(tile);
		tile.addMapVertex(this);
	}

	public List<MapTile> getTiles() {
		return tiles;
	}

	public void addVertex(MapVertex vertex) {
		if (!this.containsMapVertex(vertex)) {
			vertices.add(vertex);
			vertex.addVertex(this);
		}
	}

	public List<MapVertex> getVertices() {
		return vertices;
	}

	public boolean containsMapVertex(MapVertex vertex) {
		for (MapVertex mapVertex : vertices) {
			if (mapVertex.getOriginX() == vertex.getOriginX()
					&& mapVertex.getOriginY() == vertex.getOriginY()) {
				return true;
			}
		}
		return false;
	}
	
	public void setTradingStation(TradingStation station) {
		this.tradingStation = station;
	}
	
	public TradingStation getTradingStation() {
		return tradingStation;
	}
	
	public void setCanBeSelected(boolean canBeSelected) {
		this.canBeSelected = canBeSelected;
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		if (isTouched && canBeSelected) {
			batch.draw(VERTEX_HIGHLIGHT_TEX, getX(), getY(), getWidth(), getHeight());
		} else if (canBeSelected) {
			batch.draw(VERTEX_TEX, getX(), getY(), getWidth(), getHeight());
		}
	}
	
	@Override
	public Actor hit(float x, float y, boolean touchable) {
		return super.hit(x, y, touchable);
	}
	
}
