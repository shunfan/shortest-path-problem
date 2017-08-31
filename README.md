# Shortest Ppath Algorithm

## Introduction

A Java implementation of several shortest path algorithms that include the generic label-correcting algorithm and four modified label-correcting algorithms:

* [Abstract Label-Correcting Algorithm](https://github.com/shunfan/shortest-path-algorithm/blob/master/src/algorithms/AbstractAlgorithm.java)
  * [Generic Label-Correcting Algorithm](https://github.com/shunfan/shortest-path-algorithm/blob/master/src/algorithms/GenericAlgorithm.java)
* [Modified Label-Correcting Algorithm](https://github.com/shunfan/shortest-path-algorithm/blob/master/src/algorithms/ModifiedAlgorithm.java)
  * [Queue (FIFO)](https://github.com/shunfan/shortest-path-algorithm/blob/master/src/algorithms/FIFOAlgorithm.java)
  * [Stack](https://github.com/shunfan/shortest-path-algorithm/blob/master/src/algorithms/StackAlgorithm.java)
  * [Dequeue](https://github.com/shunfan/shortest-path-algorithm/blob/master/src/algorithms/DequeAlgorithm.java)
  * [Minimal Distance Label](https://github.com/shunfan/shortest-path-algorithm/blob/master/src/algorithms/MinimumDistanceAlgorithm.java)

All algorithms could detect and report negative cycles based on the Moore-Bellman-Ford algorithm.

Moreover, the repository also includes an [algorithm analysis report](https://github.com/shunfan/shortest-path-algorithm/blob/master/report.pdf) that describes the implementation details, performance comparison, and how it handles negative cycles.

## Other

This repository is migrated from [Rose-Hulman CSSE Git Server](https://ada.csse.rose-hulman.edu/dus/MA446-Project-1), and the project itself is my coursework for MA446 at Rose-Hulman Institute of Technology.
