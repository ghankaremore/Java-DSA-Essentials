import java.util.ArrayList;

public class Setmismatch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 4};
        System.out.println("The missing element is " + setmismatch(arr));
    }
    static ArrayList<Integer> setmismatch(int[] arr){
        ArrayList<Integer> finalarr = new ArrayList<>();
        int i=0;
        while(i<arr.length){
            int correct = arr[i]-1;
            if(arr[i]!=arr[correct]){
                int temp = arr[i];
               arr[i] = arr[correct];
               arr[correct] = temp;

            }else if(arr[i]==arr[correct] && i!=correct){
                finalarr.add(arr[i]);
                i++;

            }else{
                i++;
            }
        }
        for(int j=0;j<arr.length;j++){
            if(arr[j]!=j+1){
                finalarr.add(j+1);

            }
        }

        return finalarr;
    }
}
