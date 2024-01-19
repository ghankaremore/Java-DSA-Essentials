import java.util.Arrays;

public class mergesortinplace {
    public static void main(String[] args) {
        int[] arr = {3,1,6,4,9,0};
        System.out.println("Array before sorting " + Arrays.toString(arr));
        mergesort(arr,0,arr.length);
        System.out.println("Arrays after sorting " + Arrays.toString(arr));

    }
    static void mergesort(int arr[], int start, int end){
        if(end - start ==1){
            return;
        }
        int mid = (end   + start  )/2;
        mergesort(arr,start,mid);
        mergesort(arr, mid,end);
        merge(arr, start,mid,end);
    }
    static void merge(int arr[], int start, int mid, int end){
        int[] mix = new int[end-start ];
        int i=start ;
        int j =mid;
        int k =0;
      while(i< mid && j <end){
          if(arr[i]<arr[j]){
              mix[k] = arr[i];
              i++;
              k++;
          }else{
              mix[k] = arr[j];
              j++;
              k++;
          }
      }
      while(i<mid){
          mix[k] = arr[i];
          i++;
          k++;

      }
      while(j<end){
          mix[k] = arr[j];
          j++;
          k++;

      }
      for(int m =0;m<mix.length;m++){
          arr[start + m] = mix[m];
      }
    }
}
