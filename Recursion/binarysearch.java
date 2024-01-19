public class binarysearch {
    public static void main(String[] args) {
        int arr[]= {1,3,5,9,12};
        System.out.println(binarysearch(0,2,4,arr));

    }
    static int binarysearch(int start,int target,int end,int[] arr ){

        if(start>end){
  return -1;
        }
        int m = start + (end - start)/2;
            if(arr[m]==target)
        {
            return m;
        }
        if(arr[m]<target ){
           return  binarysearch(m+1,target,end ,arr);
        }
        return  binarysearch(start,target,m-1,arr);


    }
}
