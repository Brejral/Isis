package com.brejral.isis.game.ui.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class PlasmaTile extends MapTile {
	public PlasmaTile(int index) {
		this(0, 0, index);
	}
	
	public PlasmaTile(int x, int y, int index) {
		super(x, y, new Texture(Gdx.files.internal("images/Plasma" + (index + 1) + ".png")));
	}
}
