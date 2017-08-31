package algorithms;

import data.Arc;
import data.Graph;

public abstract class ModifiedAlgorithm extends AbstractAlgorithm {

	public ModifiedAlgorithm(Graph graph, int source) {
		super(graph, source);
	}

	@Override
	protected void correctLabels() {
		boolean negativeCycleDetected = false;

		this.addElement(this.source);

		while (!this.isEmpty() && !negativeCycleDetected) {
			int i = this.removeElement();

			for (Arc arc : this.graph.outArcs.get(i)) {
				if (this.correctLabelOnArc(arc)) {
					if (this.detectNegativeCycles()) {
						negativeCycleDetected = true;
						break;
					}

					if (!this.contains(arc.to)) {
						this.addElement(arc.to);
					}
				}

				this.report.numOfArcsScanned += 1;
			}
		}
	}

	abstract boolean isEmpty();

	abstract boolean contains(int label);

	abstract void addElement(int label);

	abstract int removeElement();

}
