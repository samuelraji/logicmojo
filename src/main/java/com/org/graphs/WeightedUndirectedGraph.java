package com.org.graphs;

import java.util.*;

class WUEdge {
    int dest;
    int weight;

    public WUEdge(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }
}

class WUGraph {
    List<List<WUEdge>> adjList;

    public WUGraph(int n) {
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest, int weight) {
        adjList.get(src).add(new WUEdge(dest, weight));
        // if undirected, also add reverse edge:
        // adjList.get(dest).add(new Edge(src, weight));
    }
}

// Node used in BFS
class NodeState {
    int vertex;
    int cost;
    Set<Integer> visited;

    public NodeState(int vertex, int cost, Set<Integer> visited) {
        this.vertex = vertex;
        this.cost = cost;
        this.visited = visited;
    }
}

public class WeightedUndirectedGraph {

    public static int findMaxCost(WUGraph graph, int src, int k) {
        Queue<NodeState> q = new LinkedList<>();

        // add source vertex to set and enqueue it
        Set<Integer> initialSet = new HashSet<>();
        initialSet.add(src);
        q.add(new NodeState(src, 0, initialSet));

        int maxCost = Integer.MIN_VALUE;

        while (!q.isEmpty()) {
            NodeState node = q.poll();
            int v = node.vertex;
            int cost = node.cost;
            Set<Integer> visited = node.visited;

            // if cost exceeds `k`, update maximum cost calculated so far
            if (cost > k) {
                maxCost = Math.max(maxCost, cost);
            }

            // do for every adjacent edge of `v`
            for (WUEdge edge : graph.adjList.get(v)) {
                if (!visited.contains(edge.dest)) {
                    // add current node to the path
                    Set<Integer> newVisited = new HashSet<>(visited);
                    newVisited.add(edge.dest);

                    // enqueue with new cost
                    q.add(new NodeState(edge.dest, cost + edge.weight, newVisited));
                }
            }
        }

        return maxCost == Integer.MIN_VALUE ? -1 : maxCost;
    }

    public static void main(String[] args) {
        int n = 5; // number of vertices
        WUGraph graph = new WUGraph(n);

        // add weighted edges
        graph.addEdge(0, 1, 5);
        graph.addEdge(0, 2, 10);
        graph.addEdge(1, 3, 3);
        graph.addEdge(2, 3, 2);
        graph.addEdge(3, 4, 7);

        int src = 0;
        int k = 8;

        int result = findMaxCost(graph, src, k);
        if (result != -1)
            System.out.println("Maximum cost path from " + src + " exceeding " + k + " is " + result);
        else
            System.out.println("No path exceeding " + k);
    }
}
