// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
      int[][] arr = {{1,2,3},
              {4, 5, 6 },
              {7,8,9}};
        System.out.println("Enter the target element ");
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        System.out.println(Arrays.toString(search(arr,target)));


    }
    static int[] search(int[][] arr, int target){
        int row = 0;
        int column = arr.length-1;
        while(column>=0&&row<arr.length) {
            if (target == arr[row][column]) {
                return new int[]{row, column};
            } else if (target > arr[row][column]) {
                row++;
            } else {
                column--;
            }
        }


return new int[]{-1,-1};

    }
}