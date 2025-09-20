package com.org.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GraphContainsCycle {
    private final int V;
    private final List<List<Integer>> adj;
    // Constructor
    public GraphContainsCycle(int V) {
        this.V = V;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++)
            adj.add(new LinkedList<>());
    }
    // Add a directed edge from source to dest
    private void addEdge(int source, int dest) {
        adj.get(source).add(dest);
    }
    // Utility function for DFS-based cycle detection
    private boolean isCyclicUtil(int node, boolean[] visited, boolean[] recStack) {
        if (recStack[node])  // Node is already in the recursion stack => cycle
            return true;
        if (visited[node])   // Already visited and not in recStack => safe
            return false;
        visited[node] = true;
        recStack[node] = true;
        List<Integer> neighbors = adj.get(node);
        for (Integer neighbor : neighbors) {
            if (isCyclicUtil(neighbor, visited, recStack))
                return true;
        }
        recStack[node] = false; // Backtrack
        return false;
    }
    // Public method to detect cycle in the graph
    private boolean isCyclic() {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (isCyclicUtil(i, visited, recStack))
                return true;
        }
        return false;
    }

    // Main method
    public static void main(String[] args) {
        // Create a graph with 4 vertices
        GraphContainsCycle graph = new GraphContainsCycle(4);
        // Add edges
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        if (graph.isCyclic()) System.out.println("Graph contains a cycle.");
        else System.out.println("Graph does not contain a cycle.");
    }
}
