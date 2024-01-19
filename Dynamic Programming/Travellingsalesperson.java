public class Travellingsalesperson {
    public static void main(String[] args) {
        int[][] graph = {
                {0, 29, 20, 21},
                {29, 0, 15, 17},
                {20, 15, 0, 28},
                {21, 17, 28, 0}
        };
        int n = graph.length;
        int[][] dp = new int[1<<n][n];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        int mask = (1<<n)-1;
        System.out.println(sales(0,mask,dp,graph));

    }
    public static int sales(int curr, int mask,int[][] dp, int[][] graph){
        int n = graph.length;
        if(mask==0){
            return graph[curr][0];
        }

        if(dp[mask][curr]!=-1){
            return dp[mask][curr];
        }


        int mincost = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if((mask & (1<<i))!=0){
                int newmask = mask ^ (1<<i);
                int cost = graph[curr][i] + sales(i,newmask,dp,graph);
                if(cost<mincost){
                    mincost = cost;
                }

            }
        }
        dp[mask][curr] = mincost;
        return mincost;


    }
}
