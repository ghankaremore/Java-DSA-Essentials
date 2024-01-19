class dicerolls {
    public static void main(String[] args) {
        System.out.println(numRollsToTarget(2,6,7));
    }
    public static int numRollsToTarget(int n, int k, int target) {
        return (numRolls(n,0,k,target,0)%(int)(Math.pow(10,9) +7));

    }
    public static int numRolls(int n, int  count, int k, int target, int sum){
        if(sum==target){
            return 1;
        }
        if(sum> target || count==n){
            return 0;
        }
        int ways =0;
        for(int i =1;i<=k;i++ ){
            ways = ways + numRolls(n,count+1,k,target,sum+i);
        }
        return ways;


    }
}