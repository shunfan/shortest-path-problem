package algorithms;

import java.util.LinkedList;
import java.util.Queue;

import data.Graph;

public class FIFOAlgorithm extends ModifiedAlgorithm {

	private Queue<Integer> queue;

	public FIFOAlgorithm(Graph graph, int source) {
		super(graph, source);
		this.queue = new LinkedList<>();
	}

	@Override
	boolean isEmpty() {
		return this.queue.isEmpty();
	}

	@Override
	boolean contains(int label) {
		return this.queue.contains(label);
	}

	@Override
	void addElement(int label) {
		this.queue.add(label);
	}

	@Override
	int removeElement() {
		return this.queue.poll();
	}

}
