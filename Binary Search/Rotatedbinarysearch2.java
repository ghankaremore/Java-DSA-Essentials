public class Rotatedbinarysearch2 {
    public static void main(String[] args) {
        int[] arr = { 3,4,5,6,7,0,1,2};
        System.out.println(pivot(arr));
    }
    static int pivot(int[] arr){
        int start =  0;
        int end = arr.length-1;
        int mid = start + (end-start)/2;
        while(end>=start){
            if(arr[mid]>arr[mid+1]&&arr[mid]>arr[mid-1]){
                return arr[mid];
            }else if(arr[mid+1]>arr[mid]) {
                int temp = mid;
                boolean isbehind = false;
                while (mid > 0) {

                    if (arr[mid - 1] > arr[mid]) {
                        isbehind = true;
                    }
                    mid = mid - 1;

                }
                mid = temp;
                if (isbehind) {
                    end = mid- 1;
                } else {
                    start = mid + 1;
                }

            }
        }
        return -1;
    }
}
