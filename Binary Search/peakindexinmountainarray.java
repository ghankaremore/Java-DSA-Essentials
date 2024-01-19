import java.util.Scanner;

public class peakindexinmountainarray {
   static boolean ascend;
    public static void main(String[] args) {
        int[] arr = {1, 2, 56, 15, 7, 3};
        System.out.println("Enter the target ");
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();

        System.out.println("The peak index is " + peakindex(arr));
        if (arr[peakindex(arr)] > target) {

            System.out.println("The index of targetelement " + search(arr,target,0,peakindex(arr)));
        } else {

            System.out.println("The index of targetelement " + search1(arr,target,peakindex(arr)+1,arr.length-1));
        }

    }
    static int peakindex(int[] arr){
        int start =0;
        int end = arr.length-1;
        while(end>=start){
            int mid = start + (end-start)/2;
            if(arr[mid+1]<arr[mid] && arr[mid-1]<arr[mid]){
                return mid;
            }else if(arr[mid+1]>arr[mid] && arr[mid-1]<arr[mid]){
              start = mid+1;
            }else if(arr[mid+1]<arr[mid] && arr[mid-1]>arr[mid]){
                end = mid-1;
            }
        }
        return -1;
    }
    static int search(int arr[],int target,int start,int end) {


        while (end >= start) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (target > arr[mid]) {

                    start = mid + 1;
                }else{


                    end = mid-1;
                }

            }

        return -1;

    }
    static int search1(int arr[],int target,int start,int end) {


        while (end >= start) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (target > arr[mid]) {
                end = mid-1;

            }else{


                start = mid + 1;
            }

        }

        return -1;

    }


}
