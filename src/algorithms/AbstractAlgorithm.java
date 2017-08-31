package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import data.Arc;
import data.Graph;
import data.PathNode;
import data.Report;

public abstract class AbstractAlgorithm implements IAlgorithm {
	protected Graph graph;
	protected int source;
	protected Map<Integer, Long> d;
	protected PathNode latestPathNode;
	protected Map<Integer, PathNode> latestPathNodes;
	protected Report report;

	public AbstractAlgorithm(Graph graph, int source) {
		this.graph = graph;
		this.source = source;
		this.d = new HashMap<>();
		this.latestPathNodes = new HashMap<>();
		this.report = new Report();
	}

	public Report run() {
		long startTime = System.currentTimeMillis();

		this.populateD();
		this.correctLabels();

		this.report.d = this.d;
		long endTime = System.currentTimeMillis();
		this.report.computationalTime = endTime - startTime;

		return report;
	}

	protected boolean correctLabelOnArc(Arc arc) {
		long dFrom = this.d.get(arc.from);
		long dTo = this.d.get(arc.to);

		if (dFrom == Long.MAX_VALUE) {
			return false;
		}

		if (dTo > dFrom + arc.weight) {
			this.d.put(arc.to, dFrom + arc.weight);

			PathNode parentNode = this.latestPathNodes.get(arc.from);
			PathNode node = new PathNode(arc.to, parentNode.depth + 1, parentNode);
			node.parent = this.latestPathNodes.get(arc.from);

			this.latestPathNode = node;
			this.latestPathNodes.put(arc.to, node);
			this.latestPathNodes.get(arc.from).addChild(node);

			this.report.numOfUpdates += 1;

			return true;
		}

		return false;
	}

	protected boolean detectNegativeCycles() {
		int iteration = this.latestPathNode.depth;

		if (iteration == this.graph.numOfNodes) {
			System.out.println("There exists at least one negative cycle.");

			ArrayList<Integer> path = this.latestPathNode.getReversePath();
			HashSet<Integer> labelAppeared = new HashSet<>();

			for (int i = 0; i < path.size(); i++) {
				int label = path.get(i);
				if (!labelAppeared.add(label)) {
					System.out.println("First negative cycle ecountered: " + path.subList(path.indexOf(label), i));
					break;
				}
			}

			return true;
		}

		return false;
	}

	private void populateD() {
		for (int i = 1; i <= this.graph.numOfNodes; i++) {
			if (i == this.source) {
				this.d.put(i, 0L);
			} else {
				this.d.put(i, Long.MAX_VALUE);
			}
		}

		this.latestPathNodes.put(this.source, new PathNode(this.source, 0, null));
	}

	abstract protected void correctLabels();
}
