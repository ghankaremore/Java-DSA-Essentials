// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int[]  arr = {3};
        System.out.println("The statement that the array is sorted is " + issortedarray(arr,0));


    }
    static boolean issortedarray(int[] arr,int i){

       if(i>=arr.length-1) {
           return true;
       }if(arr[i]>arr[i+1]){
               return false;
           }else{
               return issortedarray(arr,i+1);
           }

    }
}