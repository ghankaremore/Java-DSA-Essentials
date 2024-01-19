public class sidewaysjump {
    public static void main(String[] args) {
        int stones[] = {0,1,2,3,0};
        int[][] dp = new int[stones.length-1][4];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(minsideways(stones,0,2,dp));

    }
    public static int minsideways(int stones[], int pos, int currlane, int[][] dp){
        if(pos==stones.length-1){
            return 0;
        }
        if(dp[pos][currlane]!=-1){
            return dp[pos][currlane];
        }
        if(stones[pos+1]!=currlane){
            return minsideways(stones,pos+1,currlane,dp);
        }else{
            int ans = Integer.MAX_VALUE;
            for(int i=1;i<=3;i++){
                if(currlane!=i  && stones[pos]!=i){

                    ans = Math.min(1 + minsideways(stones,pos,i,dp),ans) ;
                }
            }
            dp[pos][currlane] = ans;
            return dp[pos][currlane];
        }

    }
}
