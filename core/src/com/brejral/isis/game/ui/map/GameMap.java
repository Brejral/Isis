package com.brejral.isis.game.ui.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.brejral.isis.Isis;

public class GameMap extends Group {
	private int middle, ends;
	private int numberOfTiles;
	private int numberOfRows;
	private List<MapTile> mapTiles = new ArrayList<MapTile>();
	private List<Integer> tileNumbers = new ArrayList<Integer>();
	private List<MapVertex> mapVertices = new ArrayList<MapVertex>();
	private List<TradingStation> tradingStations = new ArrayList<TradingStation>();
	private Vector3[] bgVerts = new Vector3[6];
	private List<CarbonTile> carbonTiles = new ArrayList<CarbonTile>();
	private List<PlasmaTile> plasmaTiles = new ArrayList<PlasmaTile>();
	private List<PlatinumTile> platinumTiles = new ArrayList<PlatinumTile>();
	private List<WaterTile> waterTiles = new ArrayList<WaterTile>();
	private List<UraniumTile> uraniumTiles = new ArrayList<UraniumTile>();

	public GameMap(int middle) {
		this(middle, (int) (middle / 2 + middle % 2));
	}

	public GameMap(int middle, int ends) {
		this.middle = middle;
		this.ends = ends;
		numberOfRows = (middle - ends) * 2 + 1;
		numberOfTiles = middle;
		for (int i = middle - 1; i >= ends; i--) {
			numberOfTiles += 2 * i;
		}
		int height = (int) (1.5f * Tile.EDGE_LENGTH * numberOfRows + 2.5 * Tile.EDGE_LENGTH);
		int width = (int) (2 * height / Math.sqrt(3));
		setBounds(0, 0, width, height);
		setBackgroundVertices();
		initializeTiles();
		randomizeTiles();
		addActors();
	}

	private void initializeTiles() {
		for (int i = 0; i < 6; i++) {
			waterTiles.add(new WaterTile(i));
			platinumTiles.add(new PlatinumTile(i));
			carbonTiles.add(new CarbonTile(i));
			if (i < 5) {
				uraniumTiles.add(new UraniumTile(i));
				plasmaTiles.add(new PlasmaTile(i));
			}
		}
		tradingStations.add(new TradingStation("Water"));
		tradingStations.add(new TradingStation("Platinum"));
		tradingStations.add(new TradingStation("Carbon"));
		tradingStations.add(new TradingStation("Uranium"));
		tradingStations.add(new TradingStation("Plasma"));
		for (int i = 0; i < 4; i++) {
			tradingStations.add(new TradingStation("All"));
		}
		if (middle == 6) {
			tradingStations.add(new TradingStation("All"));
			tradingStations.add(new TradingStation("Platinum"));
		}
	}

	private void randomizeTiles() {
		Collections.shuffle(waterTiles, Isis.RAND);
		Collections.shuffle(platinumTiles, Isis.RAND);
		Collections.shuffle(carbonTiles, Isis.RAND);
		Collections.shuffle(uraniumTiles, Isis.RAND);
		Collections.shuffle(plasmaTiles, Isis.RAND);
		int maxTiles = 0, maxNumbers = 0;
		switch (middle) {
		case 5:
		maxTiles = 4;
		maxNumbers = 2;
			break;
		case 6:
		maxTiles = 6;
		maxNumbers = 3;
			break;
		}
		for (int i = 0; i < maxNumbers; i++) {
			tileNumbers.add(3);
			tileNumbers.add(4);
			tileNumbers.add(5);
			tileNumbers.add(6);
			tileNumbers.add(8);
			tileNumbers.add(9);
			tileNumbers.add(10);
			tileNumbers.add(11);
			if (i < maxNumbers - 1) {
				tileNumbers.add(2);
				tileNumbers.add(12);
			}
		}
		for (int i = 0; i < maxTiles; i++) {
			mapTiles.add(waterTiles.get(i));
			mapTiles.add(platinumTiles.get(i));
			mapTiles.add(carbonTiles.get(i));
			if (i < maxTiles - 1) {
				mapTiles.add(uraniumTiles.get(i));
				mapTiles.add(plasmaTiles.get(i));
			}
		}
		for (int i = mapTiles.size(); i < numberOfTiles; i++) {
			mapTiles.add(new MapTile());
		}
		Collections.shuffle(mapTiles, Isis.RAND);
		Collections.shuffle(tileNumbers);
		Iterator<Integer> tileNumberIter = tileNumbers.iterator();
		for (int i = 0; i < mapTiles.size(); i++) {
			if (mapTiles.get(i).isPlanetTile()) {
				mapTiles.get(i).setTileNumber(tileNumberIter.next());
			}
		}
		Collections.shuffle(tradingStations);
	}

