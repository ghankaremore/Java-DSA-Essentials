import java.util.ArrayList;
import java.util.Scanner;

public class Optimisingfactors {
    public static void main(String[] args) {
        System.out.println("Enter the target ");
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        factors(target);

    }
    static void factors(int target){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i =1;i<=Math.sqrt(target);i++){
            if((target/i)==i){
                System.out.println(i + " ");
            }else if(target%i==0){
                System.out.println(i + " ");
                list.add(target/i);
            }
        }
        for(int i =list.size()-1;i>=0;i--){
            System.out.println(list.get(i) + " ");
        }
    }
}
