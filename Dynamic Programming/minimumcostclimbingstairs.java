import java.util.Scanner;

public class minimumcostclimbingstairs {
    public static void main(String[] args) {
        System.out.println("Enter the number");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(climb(num,0));
        int[] cost ={100,200,300,400,500};
        System.out.println(minimumcost(cost,cost.length));
        int[] dp = new int[cost.length];
        for(int i =0;i<dp.length;i++){
            dp[i] = -1;
        }
        System.out.println(minimumcostdp(cost,cost.length,dp));
        System.out.println(bottomup(cost,dp));
        System.out.println(minimumsp(cost));

    }
    //No of ways to climb the stairs
    static int climb(int n, int step){
        if(step==n){


            return 1;
        }
        if(step>n){
            return 0;
        }

        return climb(n,step+1) + climb(n,step+2);
    }
    //Min costto climb the tree
    static int minimumcost(int[] cost, int step){
        int ans = Math.min(minimum(step-1,cost),minimum(step-2,cost));
        return ans;
    }
    static int minimum(int step, int[] cost){
        if(step==1){
            return cost[1];
        }
        if(step==0){
            return cost[0];
        }

        return Math.min(minimum(step-1,cost),minimum(step-2,cost)) + cost[step];

    }
    //Using Dynamic Programming

    static int minimumcostdp(int[] cost, int step, int[] dp){
        int ans = Math.min(minimumdp(step-1,cost,dp),minimumdp(step-2,cost,dp));
        return ans;
    }
    static int minimumdp(int step, int[] cost, int[] dp){
        if(step==1){
            dp[step] = cost[1];
        }
        if(step==0){
            dp[step] = cost[0];

        }
        if(dp[step] !=-1){
            return dp[step];
        }

        dp[step] =  Math.min(minimum(step-1,cost),minimum(step-2,cost)) + cost[step];
        return dp[step];

    }
    //Bottom up approach
    static int bottomup(int[] cost, int[] dp){
        dp[0]=cost[0];
        dp[1]= cost[1];
        for(int i =2;i<cost.length;i++){
            dp[i] = cost[i] + Math.min(dp[i-1],dp[i-2]);
        }
        return Math.min(dp[cost.length-1],dp[cost.length-2]);
    }
    //Space optimization
    static int minimumsp(int[] cost){
        int prev =cost[0];
        int prev1 = cost[1];
        for(int i =2;i<cost.length;i++){
            int curr = Math.min(prev, prev1) + cost[i];
            prev = prev1;
            prev1 = curr;
        }
        return Math.min(prev1,prev);
    }

}
