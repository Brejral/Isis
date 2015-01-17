package com.brejral.isis.game.ui.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Tile extends Actor {
	public static int EDGE_LENGTH = 200;
	public static int HEX_LENGTH = (int) (EDGE_LENGTH * Math.sqrt(3));
	private Vector3[] verts = new Vector3[6];
	private Texture backgroundTexture;

	public Tile() {
		this(0, 0);
	}
	
	public Tile(Vector3[] vertices) {
		float x = 0, y = 0, xmax = 0, ymax = 0;
		for (Vector3 vec : vertices) {
			if (vec.x < x) {
				x = vec.x;
			}
			if (vec.x > xmax) {
				xmax = vec.x;
			}
			if (vec.y < y) {
				y = vec.y;
			}
			if (vec.y > ymax) {
				ymax = vec.y;
			}
		}
		setBounds(x, y, xmax - x, ymax - y);
		verts = vertices;
		backgroundTexture = new Texture(Gdx.files.internal("images/Background_2_4.png"));
	}

	public Tile(int x, int y) {
		setBounds(x, y, HEX_LENGTH, 2 * EDGE_LENGTH);
		setVerticies();
		backgroundTexture = new Texture(Gdx.files.internal("images/TileBackground.png"));
	}
	
	@Override
	public void setBounds(float x, float y, float width, float height) {
		super.setBounds(x, y, width, height);
		setVerticies();
	}
	
	@Override
	public void setPosition(float x, float y) {
		super.setPosition(x, y);
		setVerticies();
	}
	
	public Vector3[] getVertices() {
		return verts;
	}

	private void setVerticies() {
		for (int i = 0; i < verts.length; i++) {
			verts[i] = new Vector3();
		}
		int x1 = (int) getX();
		int x2 = (int) (getX() + HEX_LENGTH / 2f);
		int x3 = (int) (getX() + HEX_LENGTH);
		int y1 = (int) getY();
		int y2 = (int) (getY() + 0.5f * EDGE_LENGTH);
		int y3 = (int) (getY() + 1.5f * EDGE_LENGTH);
		int y4 = (int) (getY() + 2 * EDGE_LENGTH);
		verts[0].x = x2;
		verts[0].y = y1;
		verts[1].x = x1;
		verts[1].y = y2;
		verts[2].x = x1;
		verts[2].y = y3;
		verts[3].x = x2;
		verts[3].y = y4;
		verts[4].x = x3;
		verts[4].y = y3;
		verts[5].x = x3;
		verts[5].y = y2;
	}

	@Override
	public void setSize(float width, float height) {
		super.setSize(width, height);
		setVerticies();
	}

	@Override
	public void setWidth(float width) {
		setSize(width, getHeight());
	}

	@Override
	public void setHeight(float height) {
		setSize(getWidth(), height);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(backgroundTexture, getX(), getY(), getWidth(), getHeight());
		super.draw(batch, parentAlpha);
	}
}
