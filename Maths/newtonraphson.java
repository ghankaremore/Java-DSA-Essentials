import java.util.Scanner;

public class newtonraphson {
    public static void main(String[] args) {
        System.out.println("Enter the target");
        Scanner  sc = new Scanner(System.in);
        int target = sc.nextInt();
        System.out.println(sqrt(target));

    }
    static double sqrt(int target){
        double x = target;
        double root ;
        while(true){
             root = 0.5*(x  + target/x);
             if(Math.abs(root - x)<0.5){
                 break;
             }
                 x = root;

        }
        return root;


    }
}
