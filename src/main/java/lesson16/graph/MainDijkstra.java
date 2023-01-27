package lesson16.graph;

public class MainDijkstra {
    private static class VertexData {
        // the shortest distance from source
        // Initialize all distances as INFINITE
        private int distance = Integer.MAX_VALUE;

        // will true if vertex i is included in
        // shortest path tree or shortest distance from src
        // to i is finalized
        private boolean finalized;

        private String path;

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public boolean isFinalized() {
            return finalized;
        }

        public void setFinalized(boolean finalized) {
            this.finalized = finalized;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

    }

    private static int minDistance(VertexData[] vertexData) {
        // Initialize min value
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < vertexData.length; v++)
            if (!vertexData[v].isFinalized() && vertexData[v].getDistance() <= min) {
                min = vertexData[v].getDistance();
                minIndex = v;
            }

        return minIndex;
    }

    // A utility function to print the constructed distance
    // array
    private static void printSolution(VertexData[] vertexData) {
        String format = "|%-10s|%-10s|%-25s|";
        System.out.println(String.format(format, "Vertex", "Distance", "Path"));
        for (int i = 0; i < vertexData.length; i++) {
            System.out.println(String.format(format, i, vertexData[i].getDistance(), vertexData[i].getPath()));
        }
    }

    // Function that implements Dijkstra's single source
    // shortest path algorithm for a graph represented using
    // adjacency matrix representation
    private static void dijkstra(int[][] graph, int sourceVertex) {
        VertexData[] vertexData = new VertexData[graph.length];
        for (int i = 0; i < vertexData.length; i++) {
            vertexData[i] = new VertexData();
        }

        // Distance of source vertex from itself is always 0       
        vertexData[sourceVertex].setDistance(0);
        vertexData[sourceVertex].setPath("" + sourceVertex);

        // Find shortest path for all vertices
        for (int count = 0; count < graph.length - 1; count++) {
            // Pick the minimum distance vertex from the set
            // of vertices not yet processed. u is always
            // equal to source in first iteration.
            int u = minDistance(vertexData);

            // Mark the picked vertex as processed
            vertexData[u].setFinalized(true);

            // Update distance value of the adjacent vertices of
            // the picked vertex.
            for (int v = 0; v < graph.length; v++)

                // Update distance[v] only if isn't vertex finalized,
                // there is an edge from u to v, and total
                // weight of path from src to v through u is
                // smaller than current value of distance[v]
                if (!vertexData[v].isFinalized() && graph[u][v] != 0
                        && vertexData[u].getDistance() + graph[u][v] < vertexData[v].getDistance()) {
                    vertexData[v].setDistance(vertexData[u].getDistance() + graph[u][v]);
                    vertexData[v].setPath(vertexData[u].getPath() + " -> " + v);
                }
        }

        // print the constructed distance array
        printSolution(vertexData);
    }

    // Driver's code
    public static void main(String[] args) {
        /*
         * Let us create the example graph discussed above
         */
        int[][] graph = new int[][]{//
                {0, 4, 0, 0, 0, 0, 0, 8, 0}, //
                {4, 0, 8, 0, 0, 0, 0, 11, 0}, //
                {0, 8, 0, 7, 0, 4, 0, 0, 2}, //
                {0, 0, 7, 0, 9, 14, 0, 0, 0}, //
                {0, 0, 0, 9, 0, 10, 0, 0, 0}, //
                {0, 0, 4, 14, 10, 0, 2, 0, 0}, //
                {0, 0, 0, 0, 0, 2, 0, 1, 6}, //
                {8, 11, 0, 0, 0, 0, 1, 0, 7}, //
                {0, 0, 2, 0, 0, 0, 6, 7, 0}};

        // Function call
        MainDijkstra.dijkstra(graph, 0);
    }
}
