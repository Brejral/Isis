package com.brejral.isis.game.ui.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class CarbonTile extends MapTile {
	public CarbonTile(int index) {
		this(0, 0, index);
	}
	
	public CarbonTile(int x, int y, int index) {
		super(x, y, new Texture(Gdx.files.internal("images/Carbon" + (index + 1) + ".png")));
	}
}
