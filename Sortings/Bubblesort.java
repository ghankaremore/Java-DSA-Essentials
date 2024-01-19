import java.util.Arrays;

public class Bubblesort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        System.out.println("Original array " + Arrays.toString(arr));
        bubblesort(arr);
        System.out.println("Sorted array " + Arrays.toString(arr));
    }
    static void bubblesort(int[] arr){
  boolean swap;
        for(int i = 0;i<arr.length;i++){
            swap = false;
            for(int j=1;j< arr.length - i;j++){
                if(arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1]= temp;
                    swap = true;
                }

            }
            if(swap==false){
                break;
            }
        }

    }
}
