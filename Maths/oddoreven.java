import java.util.Scanner;

public class oddoreven {
    public static void main(String[] args) {
        System.out.println("Enter the number ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if((num&1)==1){
            System.out.println("The number " + num + " is odd ");
        }
        if((num&1)==0){
            System.out.println("The number " + num + " is even");
        }

    }
}

