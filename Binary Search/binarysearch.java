import java.util.*;
public class binarysearch {
    public static void main(String[] args) {
        int[] arr = new int[6];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array  elements ");
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the target element ");
        int target = sc.nextInt();
        System.out.println("The index is " + search(arr,target));

    }
    static int search(int arr[],int target) {
        int start = 0;
        int end = arr.length - 1;
        while (end >= start) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (target > arr[mid]) {
                if(isascending(arr)) {
                    start = mid + 1;
                }else{
                    end = mid-1;
                }

            } else {
                if(isascending(arr)) {
                   end = mid-1;
                }else{
                    start = mid+1;
                }

            }
        }
            return -1;

        }
        static boolean isascending(int[] arr) {
            if (arr[0] < arr[arr.length - 1]) {
                return true;
            }else{
                return false;
            }
        }
}

