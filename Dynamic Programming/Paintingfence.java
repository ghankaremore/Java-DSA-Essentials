import java.util.Scanner;

public class Paintingfence {
    public static void main(String[] args) {
        System.out.print("Enter the no of posts in a fence ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print("Enter the no of colors ");
        int k = sc.nextInt();
        System.out.println("The number of ways are " + ways(n,k));
        int[] dp = new int[n+1];
        for(int i=0;i<dp.length;i++){
            dp[i] = -1;
        }
        System.out.println("The number of ways are " + waysdp(n,k,dp));
        System.out.println("The number of ways are " + waystab(n,k,dp));
        System.out.println("The number of ways are " + wayssp(n,k));

    }

    //Using recursion
    public static int ways(int n,int k){
        if(n==1){
            return k;
        }
        if(n==2){
            return k + k*(k-1);
        }
        int ans = ways(n-2,k)*(k-1) + ways(n-1,k)*(k-1);
        return ans;
    }
    //Recursion + Memoization

    public static int waysdp(int n,int k,int[] dp){
        if(n==1){
            dp[n] = k;
        }
        if(n==2){
           dp[n] = k + k*(k-1);
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        dp[n] = waysdp(n-2,k,dp)*(k-1) + waysdp(n-1,k,dp)*(k-1);
        return dp[n];
    }

    //Using tabulation
    static int waystab(int n,int k, int[] dp){

        dp[1] = k;
        dp[2] = k + k*(k-1);
        for(int i=3;i<=n;i++) {


            dp[i] = dp[i- 2] * (k - 1) + dp[i - 1] * (k - 1);
        }
        return dp[n];
    }

    //Using space optimization

    static int wayssp(int n, int k){
        int prev = k;
        int prev1 = k + k*(k-1);
        for(int i=3;i<=n;i++){
            int curr = prev*(k-1) + prev1*(k-1);
            prev1 = curr;
            prev = prev1;
        }
        return prev1;
    }



}
