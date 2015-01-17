package com.brejral.isis.game.ui.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class PlatinumTile extends MapTile {
	public PlatinumTile(int index) {
		this(0, 0, index);
	}
	
	public PlatinumTile(int x, int y, int index) {
		super(x, y, new Texture(Gdx.files.internal("images/Platinum" + (index + 1) + ".png")));
	}

}
