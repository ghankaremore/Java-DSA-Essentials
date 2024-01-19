public class moorealgo {
    public static void main(String[] args) {
        int arr[] = {3,3,2,4,3,5,3};
        System.out.println(moore(arr));
    }
    static int moore(int[] arr){
        int count =0;
        int element = arr[0];
        count++;
        for(int i=1;i<arr.length;i++){
            if(count==0){
                element=arr[i];

            }
            if(arr[i]==element){
                count++;
            }else{
                count--;
            }



        }
        if(count>0){
            int count1=0;
            for(int i=0;i<arr.length;i++){
                if(arr[i] ==element){
                    count1++;
                }
            }
            if(count1>arr.length/2){
                return element;
            }else{
                return -1;
            }

        }else if(count==0){
            return -1;
        }
        return -1;
    }

}
