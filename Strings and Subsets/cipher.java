public class cipher {
    public static void main(String[] args) {
        String str = "middle-Outz";
        System.out.println(caesarCipher(str,2));


    }
    public static String caesarCipher(String s, int k) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        for(char ch : arr){
            if((ch<=122 && ch>=97) ||  ( ch>=65 && ch<=90) ){
                char c = (char)(ch + k);
                sb.append(c);


            }else{
                sb.append(ch);
            }
        }
        return sb.toString();

    }


}
