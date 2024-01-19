import java.util.Scanner;

public class Rotatedbinarysearch {
    public static void main(String[] args) {
               int[] arr = {5,6,1,2,3,4};
        System.out.println("Enter the target ");
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        System.out.println("The target is found at an index " + recbinsearch(arr,0,arr.length-1,target ));
    }
    static int recbinsearch(int[] arr, int start, int end, int target) {
      if(start>end) {
          return -1;
      }
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else {
                if(arr[start] < arr[mid]) {
                    if (target >= arr[start] && target < arr[mid]) {
                        return recbinsearch(arr, start, mid - 1, target);
                    }else {


                        return recbinsearch(arr, mid + 1, end, target);
                    }

                } else {
                    if (target > arr[mid] && target <= arr[end]) {
                        return recbinsearch(arr, mid + 1, end, target);
                    }
                        else {

                        return recbinsearch(arr, start, mid - 1, target);
                    }

                }
            }

    }
}
