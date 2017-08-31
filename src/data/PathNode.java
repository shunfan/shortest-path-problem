package data;

import java.util.ArrayList;

public class PathNode {
	public int label;
	public int depth;
	public PathNode parent;
	public ArrayList<PathNode> children;

	public PathNode(int label, int depth, PathNode parent) {
		this.label = label;
		this.depth = depth;
		this.parent = parent;
		this.children = new ArrayList<>();
	}

	public void addChild(PathNode child) {
		this.children.add(child);
	}

	public int getHeight() {
		int max = -1;

		for (PathNode child : this.children) {
			int childDepth = child.getHeight();
			if (childDepth > max) {
				max = childDepth;
			}
		}

		return max + 1;
	}

	public ArrayList<Integer> getReversePath() {
		ArrayList<Integer> path;

		if (this.parent == null) {
			path = new ArrayList<>();
		} else {
			path = this.parent.getReversePath();
		}

		path.add(this.label);

		return path;
	}
}
