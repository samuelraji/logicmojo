package com.org.graphs;

import java.util.*;

public class IsUndirectedGraphIsTree {
    private final int V; // Number of vertices
    private final List<Integer>[] adj; // Adjacency list
    // Constructor
    public IsUndirectedGraphIsTree(int V) {
        this.V = V;
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++)
            adj[i] = new ArrayList<>();
    }

    // Function to add an undirected edge
    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v); // Since it's undirected
    }

    // A recursive function to detect a cycle in the graph
    boolean isCyclicUtil(int v, boolean[] visited, int parent) {
        visited[v] = true;
        for (Integer neighbor : adj[v]) {
            if (!visited[neighbor]) {
                if (isCyclicUtil(neighbor, visited, v))
                    return true;
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

    // Returns true if the graph is a tree
    boolean isTree() {
        boolean[] visited = new boolean[V];
        // Check for cycle in DFS starting from vertex 0
        if (isCyclicUtil(0, visited, -1))
            return false;
        // Check for connectivity: all vertices should be visited
        for (int i = 0; i < V; i++)
            if (!visited[i])
                return false;
        return true;
    }
    // Main method
    public static void main(String[] args) {
        IsUndirectedGraphIsTree g1 = new IsUndirectedGraphIsTree(5);
        // Creating a graph like:
        // 0 - 1
        // |   |
        // 4 - 2
        //     |
        //     3
        g1.addEdge(0, 1);
        g1.addEdge(0, 4);
        g1.addEdge(1, 2);
        g1.addEdge(2, 4);
        g1.addEdge(2, 3);
        if (g1.isTree())
            System.out.println("Graph is a tree");
        else
            System.out.println("Graph is not a tree");
    }
}

