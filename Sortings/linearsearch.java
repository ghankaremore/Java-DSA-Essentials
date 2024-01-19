import java.util.ArrayList;
import java.util.Scanner;

public class linearsearch {
    public static void main(String[] args) {
        int[]  arr = {3,4,2,6,25,2,5,2,2,2};
        System.out.println("Enter the element you wanto search ");
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        System.out.println(" The element is found at index " + search(arr,target,0));
        ArrayList<Integer> temp = new ArrayList<>();
        System.out.println("All occurences are at " + searchall(arr,target,0,temp));
        System.out.println("All occurences are at " + searchall1(arr,target,0));


    }
    static int search(int arr[], int target, int index){
        if(index>= arr.length){
            return -1;
        }
        if(arr[index] == target){
            return index;
        }else{
            return search(arr,target,index+1);
        }
    }
    static ArrayList<Integer> searchall(int arr[], int target, int index, ArrayList<Integer> temp){
        if(index>= arr.length){
            return temp;
        }
        if(arr[index] == target){
            temp.add(index);
            return searchall(arr,target,index+1,temp);
        }else{
            return searchall(arr,target,index+1,temp);
        }
    }

    static ArrayList<Integer> searchall1(int arr[], int target, int index) {
        ArrayList<Integer> temp = new ArrayList<>();
        if (index >= arr.length) {
            return temp;
        }
        if (arr[index] == target) {
            temp.add(index);

        }
            ArrayList<Integer> ans = searchall1(arr, target, index + 1);

        temp.addAll(ans);
        return temp;
    }


}
