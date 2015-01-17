package com.brejral.isis.game.ui.ship;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class MiningShip extends Ship {

	public MiningShip() {
		super(new Texture(Gdx.files.internal("images/MiningShip.png")));
		//setColor(Color.RED);
		setScale(.05f);
	}
}
