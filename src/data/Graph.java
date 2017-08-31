package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
	public int numOfNodes;
	public int numOfArcs;
	public List<Arc> arcs;
	public Map<Integer, List<Arc>> outArcs;

	public Graph() {
		this.arcs = new ArrayList<>();
		this.outArcs = new HashMap<>();
	}
}
