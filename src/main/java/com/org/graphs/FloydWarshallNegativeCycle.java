package com.org.graphs;

public class FloydWarshallNegativeCycle {

    // Number of vertices in the graph
    static final int V = 4;

    // Define "infinite" as a large enough value for unreachable vertices
    static final int INF = 99999;

    // Returns true if graph has a negative weight cycle, else false
    static boolean negCycleFloydWarshall(int graph[][]) {
        int dist[][] = new int[V][V];

        // Step 1: Initialize the solution matrix same as input graph matrix
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                dist[i][j] = graph[i][j];

        // Step 2: Floyd-Warshall all-pairs shortest paths
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF
                            && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Step 3: Check for negative weight cycle
        for (int i = 0; i < V; i++) {
            if (dist[i][i] < 0) {
                return true;
            }
        }

        return false;
    }

    // Main method to test the above function
    public static void main(String[] args) {
        // Test case: Graph with a negative cycle
        int graph[][] = {
                {0,     1,     INF,   INF},
                {INF,   0,     -1,    INF},
                {INF,   INF,   0,     -1},
                {-1,    INF,   INF,   0}
        };

        if (negCycleFloydWarshall(graph)) {
            System.out.println("Graph contains a negative weight cycle.");
        } else {
            System.out.println("No negative weight cycle found in the graph.");
        }
    }
}

