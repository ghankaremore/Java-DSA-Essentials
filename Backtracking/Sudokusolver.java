import java.util.concurrent.locks.AbstractOwnableSynchronizer;

public class Sudokusolver {
    public static void main(String[] args) {
        int[][] sudokuGrid = new int[][]{
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };

        if(sudoku(sudokuGrid)==true){

            System.out.println("Yes sudoku cann be solved");
            display(sudokuGrid);
        }else{

            System.out.println("No sudoku can not be solved");
        }
    }
    static boolean sudoku(int[][] board){
boolean Emptyleft  = true;
int row = -1;
int col = -1;

 for(int m =0;m<board.length;m++){
     for(int n=0;n< board.length;n++){
         if(board[m][n]==0){
             row =m;
             col = n;
             Emptyleft = false;
             break;
         }
     }
     if(Emptyleft==false){
         break;
     }
 }

 if(Emptyleft == true){


     return true;
 }


            for (int i = 1; i <= 9; i++) {
                if (issafe(board,i,row,col)) {
                    board[row][col] = i;
                   if(sudoku(board)==true){
                       return true;
                   }else {
                       board[row][col] = 0;
                   }

                }
            }

        return false;


    }
    static void display(int[][] board){
        for(int i =0;i<board.length;i++){
            for(int j =0;j< board.length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    static boolean issafe(int[][] board, int i, int row, int col){
        for(int j =0;j< board.length;j++){
            if(board[row][j]==i){
                return false;
            }
        }
        for(int j =0;j< board.length;j++){
            if(board[j][col]==i){
                return false;
            }
        }
        int divider = (int)Math.sqrt(board.length);
        int rowstart = row - row%divider;
        int colstart = col - col%divider;
        int rowend =   row - row%divider + divider;
        int colend =   col - col%divider + divider;

       for(int j = rowstart;j<rowend;j++){
           for(int k = colstart;k<colend;k++){
               if(board[j][k]==i){
                   return false;
               }
           }
       }
       return true;
    }


}
