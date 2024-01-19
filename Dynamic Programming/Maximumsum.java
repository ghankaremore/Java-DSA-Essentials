public class Maximumsum {
    public static void main(String[] args) {
        int arr[] = {1,3,7,9,11};
        System.out.println(Math.min(max(arr,0),max(arr,1)));
        System.out.println(maxi(0,arr));
        int[] dp = new int[arr.length];
        for(int i =0;i<dp.length;i++){
            dp[i]=-1;
        }
        int[] dp1 = new int[arr.length];
        System.out.println(maxidp(0,arr,dp));
        System.out.println(maxitab(arr,dp1));
        System.out.println(maxisp(arr));

    }
    //Wrong logic
    static int max(int[] arr, int index){
        if(index == arr.length-1||index== arr.length-2){
            return index;
        }
        int maximum = 0;
        int ans = max(arr,index+2);
        if(ans>maximum){
            maximum = ans;
        }
        for(int i=index;i<arr.length;i++){

            if(arr[i]>maximum){
                maximum = arr[i];
            }
        }
        return arr[index]+ maximum;
    }

    //Right logic
    static int maxi(int index, int arr[]){
        if(index>=arr.length){
            return 0;
        }
        int incl = maxi(index+2,arr) + arr[index];
        int excl = maxi(index+1,arr);
        return Math.max(incl,excl);

    }
    // Recursion and memoization
    static int maxidp(int index, int arr[],int[] dp){
        if(index>=arr.length){
            return 0;
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        int incl = maxi(index+2,arr) + arr[index];
        int excl = maxi(index+1,arr);
        dp[index] =  Math.max(incl,excl);
        return dp[index];

    }
    //Tabulation method
    static int maxitab(int[] arr,  int[] dp){
           dp[0] = arr[0];
           dp[1] = arr[1];
        for(int i=2;i<arr.length;i++){
            int incl = dp[i-2] + arr[i];
            int excl = dp[i-1];
            dp[i] = Math.max(incl,excl);


        }
        return dp[arr.length-1];
    }
    //Space optimization
    static int maxisp(int[] arr){
        int prev = arr[0];
        int prev1 = arr[1];
        for(int i=2;i<arr.length;i++){
            int incl = prev + arr[i];
            int excl = prev1;
            int curr = Math.max(incl,excl);
            prev = prev1;
            prev1 = curr;


        }
        return prev1;
    }


}
