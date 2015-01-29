package com.brejral.isis.game.ui.ship;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.brejral.isis.game.ui.map.MapVertex;

public class MiningShip extends Ship {
	public MiningShip() {
		super(new Texture(Gdx.files.internal("images/MiningShip.png")));
		setScale(.05f);
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		super.draw(batch, parentAlpha);
	}
}
