import java.util.ArrayList;

public class decimal {
    public static void main(String[] args) {
        ArrayList<String >  arr = new ArrayList<>();
        System.out.println(fn("",arr));

    }
    static ArrayList<String> fn(String answ,ArrayList<String> arr){
        if(answ.length()>=3 ){
            arr.add(answ);
            return arr ;
        }

        for(int i=0;i<=9;i++){

            String ch = i+ "";
            if( ch.equals("2") && answ.endsWith("2")){
                continue;
            }else {
                fn(answ + ch, arr);
            }
        }
        return arr;

    }
}

