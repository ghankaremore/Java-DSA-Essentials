public class basicskipa {
    public static void main(String[] args) {
        String a = "bcacdae";
        String str = "bccdahapplechh" ;

        System.out.println("The ans1 is " +  ans1(a,""));
        System.out.println("The ans2 is " + ans(a));
        System.out.println("The ans3 is " + ans3(str));

    }
    static String ans(String str){
        if(str.isEmpty()){

            return "";
        }
        if(str.charAt(0) !='a'){
            return str.charAt(0)+ ans(str.substring(1));
        }
        return ans(str.substring(1));
    }


    static String ans1(String str, String answ){

        if(str.isEmpty()){
            return answ;
        }
        if(str.charAt(0)!='a'){

            return ans1(str.substring(1),answ + str.charAt(0));



        }else {


            return ans1(str.substring(1), answ);
        }






    }
    static String ans3(String str){
        if(str.isEmpty()){

            return "";
        }
        if(!str.startsWith("apple") ){
            return str.charAt(0)+ ans3(str.substring(1));
        }
        return ans3(str.substring(5));
    }
}


