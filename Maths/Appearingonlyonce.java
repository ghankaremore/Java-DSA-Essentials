public class Appearingonlyonce {
    public static void main(String[] args) {
        int[] arr={5,5,5,6,6,6,7,7,7,12,12,12,4};
        System.out.println("The unique is " + giveunique(arr));
    }
    static int giveunique(int[] arr){
        int sum =0;
        int result= 0;
        int j=0;
        int k=0;
        int[] fin = new int[8];
        while(k<8){
            int count=0;
            for(int i=0;i<arr.length;i++){
                if(((arr[i]>>k)&1)==1){
                    count++;
                }
            }
            fin[k] = count;
            k++;
        }

        for(int i=0;i< fin.length;i++){
           result+= ((fin[i])%3)*Math.pow(2,i);

        }
        return result;

    }

}
