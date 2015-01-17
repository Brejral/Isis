package com.brejral.isis.game.ui.info;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.brejral.isis.game.player.Player;
import com.brejral.isis.game.ui.GameUIConstants;

public class PlayerResourceTable extends Table {
	private Player player;
	private Label playerCarbonLabel, playerPlasmaLabel, playerPlatinumLabel, playerUraniumLabel, playerWaterLabel;

	public PlayerResourceTable(Player player) {
		this.player = player;
		addActorsToTable();
	}
	
	public void addActorsToTable() {
		LabelStyle labelStyle = new LabelStyle();
		labelStyle.font = new BitmapFont();
		labelStyle.fontColor = player.getColor();
		int imageSize = 30;
		
		add(new Image(GameUIConstants.PLASMA_TEXTURE)).size(imageSize).padRight(3);
		playerPlasmaLabel = new Label("0", labelStyle);
		add(playerPlasmaLabel).width(20);
		
		add(new Image(GameUIConstants.CARBON_TEXTURE)).size(imageSize).padRight(3);
		playerCarbonLabel = new Label("0", labelStyle);
		add(playerCarbonLabel).width(20);
		
		add(new Image(GameUIConstants.WATER_TEXTURE)).size(imageSize).padRight(3);
		playerWaterLabel = new Label("0", labelStyle);
		add(playerWaterLabel).width(20);
		
		add(new Image(GameUIConstants.PLATINUM_TEXTURE)).size(imageSize).padRight(3);
		playerPlatinumLabel = new Label("0", labelStyle);
		add(playerPlatinumLabel).width(20);
		
		add(new Image(GameUIConstants.URANIUM_TEXTURE)).size(imageSize).padRight(3);
		playerUraniumLabel = new Label("0", labelStyle);
		add(playerUraniumLabel).width(20);
	}
	
	public void update() {
		playerPlasmaLabel.setText(Integer.toString(player.getNumberOfResource("Plasma")));
		playerCarbonLabel.setText(Integer.toString(player.getNumberOfResource("Carbon")));
		playerWaterLabel.setText(Integer.toString(player.getNumberOfResource("Water")));
		playerPlatinumLabel.setText(Integer.toString(player.getNumberOfResource("Platinum")));
		playerUraniumLabel.setText(Integer.toString(player.getNumberOfResource("Uranium")));
	}
}
