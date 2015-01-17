package com.brejral.isis.game.ui.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class WaterTile extends MapTile {
	public WaterTile(int index) {
		this(0, 0, index);
	}
	
	public WaterTile(int x, int y, int index) {
		super(x, y, new Texture(Gdx.files.internal("images/Water" + (index + 1) + ".png")));
	}
}
