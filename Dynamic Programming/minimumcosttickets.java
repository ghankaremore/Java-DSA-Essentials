public class minimumcosttickets {
    public static void main(String[] args) {
        int[] days ={2,5};
        int[] cost ={1,4,25};
        int[] dp = new int[days.length];
        for(int i=0;i<dp.length;i++){
            dp[i] = -1;
        }
        System.out.println(mincost(cost,days,dp,0));

    }
    public static int mincost(int[] cost, int[] days, int[] dp, int index){
        if(index>=days.length){
            return 0;
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        int first = cost[0] + mincost(cost,days,dp,index+1);



            int count = index;
            while (count < days.length && days[count] < days[index] + 7) {
                count++;
            }


            int second = cost[1] + mincost(cost, days, dp, count);



        int count1=index;
        while(count1 < days.length && days[count1] < days[index] + 30){
            count1++;
        }
        int third = cost[2] + mincost(cost,days,dp,count1);
        int mini = Math.min(Math.min(first,second),third);
        dp[index] = mini;
        return dp[index];

    }
}
