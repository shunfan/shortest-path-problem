package algorithms;

import java.util.ArrayList;
import java.util.List;

import data.Graph;

public class MinimumDistanceAlgorithm extends ModifiedAlgorithm {

	List<Integer> list;

	public MinimumDistanceAlgorithm(Graph graph, int source) {
		super(graph, source);
		this.list = new ArrayList<>();
	}

	@Override
	boolean isEmpty() {
		return this.list.isEmpty();
	}

	@Override
	boolean contains(int label) {
		return this.list.contains(label);
	}

	@Override
	void addElement(int label) {
		this.list.add(label);
	}

	@Override
	int removeElement() {
		long min = Long.MAX_VALUE;
		Integer elementToRemove = -1;

		for (Integer label : list) {
			if (this.d.get(label) < min) {
				min = this.d.get(label);
				elementToRemove = label;
			}
		}

		this.list.remove(elementToRemove);

		return elementToRemove;
	}

}
