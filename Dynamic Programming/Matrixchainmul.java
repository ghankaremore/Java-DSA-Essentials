public class Matrixchainmul {
    public static void main(String[] args) {
        int arr[] = {1,3,2,5,4};
        System.out.println(mincost(arr,5));

    }
    public static int mincost(int[] arr, int n){
        int[][] dp = new int[n][n];
        for(int len = 2;len<n;len++){

            for(int row = 0, col = len;row<n-len;row++,col++){
                dp[row][col]= Integer.MAX_VALUE;
                for(int k =row+1;k<col;k++){
                     dp[row][col] = Math.min(dp[row][col],dp[row][k] + dp[k][col]+ arr[row]*arr[col]*arr[k]);

                }
            }

        }
        return dp[0][n-1];
    }
}
