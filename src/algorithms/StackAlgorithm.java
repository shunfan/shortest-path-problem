package algorithms;

import java.util.Stack;

import data.Graph;

public class StackAlgorithm extends ModifiedAlgorithm {

	Stack<Integer> stack;

	public StackAlgorithm(Graph graph, int source) {
		super(graph, source);
		this.stack = new Stack<>();
	}

	@Override
	boolean isEmpty() {
		return stack.isEmpty();
	}

	@Override
	boolean contains(int label) {
		return this.stack.contains(label);
	}

	@Override
	void addElement(int label) {
		this.stack.push(label);
	}

	@Override
	int removeElement() {
		return stack.pop();
	}

}
