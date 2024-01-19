import java.util.Arrays;

public class Houserobbery {
    public static void main(String[] args) {
        int arr[] = {3,5,7,8,10};
        if(arr.length==1){
            System.out.println(arr[1]);
        }else {
            int arr1[] = new int[arr.length - 1];
            int arr2[] = new int[arr.length - 1];
            for (int i = 0; i < arr.length - 1; i++) {
                arr1[i] = arr[i];
                arr2[i] = arr[i + 1];

            }

            System.out.println(Arrays.toString(arr1));
            System.out.println(Arrays.toString(arr2));
            int ans = Math.max(robbery(arr1,0),robbery(arr2,0));
            System.out.println(robbery(arr, 0));
            System.out.println(ans);
        }
    }
    static int robbery(int[] arr, int index){

        if(index>=arr.length ){
            return 0;
        }
        int incl = robbery(arr,index+2) + arr[index];
        int excl = robbery(arr,index+1);
        return Math.max(incl,excl);
    }
}
