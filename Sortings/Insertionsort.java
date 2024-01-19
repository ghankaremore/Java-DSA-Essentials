import java.util.Arrays;

public class Insertionsort {
    public static void main(String[] args) {
        int[] arr= {5,1,3,2,1};
        System.out.println("Original Array " + Arrays.toString(arr));
        insertion(arr);
        System.out.println("Sorted Array " + Arrays.toString(arr));
    }
    static void swap(int[] arr, int start , int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
    static void insertion(int[] arr){
        for (int i=0;i<arr.length-1;i++){
            int j =i+1;
            while(j>0){
                if(arr[j]<arr[j-1]){
                    swap(arr,j-1,j);
                }else{
                    break;
                }
                j=j-1;
            }
        }
    }
}
