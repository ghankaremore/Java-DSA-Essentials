import java.util.Scanner;

public class splitarraylargestsum {
    public static void main(String[] args) {
        int[] arr = {7,2,5,8,10};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the target ");
        int target = sc.nextInt();
        int sum =0;
        int max =0;
        for(int i=0;i<arr.length;i++){
            sum +=arr[i];
            max = Math.max(arr[i],max);

        }
        System.out.println("The minimized sum is " + search(arr,target,max,sum));


    }
    static int search(int[] arr, int target, int start, int end ){
        int mid=0;

        while(start<end){
             mid = start + (end - start)/2;
             int sum=0;
            int count=1;
             for(int i=0;i<arr.length;i++){
                      if(sum+arr[i]>mid){
                          sum =arr[i];
                          count++;
                      }else{
                          sum+=arr[i];
                      }
             }
             if(count>target){
                 start = mid+1;
             }else{
                 end = mid;
             }
        }
        return end;
    }
}
