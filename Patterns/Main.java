
public class Main {
    public static void main(String[] args) {
        pattern9(4);
    }
    //Pattern : * * * *
    //              * * *
    //             * *
    //              *

    static void pattern(int n) {
        for (int i = n; i >= 1; i--) {
            for (int j = i; j >= 1; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    //Pattern : 1
    //          1 2
    //          1 2 3
    //          1 2 3 4
    //          1 2 3 4 5
    static void pattern1(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    //              *
//              * *
//              * * *
//              * * * *
    //Pattern : * * * * *
    //          * * * *
    //          * * *
    //          * *
//              *
    static void pattern2(int n) {

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = n + 1; i <= ((n * 2) - 1); i++) {
            for (int j = 1; j <= (2 * n - i); j++) {
                System.out.print("* ");
            }
            System.out.println();
        }


    }

    //correct
    static void pattern3(int n) {
        for (int i = 1; i <= (2 * n - 1); i++) {
            int k = i > n ? 2 * n - i : i;
            for (int j = 1; j <= k; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

//Pattern    *
//          * *
//         * * *
//        * * * *
//       * * * * *
//        * * * *
//         * * *      * *
//           *

    static void pattern4(int n) {
        int m = (2 * n) - 1;
        for (int i = 1; i <= m; i++) {
            int k = i > n ? 2 * n - i : i;
            int s = i > n ? m / ((2 * n - i) + 1) : m / (i + 1);
            if (i == n) {
                s = 0;
            }

            for (int j = 1; j <= s; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= k; j++) {
                System.out.print("* ");
            }
            for (int j = s + k; j <= m; j++) {

                System.out.print(" ");
            }

            System.out.println();
        }

    }

    //correct
    static void pattern5(int n) {
        for (int i = 1; i <= (2 * n - 1); i++) {
            int k = i > n ? 2 * n - i : i;
            for (int j = 1; j <= ((2 * n - 1)) - k; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= k; j++) {
                System.out.print("* ");
            }
//            for (int j = 1; j <= ((2 * n - 1)) - k; j++) {
//                System.out.print(" ");
//            }


            System.out.println();
        }
    }
//    pattern :      1
//                 2 1 2
//               3 2 1 2 3
//             4 3 2 1 2 3 4
//            5 4 3 2 1 2 3 4 5

    static void pattern6(int n) {
        for (int i = 1; i <= n; i++) {
             for(int j =1;j<=(n-i);j++){
                 System.out.print("  ");
             }
             for(int j=i;j>=1;j--){
                 System.out.print(j+" ");
             }
            for(int j=2;j<=i;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    static void pattern7(int n) {
        for (int i = 1; i <= (2*n -1); i++) {
            int k = i > n ? 2 * n - i : i;
            for(int j =1;j<=(n-k);j++){
                System.out.print("  ");
            }
            for(int j=k;j>=1;j--){
                System.out.print(j+" ");
            }
            for(int j=2;j<=k;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
//    pattern:  4 4 4 4 4 4 4
//              4 3 3 3 3 3 4
//              4 3 2 2 2 3 4
//              4 3 2 1 2 3 4
//              4 3 2 2 2 3 4
//              4 3 3 3 3 3 4
//              4 4 4 4 4 4 4
    static void pattern8(int n){
        for(int i =0;i<(2*n -1);i++){
            int m = i >=n ? 2 * n - i -2: i;
            int k =0;
            for(int j=0;j<n;j++){
                System.out.print(n-k+" ");
                if(k<m ){
                    k++;
                }
            }
            int s=0;
           for(int j =n;j<(2*n -1);j++){

               if(j>=(2*n -1-m)){
                   s++;
               }
               System.out.print(n-k+s+" ");
           }

            System.out.println();
        }
    }

    static void pattern9(int n){
        int n1= 2*n-1;
        for(int i=0;i<n1;i++){
            for(int j =0;j<n1;j++){
                System.out.print(n- Math.min(Math.min(j,i),Math.min(n1-i-1,n1-j-1))+" ");
            }
            System.out.println();
        }
    }

}
