import java.util.Scanner;

public class maximumwealth {
    public static void main(String[] args) {
        System.out.println("Enter the array ");
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[3][3];
        for(int i =0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(maximumwealth1(arr));
    }

    static int maximumwealth1(int[][] arr){
        int maxwealth =0;
        int richestindex=0;

        for(int i=0;i<arr.length;i++){
            int wealth=0;
            for(int j=0;j< arr[i].length;j++){
                wealth+=arr[i][j];
            }
            if(wealth>maxwealth){
                maxwealth= wealth;
                richestindex=i;
            }

        }
        return maxwealth;
    }
}
