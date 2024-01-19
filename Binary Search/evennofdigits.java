import java.util.Scanner;

public class evennofdigits {
    public static void main(String[] args) {
        System.out.println("Enter the array ");
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        for(int i =0;i<5;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("The count of element is " + giveelement(arr));
    }
    static int giveelement(int[] arr){

        int finlcount=0;
        for(int i=0;i< arr.length;i++){
            int count=1;
            while(arr[i]/10>0) {

                    count++;
                    arr[i]= arr[i]/10;

            }
            if (count%2==0) {
                finlcount++;
            }


        }
        return finlcount;
    }
}
