public class longestcommonsubstring {
    public static void main(String[] args) {
        int ans = longestsubstring("Ghanshyam","Ghansoshya");
        System.out.println(ans);
    }
    public static int longestsubstring(String s1, String s2){
        return longest(s1,s2,0,0,0);
    }
    public static int longest(String s1, String s2, int i, int j, int count){
        if(i>=s1.length() || j>= s2.length()){
            return count;
        }
        int sum =count;
        int exclude = 0;
        if(s1.charAt(i)==s2.charAt(j)){
            sum = longest(s1,s2,i+1,j+1,count+1);
        }

            int diff1 = longest(s1, s2, i + 1, j, 0);
            int diff2 = longest(s1, s2, i, j + 1, 0);


        return Math.max(sum,Math.max(diff1,diff2));
    }
}
