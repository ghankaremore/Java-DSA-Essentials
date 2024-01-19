import java.util.Scanner;

public class Binarycoefficient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the n ");
        int n = sc.nextInt();
        System.out.println("Enter the r");
        int r = sc.nextInt();
        int[] dp = new int[r + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = Math.min(i, r); j > 0; j--) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }

        System.out.println(dp[r]);
    }
}
