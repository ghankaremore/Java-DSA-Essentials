import java.util.Scanner;

public class Countingderrangements {
    public static void main(String[] args) {
        System.out.println("Enter the length ");
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        System.out.println(derrangements(length));
        int[] dp = new int[length+1];
        for(int i=0;i<dp.length;i++){
            dp[i] = -1;
        }
        System.out.println(derrangementsdp(length,dp));
        int[] dp1 = new int[length+1];
        System.out.println(derrangementstab(length,dp1));
        System.out.println(derrangementssp(length));
    }

    //Using recursion
    static int derrangements(int n){
        if(n==1){
            return 0;
        }
        if(n==2){
           return 1;
        }
        return n-1*(derrangements(n-1) + derrangements(n-2));
    }
    //Using recursion  + memoization
    static int derrangementsdp(int n, int[] dp){
        if(n==1){
            dp[n] = 0;
        }
        if(n==2){
            dp[n] = 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        dp[n] = n-1*(derrangementsdp(n-1,dp) + derrangementsdp(n-2,dp));
        return dp[n];
    }
    //Using tabulation
    static int derrangementstab(int n, int[] dp){
        dp[0] =0;
        dp[1] =0;
        dp[2] =1;
        for(int i=3;i<=n;i++) {
            dp[i] = i - 1 * (dp[i - 1] + dp[i - 2]);
        }
        return dp[n];

    }
    //Using space optimisation
    static int derrangementssp(int n){
        int prev =0;
        int prev1 = 1;
        for(int i=3;i<=n;i++){
            int curr = i-1*(prev1 + prev);
            prev = prev1;
            prev1 = curr;
        }
        return prev1;
    }

}
