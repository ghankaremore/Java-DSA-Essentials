import java.util.Arrays;

public class Quicksort {
    public static void main(String[] args) {
        int arr[]  = {3,2,1,4,4};
        System.out.println("Before : " + Arrays.toString(arr));
        quicksort(arr,0,arr.length-1);
        System.out.println("After  : " + Arrays.toString(arr));

    }
    static void quicksort(int[] arr,  int low,int high){
        if(low>=high){
            return;
        }
        int i = low ;
        int j = high;
        int pivot = i + (j-i)/2;
       while(i<=j){

         while(arr[i]<arr[pivot]){
             i++;
         }
         while(arr[j]>arr[pivot]){
             j--;
         }
         if(i<=j){
             int temp = arr[i];
             arr[i] = arr[j];
             arr[j] = temp;
             i++;
             j--;
         }
     }
       quicksort(arr,low,j);
       quicksort(arr,i,high);
    }
}
