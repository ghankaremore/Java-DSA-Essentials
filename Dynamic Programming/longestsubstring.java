public class longestsubstring {
    public static void main(String[] args) {
        String a ="abdefgh";
        String b = "dfgheli";

        int[][] dp = new int[a.length()][b.length()];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(ls(0,0,a,b,dp,0));


    }
    static int ls(int i, int j, String a, String b, int[][] dp, int count){
        if(i==a.length()||j==b.length()){
            return count;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(a.charAt(i)==b.charAt(j)){
            count = ls(i+1,j+1,a,b,dp,count+1);
            dp[i][j]= count;

        }else{
            count = Math.max(count,Math.max(ls(i+1,j,a,b,dp,0),ls(i,j+1,a,b,dp,0)));
            dp[i][j]= count;

        }

        return count;
    }
}