	private void addActors() {
		this.addActor(new Tile(bgVerts));
		int row = 1;
		int rowTiles = ends;
		int rowTile = 0;
		boolean isIncrease = true;
		for (int i = 0; i < numberOfTiles; i++) {
			int x = (int) ((getWidth() / 2) - (rowTiles * Tile.HEX_LENGTH / 2) + (rowTile * Tile.HEX_LENGTH));
			int y = (int) ((1.5f * Tile.EDGE_LENGTH * (row - 1)) + Tile.EDGE_LENGTH);
			mapTiles.get(i).setPosition(x, y);
			createVertices(mapTiles.get(i), row, rowTiles, rowTile, isIncrease);
			this.addActor(mapTiles.get(i));
			rowTile++;
			if (rowTile == rowTiles) {
				rowTile = 0;
				if (rowTiles == middle) {
					isIncrease = false;
				}
				if (isIncrease) {
					rowTiles++;
				} else {
					rowTiles--;
				}
				row++;
			}
		}
		addTradingStations();
		for (MapVertex vertex : mapVertices) {
			this.addActor(vertex);
		}
		// MiningShip ship = new MiningShip();
		// this.addActor(ship);
		// ship.setZIndex(100);
	}

	private void createVertices(MapTile mapTile, int row, int rowTiles,
			int rowTile, boolean isIncrease) {
		MapVertex vertex = null;
		Vector3 vec = null;
		int index = mapTiles.indexOf(mapTile);

		vec = mapTile.getVertices()[0];
		if (row == 1) {
			vertex = new MapVertex(vec.x, vec.y);
		} else {
			int val;
			if (rowTile == 0 && isIncrease) {
				val = (rowTiles - 1);
			} else {
				val = rowTiles;
			}
			vertex = mapTiles.get(index - val).getMapVertex(vec);
		}
		vertex.addTile(mapTile);
		mapVertices.add(vertex);

		vec = mapTile.getVertices()[1];
		if (rowTile == 0) {
			vertex = new MapVertex(vec.x, vec.y);
		} else {
			vertex = mapTiles.get(index - 1).getMapVertex(vec);
		}
		vertex.addTile(mapTile);
		vertex.addVertex(mapTile.getMapVertices().get(0));
		mapVertices.add(vertex);

		vec = mapTile.getVertices()[2];
		if (rowTile == 0) {
			vertex = new MapVertex(vec.x, vec.y);
		} else {
			vertex = mapTiles.get(index - 1).getMapVertex(vec);
		}
		vertex.addTile(mapTile);
		vertex.addVertex(mapTile.getMapVertices().get(1));
		mapVertices.add(vertex);

		vec = mapTile.getVertices()[3];
		vertex = new MapVertex(vec.x, vec.y);
		vertex.addTile(mapTile);
		vertex.addVertex(mapTile.getMapVertices().get(2));
		mapVertices.add(vertex);

		vec = mapTile.getVertices()[4];
		vertex = new MapVertex(vec.x, vec.y);
		vertex.addTile(mapTile);
		vertex.addVertex(mapTile.getMapVertices().get(3));
		mapVertices.add(vertex);

		vec = mapTile.getVertices()[5];
		if (row == 1 || (rowTile == rowTiles - 1 && isIncrease)) {
			vertex = new MapVertex(vec.x, vec.y);
		} else {
			int val;
			if (isIncrease) {
				val = (rowTiles - 1);
			} else {
				val = rowTiles;
			}
			vertex = mapTiles.get(index - val).getMapVertex(vec);
		}
		vertex = new MapVertex(vec.x, vec.y);
		vertex.addTile(mapTile);
		vertex.addVertex(mapTile.getMapVertices().get(4));
		mapVertices.add(vertex);

		mapTile.getMapVertices().get(0)
				.addVertex(mapTile.getMapVertices().get(5));
	}

	private void setBackgroundVertices() {
		bgVerts[0] = new Vector3(0, 0.5f * getHeight(), 0);
		bgVerts[1] = new Vector3(0.25f * getWidth(), getHeight(), 0);
		bgVerts[2] = new Vector3(0.75f * getWidth(), getHeight(), 0);
		bgVerts[3] = new Vector3(getWidth(), 0.5f * getHeight(), 0);
		bgVerts[4] = new Vector3(0.75f * getWidth(), 0, 0);
		bgVerts[5] = new Vector3(0.25f * getWidth(), 0, 0);
	}
	
	private void addTradingStations() {
		mapTiles.get(0).getMapVertices().get(0).setTradingStation(tradingStations.get(0));
	}
}
