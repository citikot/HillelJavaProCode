package lesson16.graph;

import java.util.ArrayList;

public class MainAdjacencyList {
    // A utility function to add an edge in an
    // undirected graph
    private static void addEdge(ArrayList<ArrayList<Integer>> adjacency, int u, int v) {
        adjacency.get(u)
                .add(v);
        adjacency.get(v)
                .add(u);
        // for a directed graph with an edge pointing from u to v,
        // adj.get(u).add(v);
    }

    // A utility function to print the adjacency list
    // representation of graph
    private static void printGraph(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("\nAdjacency list of vertex" + i);
            System.out.print("head");
            for (int j = 0; j < adj.get(i)
                    .size(); j++) {
                System.out.print(" -> " + adj.get(i)
                        .get(j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Creating a graph with 5 vertices
        int vertices = 5;
        ArrayList<ArrayList<Integer>> adjacency = new ArrayList<>(vertices);

        for (int i = 0; i < vertices; i++) {
            adjacency.add(new ArrayList<>());
        }

        // Adding edges one by one
        addEdge(adjacency, 0, 1);
        addEdge(adjacency, 0, 4);
        addEdge(adjacency, 1, 2);
        addEdge(adjacency, 1, 3);
        addEdge(adjacency, 1, 4);
        addEdge(adjacency, 2, 3);
        addEdge(adjacency, 3, 4);

        printGraph(adjacency);
    }
}
