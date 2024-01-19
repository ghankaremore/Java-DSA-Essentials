import java.util.ArrayList;
import java.util.Arrays;

public class Findduplicate  {
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,2,3};
        System.out.println("The missing element is " + duplicate(arr));
    }
    static int duplicate(int[] arr){
        ArrayList<java.lang.Integer> arr1 = new ArrayList<>();
        int i=0;
        int prev = -1;

        while(i<arr.length){
            int correct = arr[i]-1;
            if(arr[i] !=arr[correct]){
                int temp1 = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp1;
            }else if(arr[i]==arr[correct]&& i!=correct){
                  i++;
               return arr[i];
            }else{
                i++;
            }


        }

        return -1;
    }
}
