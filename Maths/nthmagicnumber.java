import java.util.*;
public class nthmagicnumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the n");
        int target = sc.nextInt();
        System.out.println("Enter the mult");
        int mult = sc.nextInt();
        System.out.println("The magic number is " + givemagic(target,mult));


    }
    static int givemagic(int target, int mult){
        int i=0;
        int sum =0;
        while(target>0) {
            sum += (target&1) * Math.pow(mult, i+1);
            i++;
            target = target >> 1;
        }
        return sum;

    }

}
