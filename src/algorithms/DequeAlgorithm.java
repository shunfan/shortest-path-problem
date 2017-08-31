package algorithms;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

import data.Graph;

public class DequeAlgorithm extends ModifiedAlgorithm {

	Deque<Integer> deque;
	Set<Integer> visited;

	public DequeAlgorithm(Graph graph, int source) {
		super(graph, source);
		this.deque = new ArrayDeque<>();
		this.visited = new HashSet<>();
	}

	@Override
	boolean isEmpty() {
		return this.deque.isEmpty();
	}

	@Override
	boolean contains(int label) {
		return this.deque.contains(label);
	}

	@Override
	void addElement(int label) {
		if (this.visited.contains(label)) {
			this.deque.addFirst(label);
		} else {
			this.deque.addLast(label);
		}
	}

	@Override
	int removeElement() {
		this.visited.add(this.deque.peek());
		return this.deque.poll();
	}

}
