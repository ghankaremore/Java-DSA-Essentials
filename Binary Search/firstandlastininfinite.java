import java.util.Arrays;
import java.util.Scanner;

public class firstandlastininfinite {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 5, 7, 7, 7, 9};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the target element ");
        int target = sc.nextInt();
        System.out.println("The index of the first occurence is " + check(arr,target));



    }


    static int findceiling(int[] arr, int target,int start,int end){


        while(end>=start){

           int mid = start + (end-start)/2;

            if(arr[mid]==target){
                return mid;
            }else if(target>arr[mid]){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }

        return -1;
    }

    static int check(int[] arr,int target){
        int start =0;
        int end = 1;
        while(target>arr[end]){
            int newstart = end +1;
            end = end + 2*(end-start +1);
            start = newstart;
        }
        return findceiling(arr,target,start,end);
    }

}
