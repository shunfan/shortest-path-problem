package data;

public class Arc {
	public int from;
	public int to;
	public int weight;

	public Arc(int from, int to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	public String toString() {
		return this.from + " -(" + this.weight + ")-> " + this.to;
	}
}
