import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class knap {
    int weight ;
    int value;
    double ratio;
    public knap(int weight, int value){
        this.weight = weight;
        this.value = value;
        this.ratio = value/weight;
    }


}
class comparator implements Comparator<knap> {
    @Override
    public int compare(knap k1, knap k2) {
        if (k1.ratio < k2.ratio) {
            return 1;
        } else if (k2.ratio < k1.ratio) {
            return -1;
        }
        return 0;
    }
}

public class Fractionalknapsack {
        public static void main(String[] args) {
          int[] weight = {10,20,30};
          int[] value = {60,100,120};
            System.out.println("Enter tge maximum weight ");
            Scanner sc = new Scanner(System.in);
            int maxweight = sc.nextInt();
            System.out.println(fracknap(weight,value,maxweight));
        }
        public static int fracknap(int[] weight, int[] value, int max){
            PriorityQueue<knap> q
                    = new PriorityQueue<knap>(
                    weight.length, new comparator());
            for(int i=0;i<weight.length;i++){
                q.add(new knap(weight[i],value[i]));
            }
            int ans =0;
            int maxw =0;
           while(true){
               knap k1 = q.poll();
               if(maxw == max) {
                   break;
               }

              else if(maxw + k1.weight>max){
                  ans = (int) (ans  +  (max-maxw)*k1.ratio);
                  maxw = maxw + max-maxw;
               }else{

                   ans = ans + k1.value;
                   maxw = maxw + k1.weight;
               }


           }
           return ans;


        }
    }




