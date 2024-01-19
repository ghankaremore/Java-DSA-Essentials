import java.util.Scanner;

public class Reversenumber {
    public static void main(String[] args) {
        System.out.println("Enter the target ");
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int sum =0;
        System.out.println(reversenumber(target,sum));

    }
  ;
    static int reversenumber(int n, int sum){

        if(n==0){
            return sum;
        }
        sum = sum*10;
        sum += (n%10);


        return reversenumber(n/10,sum);
    }
}
