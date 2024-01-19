import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {


        String str = "AB";
        System.out.println(convert(str,3));


    }
         public  static String convert(String s, int numRows) {
         int diff = 2*numRows -2;
         int count =0;
         ArrayList<Integer> list = new ArrayList();
         while(count<s.length()){
            list.add(count);
            count= count+diff;
         }
         StringBuilder sb = new StringBuilder();
         for(int i=0;i<list.size();i++){
             sb.append(s.charAt(list.get(i)));
         }

         for(int i=1;i<numRows-1;i++){
             for(int j=0;j<list.size();j++){
                 if(list.get(j)-i>=0){
                      sb.append(s.charAt(list.get(j)-i));
                 }
                 if(list.get(j)+i<s.length()){
                     sb.append(s.charAt(list.get(j)+i));
                 }
             }
         }

         int count1 =numRows-1;;
         while(count1<s.length()){
             sb.append(s.charAt(count1));
             count1= count1 + diff;
         }
         return sb.toString();


     }
}