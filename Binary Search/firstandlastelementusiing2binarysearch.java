import java.util.Arrays;
import java.util.Scanner;

public class firstandlastelementusiing2binarysearch {
    public static void main(String[] args) {
        int[] arr= {1,2,2,5,7,7,7,9};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the target element ");
        int target = sc.nextInt();
        int[] finalarr = new int[2];
        finalarr[0]=giveelement1(arr,target);
        finalarr[1]=giveelement(arr,target);
        System.out. println(Arrays.toString(finalarr));

    }
    static int giveelement(int[] arr,int target){

        int start = 0;
        int index=-1;
        int end = arr.length-1;
        while(end>=start){
            int mid = start + (end-start)/2;
            if(arr[mid]==target){
                if(arr[mid+1]==target){
                    start = mid+1;
                }else{
                    return mid;
                }
            }else if(target > arr[mid]){
                start = mid+1;
            }else{
                end = mid-1;
            }


        }


        return -1;
    }
    static int giveelement1(int[] arr,int target){

        int start = 0;
        int index=-1;
        int end = arr.length-1;
        while(end>=start){
            int mid = start + (end-start)/2;
            if(arr[mid]==target){
                if(arr[mid-1]==target){
                    end = mid-1;
                }else{
                    return mid;
                }
            }else if(target > arr[mid]){
                start = mid+1;
            }else{
                end = mid-1;
            }


        }


        return -1;
    }
}
