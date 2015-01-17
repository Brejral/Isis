package com.brejral.isis.game.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;

public class GameUIConstants {
	public static Texture HEX_TEXTURE = new Texture(Gdx.files.internal("images/Hex.png"));
	public static Texture HEX_TEXTURE_H = new Texture(Gdx.files.internal("images/HexHorizontal.png"));

	public static NinePatchDrawable BACKGROUND_NINEPATCH = new NinePatchDrawable(new NinePatch(new Texture("images/InfoBackground.png"), 5, 5, 5, 5));
	public static Texture CARBON_TEXTURE = new Texture(Gdx.files.internal("images/Carbon.png"));
	public static Texture PLASMA_TEXTURE = new Texture(Gdx.files.internal("images/Plasma.png"));
	public static Texture PLATINUM_TEXTURE = new Texture(Gdx.files.internal("images/Platinum.png"));
	public static Texture URANIUM_TEXTURE = new Texture(Gdx.files.internal("images/Uranium.png"));
	public static Texture WATER_TEXTURE = new Texture(Gdx.files.internal("images/Water.png"));

	public static int[] TRADING_STATION_INFO_5 = { 0, 0, 1, 1, 5, 0, 3, 1, 2, 6, 5, 0, 11, 4, 5, 12, 1, 2, 15, 3, 4, 16, 2, 3, 17, 3, 4 };
	public static int[] TRADING_STATION_INFO_6 = { 0, 0, 1, 1, 5, 0, 2, 4, 5, 3, 1, 2, 11, 5, 0, 12, 0, 1, 17, 4, 5, 18, 1, 2, 26, 3, 4, 27, 2, 3, 28, 3, 4 };
}
