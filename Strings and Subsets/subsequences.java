import java.util.ArrayList;

public class subsequences {
    public static void main(String[] args) {
        String str = "abc";
        ArrayList<String >  arr = new ArrayList<>();
//        System.out.println(ans(str,"",arr));
        System.out.println(ans1(str,""));
    }

    static ArrayList<String > ans(String str, String answ, ArrayList<String> arr){

        if(str.isEmpty()){
            arr.add(answ);
            return arr;

        }
       ans(str.substring(1),answ + str.charAt(0),arr);
      ans(str.substring(1),answ,arr);
     return arr;

    }

    static ArrayList<String > ans1(String str, String answ){

        if(str.isEmpty()){
            ArrayList<String> arr = new ArrayList<>();
            arr.add(answ);
            return arr;

        }
      ArrayList<String> right=   ans1(str.substring(1),answ + str.charAt(0));
       ArrayList<String> left =  ans1(str.substring(1),answ);
        right.addAll(left);
        return right;

    }
}
