package algorithms;

import java.util.Collections;
import data.Arc;
import data.Graph;

public class GenericAlgorithm extends AbstractAlgorithm {

	public GenericAlgorithm(Graph graph, int source) {
		super(graph, source);
	}

	@Override
	protected void correctLabels() {
		boolean done = false;

		Collections.shuffle(this.graph.arcs);

		while (!done) {
			done = true;

			for (Arc arc : this.graph.arcs) {
				if (this.correctLabelOnArc(arc)) {
					if (this.detectNegativeCycles()) {
						done = true;
						break;
					}

					done = false;
				}

				this.report.numOfArcsScanned += 1;
			}
		}
	}

}
