package com.brejral.isis.game.ui.bridge;

import java.util.ArrayList;
import java.util.List;

import com.brejral.isis.game.ui.map.MapVertex;

public class SpaceBridge {
	private List<MapVertex> vertices = new ArrayList<MapVertex>();
	
	public boolean isAvailable() {
		return vertices.size() == 0;
	}
}
