import java.util.Scanner;

public class countzerores {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number " );
        int target = sc.nextInt();
        int count =0;
        System.out.println("The number of count is " + countzeroes(target,count));
    }
    static int countzeroes(int n,int count){
        if(n==0){
            return count;
        }
        if(n%10==0){
            count++;
        }
        return countzeroes(n/10,count);

    }
}
