package lesson16.graph;

public class MainAdjacencyMatrix {

    // A utility function to add an edge in an
    // undirected graph
    private static void addEdge(int[][] adjacency, int u, int v) {
        adjacency[u][v] = 1;
        adjacency[v][u] = 1;
        // for a directed graph with an edge pointing from u to v,
        // adjacency[u][v]=1;
    }

    // A utility function to print the adjacency list
    // representation of graph
    private static void printGraph(int[][] adjucency) {
        for (int i = 0; i < adjucency.length; i++) {
            System.out.println("\nAdjacency list of vertex" + i);
            System.out.print("head");
            for (int j = 0; j < adjucency.length; j++) {
                if (adjucency[i][j] > 0) {
                    System.out.print(" -> " + j);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Creating a graph with 5 vertices
        int vertices = 5;
        int[][] adjacency = new int[vertices][vertices];

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
