import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println("Enter the number");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(fib(num));
        int[] dp = new int[num+1];
        for(int i=0;i<dp.length;i++){
            dp[i]=-1;
        }
        System.out.println(fibdp(num,dp));
        System.out.println(fibsp(num));
        System.out.println(fibtab(num,dp));
    }
    static int fib(int n){
        if(n<=1){
            return n;

        }
        return fib(n-1)+fib(n-2);
    }

    // Fibonacci using dynamic programming


    static int fibdp(int n, int[] dp){
        if(n<=1){
            dp[n]=n;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
            dp[n] = fibdp(n - 1,dp) + fibdp(n-2,dp);

            return dp[n];
        }

        //Spave optimization

    static int fibsp(int n){
        int prev=0;
        int prev1 = 1;
        if(n==0){
            return 0;
        }
        for(int i=2;i<=n;i++){
            int curr = prev1 + prev;
            prev = prev1;
            prev1 = curr;
        }
        return prev1;
    }
    static int fibtab(int n, int[] dp){
        dp[0] = 0;
        dp[1] = 1;
        for(int i =2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];

        }
        return dp[n];
    }


}
