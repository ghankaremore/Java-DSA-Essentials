import java.util.Scanner;

public class sqrt {
    public static void main(String[] args) {
        System.out.println("Enter the target ");
        Scanner sc = new Scanner((System.in));
        int target = sc.nextInt();
        System.out.println("Enter the decimal place");
        int decimal =sc.nextInt();

        double base = (double)root(target);

        System.out.println(base);
        for(int k =1;k<=decimal;k++) {
            double div = Math.pow(10,k);
            double i =0;
            double base1 = base;
            while (i < 10) {
                base += 1/ div;
                if (base * base < (double) target) {
                    i++;
                } else {if(k==decimal) {
                    System.out.printf("%.2f",(base - 1/div));
                }
                    base = base1 + (i) / div;
                    break;
                }

            }
        }

    }
    static int root(int target){
        int start = 0;
        int end = target;
        while(end>= start){
            int m= start + (end - start)/2;
            if(m*m==target){
                return m;
            }else if(m*m>target){
                end = m -1;
            }else{
                start = m+1;
            }
        }
        return end;
    }
}
