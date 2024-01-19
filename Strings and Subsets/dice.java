public class dice {
    public static void main(String[] args) {
        String str = "123456";
        ans(4,"");

    }
    static void ans(int target, String p){
        if(target==0){
            System.out.print(p + " ");
            return;
        }
        for(int i =1;i<=target && i<=6;i++){
            ans(target -i,p + i);
        }
    }
}
