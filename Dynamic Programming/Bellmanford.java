import java.util.Arrays;
import java.util.Scanner;

public class Bellmanford {
    public static void main(String[] args) {
        System.out.println("Please enter the source node ");
        Scanner sc = new Scanner(System.in);
        int src = sc.nextInt();
        int[][] graph = {{0,4,5,-1},
                {4,0,-10,-1},
                {5,-10,0,3},
                {-1,-1,3,0}
        };
        int[] dist = new int[graph.length];
        System.out.println(Arrays.toString(bellman(src,graph,dist)));

    }
    public static int[] bellman(int src, int[][] graph, int[] dist){
        for(int i=0;i<dist.length;i++){
            dist[i] = Integer.MAX_VALUE;

        }
        dist[src]=0;
        for(int k=1;k<=4;k++) {
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph.length; j++) {
                    if (graph[i][j] != -1) {
                             if(dist[i]!=Integer.MAX_VALUE && dist[i]+graph[i][j]<dist[j]){
                                       graph[i][j] = dist[i] + graph[i][j];
                                       dist[j] = dist[i] + graph[i][j];
                        }
                    }
                }
            }
        }
return dist;
    }
}
