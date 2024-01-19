import java.util.Scanner;

public class Cuttingrod {
    public static void main(String[] args) {
        System.out.println("Enter the length of the rod ");
        Scanner sc = new Scanner(System.in);
        int rod = sc.nextInt();
        System.out.println("Enter the length of the segements ");
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        System.out.println("The ways are " + max(rod,x,y,z));
        System.out.println("The number of segments are "+ maxseg(rod,x,y,z));
        int[] dp = new int[rod+1];
        for(int i=0;i<dp.length;i++){
            dp[i] =-1;
        }
        System.out.println("Using dp "+ maxdp(rod,x,y,z,dp));
        System.out.println("Using tabulation " + maxtab(rod,x,y,x,dp));
        System.out.println("Using difffernt tabulation " + maxtab1(rod, x,y,x));

    }
    //Counting the number of ways rod can be dividing into these segments
    static int max(int n, int x, int y, int z){
        if(n < 0){
            return 0;
        }
        if(n == 0){
            return 1;
        }
        int ways = max(n - x, x, y, z) + max(n - y, x, y, z) + max(n - z, x, y, z);
        return ways;
    }

    //Counting the maxinmum no of segements the rod can be cut into
    static int maxseg(int n, int x, int y, int z){
        if(n==0){
            return 0;
        }
        if(n<0){
            return Integer.MIN_VALUE;
        }
        int a = 1 + maxseg(n-x,x,y,z);
        int b = 1 + maxseg(n-y,x,y,z);
        int c = 1 + maxseg(n-z,x,y,z);
        int maxsegements = Math.max(c,Math.max(a,b));
        if(maxsegements!=Integer.MIN_VALUE){
            return maxsegements;
        }
        return 0;

    }
    //Counting the maximum no of segements the rod can be cut into
//    Recursion + Memoization
   static  int maxdp(int n , int x, int y, int z, int[] dp){
       if(n==0){
           return 0;
       }
        if(n<0){
           return Integer.MIN_VALUE;
        }

        if(dp[n]!=-1){
            return dp[n];
        }
        int a = 1 + maxdp(n-x,x,y,z,dp);
        int b = 1 + maxdp(n-y,x,y,z,dp);
        int c = 1 + maxdp(n-z,x,y,z,dp);
        int maxsegements = Math.max(c,Math.max(a,b));
        if(maxsegements!=Integer.MIN_VALUE){
            dp[n] =  maxsegements;
        }else{
            dp[n] =0;

        }
        return dp[n];



    }
    //Using tabulation
    //Wrong in some text cases
    static int maxtab(int n, int x, int y, int z, int[] dp){
        dp[0] =0;
        dp[1] = 0;
        dp[2] = 1;
        int a = 1 + dp[n-x];
        int b = 1 + dp[n-y];
        int c = 1 + dp[n-z];
        int maxsegements = Math.max(c,Math.max(a,b));
        return maxsegements;




    }
    static int maxtab1(int n, int x, int y, int z){
        int dp[] = new int[n+1];
        for(int i=0;i<n;i++){
            dp[i] = -1;
        }
        dp[0] =0;

     for(int i=1;i<=n;i++){
         if(i-x >=0 && dp[i-x]!=-1){
             dp[i] = Math.max(dp[i],dp[i-x]+1) ;
         }
         if(i-y >=0 && dp[i-y]!=-1){
             dp[i] = Math.max(dp[i],dp[i-y]+1) ;
         }
         if(i-z >=0 && dp[i-z]!=-1){
             dp[i] = Math.max(dp[i],dp[i-z]+1) ;
         }

     }
     if(dp[n]<0){
         return 0;
     }else {
         return dp[n];
     }



    }
//    static int maxsp(int n, int x, int y, int z){
//        int prev2 =0;
//        int prev1 = 0;
//        int prev = 1;
//        int a = 1 + dp[n-x];
//        int b = 1 + dp[n-y];
//        int c = 1 + dp[n-z];
//        int maxsegements = Math.max(c,Math.max(a,b));
//        return maxsegements;
//
//
//
//
//    }
}
