package com.brejral.isis.game.ui.info;


import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.brejral.isis.game.GameHelper;
import com.brejral.isis.game.player.Player;
import com.brejral.isis.game.ui.GameUIConstants;

public class GameInfoPanel extends Table {
	public static float SCREEN_SCALE = .25f;
	private NinePatch backgroundTexture = new NinePatch(new Texture(Gdx.files.internal("images/InfoBackground.png")), 5, 5, 5, 5);
	private List<PlayerInfoTable> playerInfoTables = new ArrayList<PlayerInfoTable>();
	private List<PlayerResourceTable> playerResourceTables = new ArrayList<PlayerResourceTable>();
	private TextButton bridgeButton, miningShipButton, stationButton, explorationCardButton;
	
	public GameInfoPanel() {
		resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		addActorsToPanel();
	}
	
	public void resize(int width, int height) {
		setBounds((1f - SCREEN_SCALE) * width, 0, SCREEN_SCALE * width, height);
	}
	
	public void addActorsToPanel() {
		this.align(Align.top);
		setBackground(new NinePatchDrawable(backgroundTexture));
		
		// Player Label
		LabelStyle labelStyle = new LabelStyle();
		labelStyle.font = new BitmapFont();
		
		Label playersLabel = new Label("Players", labelStyle);
		add(playersLabel).align(Align.center).pad(5);
		row();
		
		// Player Rows
		for (Player player : GameHelper.getPlayers()) {
			PlayerInfoTable playerInfoTable = new PlayerInfoTable(player);
			playerInfoTables.add(playerInfoTable);
			add(playerInfoTable).pad(5);
			row();
		}
		
		TextButtonStyle buttonStyle = new TextButtonStyle();
		buttonStyle.font = new BitmapFont();
		buttonStyle.fontColor = Color.WHITE;
		buttonStyle.overFontColor = Color.GREEN;
		int buttonWidth = 120;
		int imageSize = 30;
		
		//Building Option Button Rows
		Table buildingOptionTable = new Table();
		bridgeButton = new TextButton("Bridge", buttonStyle);
		bridgeButton.setName("BridgeButton");
		bridgeButton.getLabel().setAlignment(Align.left);
		buildingOptionTable.add(bridgeButton).width(buttonWidth).pad(5);
		buildingOptionTable.add(new Image(GameUIConstants.PLASMA_TEXTURE)).size(imageSize);
		buildingOptionTable.add(new Image(GameUIConstants.CARBON_TEXTURE)).size(imageSize);
		buildingOptionTable.row();
		
		miningShipButton = new TextButton("Mining Ship", buttonStyle);
		miningShipButton.setName("MiningShipButton");
		miningShipButton.getLabel().setAlignment(Align.left);
		buildingOptionTable.add(miningShipButton).width(buttonWidth).pad(5);
		buildingOptionTable.add(new Image(GameUIConstants.PLASMA_TEXTURE)).size(imageSize);
		buildingOptionTable.add(new Image(GameUIConstants.CARBON_TEXTURE)).size(imageSize);
		buildingOptionTable.add(new Image(GameUIConstants.WATER_TEXTURE)).size(imageSize);
		buildingOptionTable.add(new Image(GameUIConstants.PLATINUM_TEXTURE)).size(imageSize);
		buildingOptionTable.row();
		
		stationButton = new TextButton("Station", buttonStyle);
		stationButton.setName("StationButton");
		stationButton.getLabel().setAlignment(Align.left);
		buildingOptionTable.add(stationButton).width(buttonWidth).pad(5);
		buildingOptionTable.add(new Image(GameUIConstants.WATER_TEXTURE)).size(imageSize);
		buildingOptionTable.add(new Image(GameUIConstants.WATER_TEXTURE)).size(imageSize);
		buildingOptionTable.add(new Image(GameUIConstants.URANIUM_TEXTURE)).size(imageSize);
		buildingOptionTable.add(new Image(GameUIConstants.URANIUM_TEXTURE)).size(imageSize);
		buildingOptionTable.add(new Image(GameUIConstants.URANIUM_TEXTURE)).size(imageSize);
		buildingOptionTable.row();
		
		explorationCardButton = new TextButton("Exploration Card", buttonStyle);
		explorationCardButton.setName("ExplorationCardButton");
		explorationCardButton.getLabel().setAlignment(Align.left);
		buildingOptionTable.add(explorationCardButton).width(buttonWidth).pad(5);
		buildingOptionTable.add(new Image(GameUIConstants.PLATINUM_TEXTURE)).size(imageSize);
		buildingOptionTable.add(new Image(GameUIConstants.WATER_TEXTURE)).size(imageSize);
		buildingOptionTable.add(new Image(GameUIConstants.URANIUM_TEXTURE)).size(imageSize);
		buildingOptionTable.row();
		
		add(buildingOptionTable).padTop(50).padBottom(50);
		row();
		
		// User Resource Counts
		for (Player player : GameHelper.getPlayers()) {
			PlayerResourceTable playerResourceTable = new PlayerResourceTable(player);
			playerResourceTables.add(playerResourceTable);
			add(playerResourceTable);
			row();
		}
		
	}
	
	public void update() {
		for (PlayerInfoTable pit : playerInfoTables) {
			pit.updateLabels();
		}
	}
}
