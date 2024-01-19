import java.util.Scanner;

public class Nnights {
    public static void main(String[] args) {
        System.out.println("Enter the length or breadth of the board ");
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        boolean[][] board = new boolean[length][length];
        System.out.println("Enter the no of nights ");
        int target = sc.nextInt();

        System.out.println("The number of ways the knights can be played are "+ nknihghts(board,0,0,0,target));

    }
    static int nknihghts(boolean[][] board, int row , int col, int num, int target){
        if(num == target){
            display(board);
            System.out.println();
            return 1;
        }
        if( row==board.length-1 && col == board.length-1){
            return 0;
        }
        int count = 0;
        if(col == board.length){
          count+= nknihghts(board, row+1, 0, num , target);
       return 1;

        }

        if(issafe(board,row,col)){


                board[row][col] = true;
              count+= nknihghts(board, row, col+1, num +1, target);
                board[row][col] = false;



        }
        count +=nknihghts(board,row,col+1,num,target);
        return count;

    }
   static boolean issafe(boolean[][] board, int row, int col){

        if((row +1 <board.length  &&  row +1 >=0 && col -2 < board.length && col -2 >=0  &&board[row +1][col -2]==true)|| (row -1 <board.length && row -1>=0 && col -2 < board.length && col -2>=0 &&board[row -1][col -2]==true)||(row +2 <board.length && row + 2>=0  && col +1 < board.length && col +1 >=0 &&board[row +2][col +1]==true)
                ||(row +2 <board.length && row +2 >=0 && col -1 < board.length && col -1 >=0 &&board[row +2][col -1]==true)
                ||(row -1 <board.length && row -1>=0 && col -1 < board.length  && col -1 >=0&&board[row -1][col -1]==true)||(row -2 <board.length && row -2 >= 0&&  col +1 < board.length && col +1>=0 &&board[row -2][col +1]==true)||(row +1 <board.length && row +1 >=0  && col +2 < board.length && col +2>=0 &&board[row +1][col +2]==true)||(row -2 <board.length && row -2>= 0 &&  col +2 < board.length && col +2 >=0 &&board[row -2][col +2]==true)){
            return false;
        }else{
            return true;
        }

    }
    static void display(boolean[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if (board[i][j] == false) {

                    System.out.print("X ");
                }else{
                    System.out.print("K ");
                }

            }
            System.out.println();
        }
    }

}
