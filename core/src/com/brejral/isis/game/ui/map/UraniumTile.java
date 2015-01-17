package com.brejral.isis.game.ui.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class UraniumTile extends MapTile {
	public UraniumTile(int index) {
		this(0, 0, index);
	}
	
	public UraniumTile(int x, int y, int index) {
		super(x, y, new Texture(Gdx.files.internal("images/Uranium" + (index + 1) + ".png")));
	}
}
