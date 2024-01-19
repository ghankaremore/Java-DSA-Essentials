public class lcs {
     public static void main(String[] args) {
          String a ="abdefgh";
          String b = "dfgheli";

          int[][] dp = new int[a.length()][b.length()];
          for(int i=0;i<dp.length;i++){
               for(int j=0;j<dp[0].length;j++){
                    dp[i][j]=-1;
               }
          }
          System.out.println(lc(0,0,a,b,dp));


     }
    static int lc(int i, int j,String a, String b, int[][] dp){
          if(i==a.length()||j==b.length()){
               return 0;

          }
          if(dp[i][j]!=-1){
               return dp[i][j];
          }
          if(a.charAt(i)==b.charAt(j)){
               dp[i][j]= 1 + lc(i+1,j+1,a,b,dp);
               return dp[i][j];
          }else{
              dp[i][j]= Math.max(lc(i+1,j,a,b,dp),lc(i,j+1,a,b,dp));
               return dp[i][j];
          }




    }
}
