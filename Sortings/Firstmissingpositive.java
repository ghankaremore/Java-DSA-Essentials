public class Firstmissingpositive{
    public static void main(String[] args) {
        int[] arr = {7,8,9,11,12};
        System.out.println("The missing positive number " + missingpositive(arr));
    }
    static int missingpositive(int[] arr){
        int i=0;
        int j=0;

        while(i<arr.length){
            int correct = arr[i];
            if(correct>=0 && correct < arr.length && arr[i] != arr[correct] && arr[i]<arr.length ){
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;

            }else{
                i++;
            }
        }
        for( j=1;j<arr.length;j++){
            if(arr[j]!=j){
                return j;
            }

        }
        return j;
    }
}
