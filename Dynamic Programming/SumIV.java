import java.util.Scanner;

public class SumIV {
    public static void main(String[] args) {
        int[] arr ={1,3,4,5};
        System.out.println("Enter the target ");
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        System.out.println(Sum(arr,target));
        int[] dp = new int[target+1];
        for(int i=0;i<dp.length;i++){
            dp[i]=-1;
        }
        System.out.println(sumdp(arr,target,dp));
        System.out.println(sumtab(arr,target));

    }

    //Using recursion
    static int Sum(int[] arr,int target){
        if(target==0){
            return 1;
        }
        if(target<1){
            return 0;
        }
        int ways =0;

        for(int i =0;i<arr.length;i++){
         ways = ways + Sum(arr,target-arr[i]);
        }
        return ways;
    }

    //Using DP
     static int sumdp(int[] arr, int target, int[] dp){
        if(target==0){
            return 1;
        }
        if(target<0){
            return 0;
        }
        if(dp[target]!=-1){
            return dp[target];
        }
        int ways =0;

        for(int i=0;i<arr.length;i++){
            ways = ways + sumdp(arr,target-arr[i],dp);
                    dp[target] = ways;
        }
        return dp[target];
    }

    //Using tabulation

    static int sumtab(int[] arr, int target){
        int[] dp = new int[target+1];
        dp[0] =1;
        for(int i=1;i<=target;i++){
            for(int j=0;j<arr.length;j++){
                if(i-arr[j]>=0){
                    dp[i] = dp[i] +  dp[i-arr[j]];
                }
            }
        }
        return dp[target];
    }



}
