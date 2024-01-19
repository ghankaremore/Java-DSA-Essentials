class Solution {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] =-1;
            }
        }
        int[] max = {Integer.MIN_VALUE};
        maximal(matrix,dp,0,0,max);
        return max[0]*max[0];

    }
    public int maximal(char[][] matrix, int[][] dp, int i, int j, int[] max){
        if(i>=matrix.length || j>=matrix[0].length){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int diagonal = maximal(matrix,dp,i+1,j+1,max);
        int right = maximal(matrix,dp,i,j+1,max);
        int bottom = maximal(matrix,dp,i+1,j,max);

        if(matrix[i][j]=='1'){
            dp[i][j] = 1 + Math.min(diagonal,Math.min(right,bottom));
            max[0] = Math.max(max[0],dp[i][j]);

            return dp[i][j];


        }else{
            return dp[i][j] =0;
        }
    }

}

