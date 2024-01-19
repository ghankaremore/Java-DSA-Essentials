import java.util.ArrayList;

public class phoneno {
    public static void main(String[] args) {
        String a = "12";

        phone("",a);
        System.out.println();
        System.out.println(phonearray("",a));
    }
    static void  phone(String p, String up){
        if(up.isEmpty()){
            System.out.print(p + " ");
            return;
        }
        int id = up.charAt(0) - '0';
        for(int i =(id-1)*3;i<id*3;i++){
            char ch = (char)('a' + i);
            phone(p+ch,up.substring(1));
        }

    }
    static ArrayList<String>  phonearray(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> arr = new ArrayList<>();
           arr.add(p);
            return arr;
        }

        ArrayList<String>  ans = new ArrayList<>();
        int id = up.charAt(0) - '0';
        for(int i =(id-1)*3;i<id*3;i++){
            char ch = (char)('a' + i);
            ans.addAll(phonearray(p+ch,up.substring(1)));
        }
        return ans;

    }
}
