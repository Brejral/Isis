package com.brejral.isis.game.ui.ship;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Station extends Ship {

	public Station() {
		super(new Texture(Gdx.files.internal("images/SpaceStation.png")));
	}

}
