
import java.util.Scanner;
public class Optimisedprimeseive {
    public static void main(String[] args) {
        System.out.println("Enter the number");

        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        boolean[] arr = new boolean[target+1];

        optimisedprime(target,arr);
        for(int i =2;i<=target;i++){
            if(arr[i]!=true){
                System.out.println(i);
            }
        }



    }

    static void optimisedprime(int target,boolean[] arr){

        for(int i =2;i<=Math.sqrt(target);i++) {
            if(!arr[i]){
                int j =i;
                int k=2;
                while(i*k<=target){

                    arr[i*k] = true;


                    k++;
                }
            }

        }
    }
}
