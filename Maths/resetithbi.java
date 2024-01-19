import java.util.Scanner;

public class resetithbi {
    public static void main(String[] args) {
        System.out.println("Enter the target");
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        System.out.println("Enter the bit no");
        int bit = sc.nextInt();
        int a = ~(1<<(bit-1));
        int ans =  target&a;
        System.out.println("The " + bit + " of " + target + " is  " + ans);

    }
}
