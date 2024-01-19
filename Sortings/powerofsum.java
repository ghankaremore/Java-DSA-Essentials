import java.io.*;
import java.util.*;

public class powerofsum{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int power = sc.nextInt();
        System.out.println(countSumPower(num,power,1,0,0));
    }

    public static int countSumPower(int num, int power, int curr, int carry, int count){
        int sum = carry + (int) Math.pow(curr,power);
        if (sum == num)
            return 1;
        else if (sum > num)
            return 0;

        count += countSumPower(num, power, curr+1, sum, 0); // choose curr
        count += countSumPower(num, power, curr+1, carry, 0); // dont choose curr

        return count;
    }
}
