package com.brejral.isis.game.ui.info;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.brejral.isis.game.player.Player;
import com.brejral.isis.game.ui.GameUIConstants;

public class PlayerInfoTable extends Table {
	Player player;
	Label resourceLabel, pointsLabel;

	public PlayerInfoTable(Player player) {
		this.player = player;
		addActorsToTable();
		updateLabels();
	}
	
	public void addActorsToTable() {
		LabelStyle labelStyle = new LabelStyle();
		labelStyle.font = new BitmapFont();
		labelStyle.fontColor = player.getColor();
		add(new Label(player.getName(), labelStyle)).padRight(5);
		pointsLabel = new Label("Points: " + player.getPoints(), labelStyle);
		add(pointsLabel).padRight(5);
		resourceLabel = new Label("Resources: " + player.getNumberOfResources(), labelStyle);
		add(resourceLabel);
	}
	
	public void updateLabels() {
		if (player.isTurn()) {
			setBackground(GameUIConstants.BACKGROUND_NINEPATCH);
		} else {
			Drawable drawable = null;
			setBackground(drawable);
		}
		resourceLabel.setText("Resources: " + player.getNumberOfResources());
		pointsLabel.setText("Points: " + player.getPoints());
	}
}
