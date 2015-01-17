package com.brejral.isis.game.ui.map;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.utils.Align;

public class MapTile extends Tile {
	private Texture planetTexture;
	private Texture numberTexture;
	private Integer tileNumber;
	private List<MapVertex> mapVertices = new ArrayList<MapVertex>();

	public MapTile() {
		super();
		planetTexture = null;
		numberTexture = null;
		tileNumber = null;
	}

	public MapTile(int x, int y, Texture texture) {
		super(x, y);
		planetTexture = texture;
		numberTexture = null;
		tileNumber = null;
	}
	
	public boolean isPlanetTile() {
		return planetTexture != null;
	}
	
	public void setTileNumber(Integer tileNumber) {
		numberTexture = tileNumber != null ? new Texture(Gdx.files.internal("images/" + tileNumber + ".png")) : null;
		this.tileNumber = tileNumber;
	}
	
	public Integer getTileNumber() {
		return tileNumber;
	}
	
	public List<MapVertex> getMapVertices() {
		return mapVertices;
	}
	
	public void addMapVertex(MapVertex vertex) {
		mapVertices.add(vertex);
	}
	
	public MapVertex getMapVertex(Vector3 vec) {
		for (MapVertex vertex : mapVertices) {
			if (vertex.getOriginX() == vec.x && vertex.getOriginY() == vec.y) {
				return vertex;
			}
		}
		return null;
	}
	
	public boolean hasMapVertex(Vector3 vec) {
		return getMapVertex(vec) != null;
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		if (planetTexture != null) {
			batch.draw(planetTexture, getX(Align.center) - planetTexture.getWidth()/2, getY(Align.center) - planetTexture.getHeight()/2);
		}
		if (numberTexture != null) {
			batch.draw(numberTexture, getX(Align.center) - 0.6f * numberTexture.getWidth()/2, getY(Align.center) - 0.6f * numberTexture.getWidth()/2, 0.6f * numberTexture.getWidth(), 0.6f * numberTexture.getHeight());
		}
	}
}
