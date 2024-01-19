public class rangeforx0r {
    public static void main(String[] args) {
        int a = 3;
        int b =9;
        System.out.println(xor(b)^xor(a-1));
    }
    static int xor(int n){
        if(n%4==0){
            return n;
        }
        if(n%4==1){
            return 1;
        }
        if(n%4==2){
            return n+1;
        }
        if(n%4==3){
            return 0;
        }
        return 0;
    }
}

