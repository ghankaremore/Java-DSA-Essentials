import java.util.Scanner;

public class factorial {
    public static void main(String[] args) {
        System.out.println("Enter the target ");
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        System.out.println(factorial(target));

    }
    static int factorial(int n){
        if(n==1){
            return 1;
        }
        return n*factorial(n-1);
    }

}

