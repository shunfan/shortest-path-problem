package core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import algorithms.DequeAlgorithm;
import algorithms.FIFOAlgorithm;
import algorithms.GenericAlgorithm;
import algorithms.IAlgorithm;
import algorithms.MinimumDistanceAlgorithm;
import algorithms.StackAlgorithm;
import data.Arc;
import data.Graph;
import data.Problem;
import data.Report;

public class Project {

	/**
	 * This program takes 2 arguments in command line. The first one is the path
	 * of the .gr file, and the second one is the path of the .ss file.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Graph graph = new Graph();
		Problem problem = new Problem();

		try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] chunks = line.split(" ");

				if (line.startsWith("p sp")) {
					graph.numOfNodes = Integer.parseInt(chunks[2]);
					graph.numOfArcs = Integer.parseInt(chunks[3]);

					for (int i = 1; i <= graph.numOfNodes; i++) {
						graph.outArcs.put(i, new ArrayList<>());
					}
				} else if (line.startsWith("a")) {
					int from = Integer.parseInt(chunks[1]);
					int to = Integer.parseInt(chunks[2]);
					int weight = Integer.parseInt(chunks[3]);

					Arc arc = new Arc(from, to, weight);
					graph.arcs.add(arc);
					graph.outArcs.get(from).add(arc);
				}
			}
		}

		try (BufferedReader br = new BufferedReader(new FileReader(args[1]))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] chunks = line.split(" ");

				if (line.startsWith("p aux sp ss")) {
					problem.numOfSources = Integer.parseInt(chunks[4]);
				} else if (line.startsWith("s")) {
					int source = Integer.parseInt(chunks[1]);
					problem.sources.add(source);
				}
			}
		}

		for (int source : problem.sources) {
			runGenericAlgorithm(graph, source);
			runFIFOAlgorithm(graph, source);
			runStackAlgorithm(graph, source);
			runDequeAlgorithm(graph, source);
			runMinimumDistanceAlgorithm(graph, source);
		}
	}

	private static void printReport(Report report) {
		System.out.println("Computational Time: " + report.computationalTime);
		System.out.println("Distance Label Updates: " + report.numOfUpdates);
		System.out.println("Arcs Scanned: " + report.numOfArcsScanned);
	}

	private static Report runGenericAlgorithm(Graph graph, int source) {
		System.out.println("GenericAlgorithm Take 1\n");

		IAlgorithm algorithm1 = new GenericAlgorithm(graph, source);
		Report report1 = algorithm1.run();
		printReport(report1);

		System.out.println("");
		System.out.println("GenericAlgorithm Take 2\n");

		IAlgorithm algorithm2 = new GenericAlgorithm(graph, source);
		Report report2 = algorithm2.run();
		printReport(report2);

		System.out.println("\n---\n");

		return report1;
	}

	private static Report runFIFOAlgorithm(Graph graph, int source) {
		System.out.println("FIFOAlgorithm\n");

		IAlgorithm algorithm = new FIFOAlgorithm(graph, source);
		Report report = algorithm.run();
		printReport(report);

		System.out.println("\n---\n");

		return report;
	}

	private static Report runStackAlgorithm(Graph graph, int source) {
		System.out.println("StackAlgorithm\n");

		IAlgorithm algorithm = new StackAlgorithm(graph, source);
		Report report = algorithm.run();
		printReport(report);

		System.out.println("\n---\n");

		return report;
	}

	private static Report runDequeAlgorithm(Graph graph, int source) {
		System.out.println("DequeAlgorithm\n");

		IAlgorithm algorithm = new DequeAlgorithm(graph, source);
		Report report = algorithm.run();
		printReport(report);

		System.out.println("\n---\n");

		return report;
	}

	private static Report runMinimumDistanceAlgorithm(Graph graph, int source) {
		System.out.println("MinimumDistanceAlgorithm\n");

		IAlgorithm algorithm = new MinimumDistanceAlgorithm(graph, source);
		Report report = algorithm.run();
		printReport(report);

		System.out.println("\n---\n");

		return report;
	}

}
