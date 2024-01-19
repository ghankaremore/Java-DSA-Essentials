import java.util.Scanner;

public class Minimizedlargestsuminmsubarrays {
    public static void main(String[] args) {
        int[] arr = {7,2,5,8,10};
        System.out.println("Enter the tagert ");
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int max =0;
        int sum =0;
        for(int i=0;i<=arr.length-1;i++){
            sum+=arr[i];
            if(arr[i]>=max){
                max = arr[i];
            }
        }
        System.out.println("The minimized largest sum is "+ binarysearch(arr,max,sum,target));

    }
    static int binarysearch(int[] arr, int start , int end,int target){
        int mid=0;
        while(end>=start){
             mid = start + (end-start)/2;
            int i=0;
            int count=0;

            while(i<=arr.length-1) {
                int sum = 0;


                while (true) {


                    sum += arr[i];
                    i++;

                    if(sum <= mid ||i>arr.length-1) {
                       break;

                    }




                }

                count++;
            }
            if(count>=target){
                end = mid;
            }else{
                start = mid+1;
            }

        }
        return mid;
    }

}
