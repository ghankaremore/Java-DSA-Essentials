import java.util.Scanner;

public class graphcoloring {
    public static void main(String[] args) {
        int c_no;
        Scanner sc = new Scanner(System.in);
        c_no = sc.nextInt();
        int graph[][] = {
                { 0, 1, 1, 1 },
                { 1, 0, 1, 0 },
                { 1, 1, 0, 1 },
                { 1, 0, 1, 0 },
        };
        System.out.println(coloring(graph, c_no));
    }

    public static int coloring(int[][] graph, int numColors) {
        int V = graph.length;
        int[] color = new int[V];
        return ways(graph, color, numColors, 0, V);
    }

    public static boolean isSafe(int[][] graph, int v, int[] color, int c) {
        for (int i = 0; i < graph.length; i++) {
            if (graph[v][i] == 1 && color[i] == c) {
                return false;
            }
        }
        return true;
    }

    public static int ways(int[][] graph, int[] color, int numColors, int v, int V) {
        if (v == V) {
            return 1;
        }
        int ways = 0;

        for (int c = 1; c <= numColors; c++) {
            if (isSafe(graph, v, color, c)) {
                color[v] = c;
                ways = ways + ways(graph, color, numColors, v + 1, V);
                color[v] = 0;
            }
        }
        return ways;
    }
}
