import java.util.Scanner;

public class Minimiumnoofcoins {
    public static void main(String[] args) {
        int coins[] = {1,2,5};
        System.out.println("Enter the number");
        Scanner sc = new Scanner(System.in);
        int target= sc.nextInt();
        System.out.println(minimum(coins,target));
        int[] dp = new int[target+1];
        for(int i=0;i<dp.length;i++){
            dp[i] = -1;
        }
        System.out.println(minimumdp(coins,target,dp));
        int[] num = new int[target+1];

        System.out.println(minimumtab(dp,coins));


    }
    //Using recusion
    static int minimum(int coins[], int amount){
        if(amount==0){
            return 0;
        }
        if(amount<0){
            return 0;
        }
        int mini = Integer.MAX_VALUE;

        for(int i =0;i<coins.length;i++) {
            int ans =  minimum(coins, amount-coins[i]);

                mini = Math.min(mini,1+ans);

        }
        return mini;
    }

    //Using dynamic programming
    static int minimumdp(int coins[], int amount, int dp[]){
        if(amount==0){
            return 0;
        }
        if(amount<0){
            return -1;
        }
        if(dp[amount]!=-1){
            return dp[amount];
        }
        int mini = Integer.MAX_VALUE;

        for(int i =0;i<coins.length;i++) {
            int ans =  minimumdp(coins, amount-coins[i],dp);
            if(ans!=-1){
                mini = Math.min(mini,1+ans);
                dp[amount] = mini;
            }
        }
        return dp[amount];
    }
    //Tabulation method
    static int minimumtab(int[] dp, int coins[]){
        dp[0] = 0;
        for(int i =1;i<dp.length;i++){

            for(int j=0;j<coins.length;j++){
                if(i-coins[j]>=0 ){
                    dp[i] = Math.min(dp[i],1+dp[i-coins[j]]);


                }

            }

        }
        return dp[dp.length-1];
    }

}
