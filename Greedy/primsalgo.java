import java.util.Arrays;

public class primsalgo {
    private static final int V = 5; // Number of vertices in the graph

    // Utility function to find the vertex with the minimum key value or we can say closest vertex
    int closest(int[] distances, boolean[] visited) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!visited[v] && distances[v] < min) {
                min = distances[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    // Function to print the constructed MST stored in parent[]
    void print(int[] parent, int[][] graph) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++)
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
    }

    // Function to construct and print MST using Prim's algorithm
    void MST(int[][] graph) {
        int[] parent = new int[V];
        int[] distances = new int[V];  // To store the distances from current node
        boolean[] visited = new boolean[V]; // The nodes that are visited. Visited means true

        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[0] = 0; // Initialize key for the starting vertex
        parent[0] = -1; // Starting node is the root of MST

        for (int count = 0; count < V - 1; count++) {
            int u = closest(distances, visited);
            visited[u] = true;

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !visited[v] && graph[u][v] < distances[v]) {
                    parent[v] = u;
                    distances[v] = graph[u][v];
                }
            }
        }

        print(parent, graph);
    }

    public static void main(String[] args) {
        primsalgo prim = new primsalgo();
        int[][] graph = new int[][]{
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}
        };

        prim.MST(graph);
    }
}

