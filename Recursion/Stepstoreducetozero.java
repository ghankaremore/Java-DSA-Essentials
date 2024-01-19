import java.util.Scanner;

public class Stepstoreducetozero {
    public static void main(String[] args) {
        System.out.println("Enter the no ");
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        System.out.println("The number of steps taken to reduce the number to zero are " + steps(target,0));
    }
    static int steps(int n,int step){
        if(n<=0){
            return step;
        }
        if(n%2==0){
            step++;
            return steps(n/2,step);
        }else{
            step++;
            return steps((n-1)/2,step);
        }
    }

}
