import java.util.Arrays;

public class Selectionsort {
    public static void main(String[] args) {
        int[] arr = {1,4,3,2,1};
        System.out.println("Original Array : " + Arrays.toString(arr));
        selectionsort(arr);
        System.out.println("Sorted Array : " + Arrays.toString(arr));

    }
    static void selectionsort(int[] arr){
        for(int i=0;i<arr.length;i++){
            int max=0;
            for(int j=0;j<arr.length-i;j++){
                if(arr[j]>arr[max]){
                    max = j;
                }

            }
          int  temp =  arr[arr.length-i-1] ;
            arr[arr.length-i-1] = arr[max];
            arr[max] = temp;

        }
    }
}
