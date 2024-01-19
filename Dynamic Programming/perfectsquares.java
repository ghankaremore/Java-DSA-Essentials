import java.util.Scanner;

public class perfectsquares {
    public static void main(String[] args) {
        System.out.println("Enter the target number ");
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int[] dp = new int[target+1];
        for(int i=0;i<dp.length;i++){
            dp[i] =-1;
        }
        System.out.println(perfect(target,dp));
        System.out.println(tab(target));

    }
    public static int perfect(int n, int[] dp){
        if(n==0){
            return 0;
        }
//        if(n<0){
//            return -1;
//        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int mini = Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
            int ans = 1+ perfect(n-(i*i),dp);

                mini = Math.min(mini,ans);


        }
//        if(mini == Integer.MAX_VALUE){
//            dp[n] = -1;
//        }else{
//            dp[n] = mini;
//        }
        dp[n] = mini;
        return dp[n];


    }

    public static int tab(int n){
        int[] dp = new int[n+1];
        for(int i=0;i<dp.length;i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j*j<=n;j++){
                if(i-(j*j)>=0) {
                    dp[i] = Math.min(dp[i], 1 + tab(i - (j * j)));
                }
            }
        }
        return dp[n];
    }
}
