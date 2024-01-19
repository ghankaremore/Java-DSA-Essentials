import java.util.Scanner;

public class Knapsack {
    public static void main(String[] args) {
        int[] weight = {5,7,3,3};
        int[] value = {10,12,8,6};
        System.out.println("Enter the maximum weight ");
        Scanner sc = new Scanner(System.in);
        int capacity = sc.nextInt();
        System.out.println(knap(weight,value,weight.length-1,capacity));
        int[][] dp = new int[weight.length][capacity+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        System.out.println();
        System.out.println();
        System.out.println("Total Weight: " + capacity);
        System.out.println("Total Value: " + knapdp(weight,value, weight.length-1,capacity,dp));



    }
    //Using recursion
    public static int knap(int[] w,int[] v,int index, int capacity){
        if(index==0) {
            if (w[index] <= capacity) {
                return v[index];
            } else {
                return 0;
            }
        }
            int include =0;
             if(w[index]<=capacity){
                 include = v[index] + knap(w,v,index-1,capacity-w[index]);
             }
             int exclude = knap(w,v,index-1,capacity);

             int ans = Math.max(include,exclude);
             return ans;
        }


        //Using recursion + Memoization

    public static int knapdp(int[] w, int[] v, int index , int capacity, int[][] dp ){
        if(index==0) {
            if (w[index] <= capacity) {
                return v[index];
            } else {
                return 0;
            }
        }

        if(dp[index][capacity]!=-1){
            return dp[index][capacity];
        }
        int include =0;
        if(w[index]<=capacity){
            include = v[index] + knapdp(w,v,index-1,capacity-w[index],dp);
        }
        int exclude = knapdp(w,v,index-1,capacity,dp);

        dp[index][capacity] = Math.max(include,exclude);
        return dp[index][capacity];
    }

    //Using tabulation
    public static int knaptab(int[] w, int[] v,  int capacity){
        int[][] dp = new int[w.length][capacity+1];

            for (int i = w[0]; i <= capacity; i++) {
                if (w[0]<=capacity){
                    dp[0][i] = v[0];
                }else{
                    dp[0][i] = 0;
                }
            }

            for(int i=1;i<w.length;i++){
                for(int j=0;j<=capacity;j++){
                    int include =0;
                    if(w[i]<=j){
                        include = v[i] + dp[i-1][j-w[i]];
                    }
                    int exclude = dp[i-1][j];
                    dp[i][j]= Math.max(include,exclude);


                }
            }
            return dp[w.length-1][capacity];

    }

    // space optimization
    public static int knapsp(int[] w, int[] v, int capacity){
        int[] prev = new int[capacity+1];
        int[] curr = new int[capacity+1];

        for (int i = w[0]; i <= capacity; i++) {
            if (w[0]<=capacity){
                prev[i] = v[0];
            }else{
                prev[i] = 0;
            }
        }
        for(int i=1;i<w.length;i++){
            for(int j=0;j<=capacity;j++){
                int include =0;
                if(w[i]<=j){
                    include = v[i] + prev[j-w[i]];

                }
                int exclude = prev[j];
                curr[j]= Math.max(include,exclude);


            }
            prev = curr;
        }
        return prev[capacity];


    }



}
