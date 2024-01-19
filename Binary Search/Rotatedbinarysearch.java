import java.util.Scanner;

public class Rotatedbinarysearch {
    public static void main(String[] args) {
        int[] arr = { 2,9,2,2};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the target ");
       int target = sc.nextInt();
        if(binarysearch(arr,target,0,pivot(arr))!=-1){
            System.out.println(binarysearch(arr,target,0,pivot(arr)));
        } else{
       System.out.println(binarysearch(arr,target,pivot(arr)+1,arr.length-1));

     }


    }

    static int binarysearch(int[] arr,int target,int start,int end){


        while(end>=start){
            int mid = start + (end - start)/2;
            if((target == arr[mid]&&mid>start&&target!=arr[mid-1]) || target ==arr[mid] && mid==start ){
                return mid;
            }else if(target > arr[mid]){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return -1;
    }
    static int pivot(int[] arr){
         int start =  0;
         int end = arr.length-1;

         while(end>=start){
             int mid = start + (end-start)/2;
         if(  arr[mid]>arr[mid+1]&&arr[mid]>=arr[mid-1]){
             return mid;
         }else if(arr[mid+1]>=arr[mid]) {
             int temp = mid;
             boolean isbehind = false;
             while (mid > 0) {

                 if (arr[mid - 1] > arr[mid]) {
                     isbehind = true;
                 }
                 mid = mid - 1;

             }
             mid = temp;
             if (isbehind) {
                 end = mid- 1;
             } else {
                 start = mid + 1;
             }

         }
         }
         return -1;
    }
}
