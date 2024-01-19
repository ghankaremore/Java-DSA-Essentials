import java.util.Scanner;

public class backtrackingproblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int[][] maze = {{0,0,0},
                {0,0,0},
                {0,0,0}};
//        int[][] maze = {{0,0},
//                {0,0}};
        System.out.println();
         backtracking("",maze,0,0,1);
    }
    static void backtracking(String up, int[][] maze, int row, int col,int level){

        if(row==maze.length-1 && col==maze[0].length-1){
            maze[row][col]=level;

             for(int i =0;i<maze.length;i++){
                 for(int j =0;j<maze[0].length;j++){
                     System.out.print(maze[i][j]+ " ");
                 }
                 System.out.println();
             }


            System.out.print(up+" ");
            System.out.println();
            return ;
        }
        if(maze[row][col]!=0){
            return;
        }
        maze[row][col]=level;

//        if(row<maze.length -1 && col<maze[0].length-1) {
//
//            backtracking(up + "D",maze, row +1, col +1);
//        }
        if(row>0){
            backtracking(up + "U", maze,row-1, col,level+1);
        }
        if(col>0){
            backtracking(up + "L", maze,row, col-1,level+1);
        }
        if(row<maze.length-1){
            backtracking(up + "V", maze,row+1, col,level +1);
        }
        if(col<maze[0].length-1) {
            backtracking(up + "H", maze, row,col +1,level+1);
        }
        maze[row][col]=0;
    }
}
