package com.brejral.isis.game.ui.ship;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.brejral.isis.game.ui.map.MapVertex;

public class Ship extends Image {
	private MapVertex vertex;
	public Ship(Texture tex) {
		super(tex);
	}
	
	public void setVertex(MapVertex vertex) {
		
	}
}
