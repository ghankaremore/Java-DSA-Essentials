import java.util.Scanner;

public class sumofdigits {
    public static void main(String[] args) {
        System.out.println("Enter the target ");
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        System.out.println(sumofdigits(target));
    }
    static int sumofdigits(int n){
        if(n==0){
            return 0;
        }
        return n%10 + sumofdigits(n/10);
    }
}
