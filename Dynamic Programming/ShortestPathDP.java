import java.util.Arrays;

class ShortestPathDP {
    static final int INF = Integer.MAX_VALUE;

    static class Edge {
        int src, dest, weight;

        Edge() {
            src = dest = weight = 0;
        }
    }

    int V, E;
    Edge[] edges;

    ShortestPathDP(int v, int e) {
        V = v;
        E = e;
        edges = new Edge[e];
        for (int i = 0; i < e; ++i)
            edges[i] = new Edge();
    }

    void BellmanFord(int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, INF);
        dist[src] = 0;

        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = edges[j].src;
                int v = edges[j].dest;
                int weight = edges[j].weight;
                if (dist[u] != INF && dist[u] + weight < dist[v])
                    dist[v] = dist[u] + weight;
            }
        }

        // Check for negative-weight cycles
        for (int j = 0; j < E; ++j) {
            int u = edges[j].src;
            int v = edges[j].dest;
            int weight = edges[j].weight;
            if (dist[u] != INF && dist[u] + weight < dist[v]) {
                System.out.println("Graph contains negative-weight cycle.");
                return;
            }
        }

        // Print the shortest distances
        for (int i = 0; i < V; ++i) {
            System.out.println("Distance from source to vertex " + i + " is " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int V = 5;
        int E = 8;

        ShortestPathDP graph = new ShortestPathDP(V, E);

        graph.edges[0].src = 0;
        graph.edges[0].dest = 1;
        graph.edges[0].weight = -1;

        graph.edges[1].src = 0;
        graph.edges[1].dest = 2;
        graph.edges[1].weight = 4;

        graph.edges[2].src = 1;
        graph.edges[2].dest = 2;
        graph.edges[2].weight = 3;

        graph.edges[3].src = 1;
        graph.edges[3].dest = 3;
        graph.edges[3].weight = 2;

        graph.edges[4].src = 1;
        graph.edges[4].dest = 4;
        graph.edges[4].weight = 2;

        graph.edges[5].src = 3;
        graph.edges[5].dest = 2;
        graph.edges[5].weight = 5;

        graph.edges[6].src = 3;
        graph.edges[6].dest = 1;
        graph.edges[6].weight = 1;

        graph.edges[7].src = 4;
        graph.edges[7].dest = 3;
        graph.edges[7].weight = -3;

        int source = 0;
        graph.BellmanFord(source);
    }
}
