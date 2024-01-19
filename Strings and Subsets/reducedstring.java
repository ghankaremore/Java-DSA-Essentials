public class reducedstring {
    public static void main(String[] args) {
        String str = "baab";
        System.out.println("The reduced string is "+ superReducedString(str,-1));
    }
   static int count = -1 ;
    public static String superReducedString(String s,int count) {
        // if(s.isEmpty()){
        //     if(s1.length()>1){
        //         superReducedString(s1, "");
        //     }
        //     return s1;
        // }
        // if(s.charAt(0)==s.charAt(1)){
        //     return superReducedString(s.substring(2),s1);
        // }else{
        //     return superReducedString(s.substring(1), s1+s.charAt(1));
        // }

        String ans = "";
        int i =0;
        while(i<s.length()-1){

            if(s.charAt(i) == s.charAt(i+1)){
                i+=2;

            }else{
                ans+=s.charAt(i);
                i++;
            }

        }
        while(i<s.length()){
            ans+=s.charAt(i);
            i++;
        }
        if(count == ans.length()){
            return ans;
        }
        count = ans.length();
        if(ans.length()>1){


            superReducedString(ans,count);
        }
        if(ans.isEmpty()){
            return "Empty String";
        }
        return ans;

    }
}
