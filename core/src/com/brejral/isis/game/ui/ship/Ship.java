package com.brejral.isis.game.ui.ship;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.brejral.isis.game.ui.GameUIHelper;
import com.brejral.isis.game.ui.map.MapVertex;

public class Ship extends Image {
	private MapVertex vertex;
	
	public Ship(Texture tex) {
		super(tex);
	}
	
	public MapVertex getVertex() {
		return vertex;
	}
	
	public void setVertex(MapVertex vertex) {
		this.vertex = vertex;
		setOrigin(vertex.getOriginX(), vertex.getOriginY());
		setPosition(vertex.getOriginX(), vertex.getOriginY(), Align.center);
		GameUIHelper.getGameMapStage().addActor(this);
	}
	
	public boolean isAvailable() {
		return vertex == null;
	}
}
