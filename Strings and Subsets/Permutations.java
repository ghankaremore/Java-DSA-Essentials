import java.util.ArrayList;

public class Permutations {
    public static void main(String[] args) {
        String str = "abc";
        permutations("",str);
        System.out.println();
        System.out.println(permutationsarraylist("",str));
        System.out.println("The count of permutations is " + permutationscount("",str));
        System.out.println("The count of permutations is " + permutationscount1("",str,0));

    }
    static void permutations(String p, String up){
        if(up.isEmpty()){
            System.out.print(p + " ");
            return;
        }
        char ch = up.charAt(0);
        for(int i =0;i<=p.length();i++){
            String f = p.substring(0,i);
            String s =  p.substring(i,p.length());
            permutations(f+ch+s,up.substring(1));

        }
    }
    static ArrayList<String> permutationsarraylist(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> arr = new ArrayList<>();
         arr.add(p);
            return arr;
        }
        ArrayList<String> ans = new ArrayList<>();

        char ch = up.charAt(0);
        for(int i =0;i<=p.length();i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());

            ans.addAll(permutationsarraylist(f + ch + s, up.substring(1)));

        }
        return ans;
    }

    static int permutationscount(String p, String up){
        if(up.isEmpty()){


          return 1;

        }

        int count =0;

        char ch = up.charAt(0);
        for(int i =0;i<=p.length();i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());

            count = count + permutationscount(f + ch + s, up.substring(1));

        }
       return count;


    }
    static int permutationscount1(String p, String up, int count){
        if(up.isEmpty()){


            return count + 1;

        }



        char ch = up.charAt(0);
        for(int i =0;i<=p.length();i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());

            count =  permutationscount1(f + ch + s, up.substring(1), count);

        }
        return count;


    }
}
