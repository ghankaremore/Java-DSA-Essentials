import java.util.Scanner;

public class maze {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Give the input ");
        int input = sc.nextInt();
        System.out.println( ans(input,input));
        ans1("",input,input);
        System.out.println();
        ans2("",input,input);
        System.out.println();
        diagonal("",input,input);
        boolean[][] maze = {{true,true,true},
            {true,false,true},
            {true,true,true}};
        System.out.println();
        System.out.println("The number of steps with restrictions are   " + diagonalrestrictions("",maze,0,0));
    }

    static int ans(int row, int col){
        if(row==1 || col ==1){
            return 1;

        }
        int first=0;
        int second=0;
               first =  ans(row-1,col);
       second =  ans(row,col-1);
       return first + second;
    }
    static void ans1(String up, int row, int col){
        if(row==1){
            String temp = "";
            for(int i =0;i<col-row;i++){

                temp = temp +"R";
            }
            System.out.print(up+temp + " ");
            return ;
        }else if(col==1){
            String temp = "" ;
            for(int i =0;i<row-col;i++){

                temp = temp +"D";
            }
            System.out.print(up+temp + " ");
            return ;
        }
       ans1(up + "D", row-1, col);
        ans1(up + "R",row, col-1);

    }

    static void ans2(String up, int row, int col){
        if(row==1 && col==1){


            System.out.print(up+" ");
            return ;
        }


        if(row>1){
            ans2(up + "D", row-1, col);
        }
        if(col>1) {
            ans2(up + "R", row, col - 1);
        }

    }

    static void diagonal(String up, int row, int col){
        if(row==1 && col==1){


            System.out.print(up+" ");
            return ;
        }
         if(row>1 && col>1) {
             diagonal(up + "D", row - 1, col - 1);
         }

        if(row>1){
            diagonal(up + "V", row-1, col);
        }
        if(col>1) {
            diagonal(up + "H", row, col - 1);
        }

    }

    static int  diagonalrestrictions(String up, boolean [][] maze,int row, int col){
        if(row==maze.length-1 && col==maze[0].length-1){


            System.out.print(up+" ");
            return 1;
        }
        int first = 0;
        int second =0;
        int third = 0;
        if(maze[col][row]==false){
               return 0;
        }
//        if(row< maze.length-1 && col<maze[0].length-1) {
//            first = first + diagonalrestrictions(up + "D", maze,row + 1, col +1);
//        }

        if(row< maze.length-1){
             second =second +  diagonalrestrictions(up + "V", maze,row+1, col);
        }
        if(col<maze[0].length-1) {
             third = third +  diagonalrestrictions(up + "H", maze,row, col +1);
        }
        return   second +third;

    }

}
