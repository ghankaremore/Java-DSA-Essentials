import java.util.ArrayList;
import java.util.Arrays;

public class Missingnumbers  {
    public static void main(String[] args) {
        int[] arr = {1,2,2,4};
        System.out.println("The missing element is " + missing(arr));
    }
    static <Integer> ArrayList missing(int[] arr){
       ArrayList<java.lang.Integer> arr1 = new ArrayList<>();
        int i=0;
        int prev = -1;

        while(i<arr.length){
            int correct = arr[i]-1;
            if(arr[i] !=arr[correct]){
                int temp1 = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp1;
            }else if(arr[i]==arr[correct]){
                i++;
            }


        }
        int j=0;
        int k=0;

        for( j=0;j<arr.length-1;j++){
            if(arr[j]!=j+1){
                arr1.add(j+1);

            }
        }

        return arr1;
    }
}
