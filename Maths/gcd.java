import java.util.Scanner;

public class gcd {
    public static void main(String[] args) {
        System.out.println("ENTER a");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println("ENTER b");
        int b = sc.nextInt();
        System.out.println("HCF : " + gcd(a,b));
        System.out.println("LCM : " + lcm(a,b));

    }
    static int gcd(int a,int b){
        if(a==0){
            return b;
        }
        return gcd(b%a,a);
    }
    static int lcm(int a , int b){
        return (a*b)/gcd(a,b);
    }
}
