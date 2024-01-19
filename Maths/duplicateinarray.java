public class duplicateinarray {
    public static void main(String[] args) {
        int[] arr= {2,1,1,3,2,4,5,4,5};
        System.out.println("The unique element is " + ans(arr));
    }
    static int ans(int[] arr){
        int unique =0;
        for(int num : arr){
            unique^=num;
        }
        return unique;
    }
}
