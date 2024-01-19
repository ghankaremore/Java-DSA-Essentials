import java.util.Scanner;

public class rightmostsetbit {
    public static void main(String[] args) {
        System.out.println("Enter the target");
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int i=0;
        while(true){
            if(((target>>i)&1)==1){
                break;
            }
            i++;
        }
        System.out.println(i+1);
    }
}
