import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Subsetsumproblem {
    public static void main(String[] args) {
        int arr[] = {3,6,7,8,9,5};
        System.out.println("Enter the subset sum ");
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        ArrayList<ArrayList<Integer>> fin = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        boolean[] check = new boolean[arr.length];
        System.out.println(subset(arr,check,sum,fin,temp));
    }
    public static ArrayList<ArrayList<Integer>> subset(int[] arr,boolean[] check, int sum, ArrayList<ArrayList<Integer>> fin, ArrayList<Integer> temp){
        if(sum==0){
            ArrayList<Integer> subset = new ArrayList<>(temp);
            Collections.sort(subset);
            if(!fin.contains(subset)) {
//            System.out.println(temp);
//
//            return;
                fin.add(subset);
            }
            return fin;

        }
        if(sum<0){
            return fin ;
        }

        for(int i=0;i<arr.length;i++){
            if(arr[i]<=sum && check[i]!=true){
                check[i] = true;
                temp.add(arr[i]);
                 fin = subset(arr,check,sum-arr[i],fin,temp);
                check[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
        return fin;


    }
}
