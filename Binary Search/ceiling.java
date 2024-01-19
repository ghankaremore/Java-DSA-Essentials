import java.util.Scanner;

public class ceiling {
    public static void main(String[] args) {
        char[] arr ={'a','c','e','g','i','t','x'};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the target element ");
        char target = 'x';


            System.out.println("The ceiling is " + findceiling(arr, target));



    }
    static char findceiling(char[] arr, int target){
        int start = 0;
        int end = arr.length-1;

int mid=0;
        while(end>=start){

             mid = start + (end-start)/2;

            if(arr[mid]==target){
                start = mid+1;
            }else if(target>arr[mid]){
                start = mid+1;
            }else{
                  end = mid-1;
            }
        }

        return arr[start% arr.length];
    }
}
