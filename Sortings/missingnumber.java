public class missingnumber {
    public static void main(String[] args) {
        int[] arr = {5,2,2,0};
        System.out.println("The missing element is " + missing(arr));
    }
    static int missing(int[] arr){
        int i=0;
        int prev = -1;
        while(i<arr.length){
            if(arr[i] ==i){
                i++;
            }else{
                if(arr[i]>=arr.length){

                        i++;



                }else{
                    int temp1 = arr[i];
                    arr[i] = arr[arr[i]];
                    arr[temp1] = temp1;
                    if(temp1==arr[i]){
                        i++;
                    }

                }
            }

        }
        int j=0;
        int count=0;
        for( j=0;j<arr.length;j++){
            if(arr[j]!=j){
                count++;
            }
        }
        if(j==arr.length-1){
            return arr.length;
        }
        return j;
    }
}
