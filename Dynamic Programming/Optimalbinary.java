public class Optimalbinary {
    public static void main(String[] args) {
        int[] keys ={10,20,30,40};
        int[] freq ={4,2,6,3};
        int[][] dp = new int[keys.length+1][keys.length+1];
        System.out.println(mincost(keys,freq,dp));
    }
    public static int mincost(int[] keys, int[] freq, int[][] dp){
        int n = keys.length;
        for(int len = 1;len<=n;len++){
            for(int row = 0,col = len;row<=n-len;row++,col++){
                dp[row][col] = Integer.MAX_VALUE;
                int sum = 0;
                for(int i = row+1;i<=col;i++){
                    sum = sum + freq[i-1];
                }
                for(int k = row;k<col;k++){

                  dp[row][col] = Math.min(dp[row][col],dp[row][k]+dp[k+1][col] +  sum);

                }
            }
        }
        return dp[0][n];
    }
}
