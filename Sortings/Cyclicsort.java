import java.util.Arrays;

public class Cyclicsort {

    public static void main(String[] args) {
        int[]  arr = {3,5,2,4,1};
        System.out.println("Original array " + Arrays.toString(arr));
        cyclicsort(arr);
        System.out.println("Sorted array " + Arrays.toString(arr));
    }
    static void cyclicsort(int[] arr){
        int i=0;
        int count=0;

        boolean isswap= true;
        while(i<arr.length){
            if(arr[i]==i+1){
                i++;
            }else{
                int temp = arr[i];
               arr[i] =  arr[arr[i]-1];
               arr[temp-1] = temp;
               count++;

            }

        }
        System.out.println("Number of swaps " + count);
    }
}
