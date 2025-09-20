package com.org.graphs;

import java.util.*;

public class DirectedGraphAdjacencyList {
    private int V;   // No. of vertices
    private LinkedList<Integer>[] adj; // Adjacency list
    DirectedGraphAdjacencyList(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }
    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w); // Add w to v's list
    }
    // Function to check if destination is reachable from source using BFS
    boolean isReachable(int s, int d) {
        boolean[] visited = new boolean[V];
        int[] parent = new int[V]; // To store path
        Arrays.fill(parent, -1);

        Queue<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : adj[current]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    parent[neighbor] = current;
                    queue.add(neighbor);
                    // Stop BFS when destination is found
                    if (neighbor == d) {
                        printPath(parent, s, d);
                        return true;
                    }
                }
            }
        }
        System.out.println("No path exists from " + s + " to " + d);
        return false;
    }

    // Utility function to print the path from source to destination
    void printPath(int[] parent, int s, int d) {
        List<Integer> path = new ArrayList<>();
        for (int v = d; v != -1; v = parent[v]) {
            path.add(v);
        }
        Collections.reverse(path);
        System.out.print("Path from " + s + " to " + d + ": ");
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if (i != path.size() - 1)
                System.out.print(" -> ");
        }
        System.out.println();
    }

    // Driver method
    public static void main(String[] args) {
        DirectedGraphAdjacencyList g = new DirectedGraphAdjacencyList(8); // Graph from image (8 nodes: 0 to 7)
        // Adding edges based on the image
        g.addEdge(0, 3);
        g.addEdge(1, 0);
        g.addEdge(1, 2);
        g.addEdge(1, 4);
        g.addEdge(2, 7);
        g.addEdge(3, 5);
        g.addEdge(4, 3);
        g.addEdge(4, 6);
        g.addEdge(5, 6);
        g.addEdge(6, 7);

        // Sample check: Is there a path from 1 to 7?
        int source = 0;
        int destination = 7;

        if (!g.isReachable(source, destination)) {
            System.out.println("Destination not reachable from source.");
        }
    }
}
