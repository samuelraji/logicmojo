package com.org.graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class IsGraphATree {
    private int V;                 // Number of vertices
    private LinkedList<Integer>[] adj; // Adjacency list

    // Constructor
    IsGraphATree(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    // Function to add an edge into the graph (undirected)
    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    // A recursive function that uses visited[] and parent to detect cycle
    boolean isCyclicUtil(int v, boolean visited[], int parent) {
        // Mark the current node as visited
        visited[v] = true;

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> it = adj[v].iterator();
        while (it.hasNext()) {
            int i = it.next();

            // If an adjacent is not visited, then recur for that adjacent
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, v))
                    return true;
            }
            // If an adjacent is visited and not parent of current vertex, then there is a cycle.
            else if (i != parent)
                return true;
        }
        return false;
    }

    // Returns true if the graph is a tree, else false.
    boolean isTree() {
        // Mark all the vertices as not visited
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;

        // If cycle is found
        if (isCyclicUtil(0, visited, -1))
            return false;

        // Check if all vertices are reachable (graph is connected)
        for (int u = 0; u < V; u++)
            if (!visited[u])
                return false;

        return true;
    }

    public static void main(String args[]) {
        // Create a graph
        IsGraphATree g1 = new IsGraphATree(5);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);

        if (g1.isTree())
            System.out.println("Graph is Tree");
        else
            System.out.println("Graph is not Tree");

        IsGraphATree g2 = new IsGraphATree(5);
        g2.addEdge(0, 1);
        g2.addEdge(0, 2);
        g2.addEdge(1, 2);
        g2.addEdge(0, 3);
        g2.addEdge(3, 4);

        if (g2.isTree())
            System.out.println("Graph is Tree");
        else
            System.out.println("Graph is not Tree");
    }
}

