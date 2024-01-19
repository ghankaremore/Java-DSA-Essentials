import java.util.Arrays;
import java.util.Scanner;

public class firstandlastelement {
    public static void main(String[] args) {
        int[] arr= {1,2,2,5,7,7,7,7,9};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the target element ");
        int target = sc.nextInt();
        System.out.println(Arrays.toString(giveelement(arr,target)));
    }
    static int[] giveelement(int[] arr,int target){
        int[] finalarr = new int[2];
        int start = 0;
        int index=-1;
        int end = arr.length-1;
        while(end>=start){
            int mid = start + (end-start)/2;
            if(arr[mid]==target){
                index = mid;
                break;
            }else if(target > arr[mid]){
                start = mid+1;
            }else{
                end = mid-1;
            }


        }
        if(index==-1){
            finalarr[0]=-1;
            finalarr[1]=-1;
        }else{
           int temp = index;
           int temp1 = index;
           finalarr[0] = temp;
           finalarr[1] = temp;

                if(arr[index + 1] == target) {
                    while (arr[index + 1] == target) {
                        index += 1;
                    }

                    finalarr[1]=index;
                }
            if(arr[temp1 - 1] == target) {
                while (arr[temp1 - 1] == target) {
                    temp1 -= 1;
                }
                finalarr[0] = temp1;

            }




        }
        return finalarr;
    }
}
