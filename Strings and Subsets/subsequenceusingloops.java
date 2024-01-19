import java.util.*;

public class subsequenceusingloops {
    public static void main(String[] args) {
        int arr[] = {1,2,3};
        int arr1[] = {1,2,2};
        List<List<Integer>> answer = ans(arr);
        System.out.println(answer);
        System.out.println(ansduplicate(arr1));


    }
    static List<List<Integer>>  ans(int[] arr){
        List<List<Integer>> outer = new ArrayList<>() ;
        outer.add(new ArrayList<>());
        for(int num : arr){
            int n= outer.size();
            for(int i = 0;i<n;i++){
                ArrayList<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);

            }
        }


        return outer;
    }
    static List<List<Integer>>  ansduplicate(int[] arr){
        int start =0;
        int end = 0;
        Arrays.sort(arr);

        List<List<Integer>> outer = new ArrayList<>() ;
        outer.add(new ArrayList<>());
        for(int j =0;j<arr.length;j++){
             start = 0;
            if(j>0 && arr[j] == arr[j-1]){
                start = end+1;
            }
            end = outer.size()-1;
            int n= outer.size();
            for(int i = start;i<n;i++){
                ArrayList<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(arr[j]);
                outer.add(internal);

            }
        }


        return outer;
    }
}
