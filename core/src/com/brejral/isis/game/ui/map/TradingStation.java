package com.brejral.isis.game.ui.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Align;

public class TradingStation extends Group {
	private String resource;
	private Image handlesImage = new Image(new Texture(Gdx.files.internal("images/TradingStationHandles.png")));
	private Image tradingStationImage;
	
	public TradingStation(String resource) {
		this.resource = resource;
		tradingStationImage = new Image(new Texture(Gdx.files.internal("images/" + resource + "TradingStation.png")));
		tradingStationImage.setScale(.8f);
		addActorsToTradingStation();
	}
	
	private void addActorsToTradingStation() {
		addActor(handlesImage);
		addActor(tradingStationImage);
	}
	
	public String getResource() {
		return resource;
	}
	
	public void setOrigin(int x, int y, int handleIndex) {
		tradingStationImage.setOrigin(Align.center);
		tradingStationImage.setPosition(x, y, Align.center);
		Vector2 handleVec = getHandlesPositionVector(handleIndex);
		handlesImage.setPosition(x + handleVec.x, y + handleVec.y, Align.center);
		handlesImage.setOrigin(Align.center);
	}
	
	public Vector2 getHandlesPositionVector(int handleIndex) {
		Vector2 vec = new Vector2();
		switch(handleIndex) {
		case 0:
		vec.set(15, 30);
		handlesImage.setRotation(150);
		break;
		case 1:
		vec.set(50, 0);
		handlesImage.setRotation(90);
		break;
		case 2:
		vec.set(15, -30);
		handlesImage.setRotation(30);
		break;
		case 3:
		vec.set(-15, -30);
		handlesImage.setRotation(-30);
		break;
		case 4:
		vec.set(-50, 0);
		handlesImage.setRotation(-90);
		break;
		case 5:
		vec.set(-15, 30);
		handlesImage.setRotation(-150);
		break;
		}
		return vec;
	}
	
	public int getTradeInNumber() {
		if (resource.equals("All")) {
			return 3;
		}
		return 2;
	}

}
