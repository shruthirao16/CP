import java.util.Scanner;

public class NQueensBoolean {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        System.out.println(solveNQueens(board,0, n));
    }
    public static boolean solveNQueens(int[][] board, int col, int n){
        if(col>=n) return true;

        for(int row=0; row<n; row++){
            if(isSafe(board, row, col)){
                board[row][col]=1;
                if(solveNQueens(board, col+1, n)){
                    return true;
                }
                board[row][col]=0;
            }
        }
        return false;

    }
    public static boolean isSafe(int[][] board, int row, int col){
        for(int i=col; i>=0; i--){
            if(board[row][i]==1){
                return false;
            }
        }
        for(int i=row, j=col; i>=0 && j>=0;  i--, j--){
            if(board[i][j]==1){
                return false;
            }
        }
        for(int i=row, j=col; i<board.length && j>=0; i++, j--){
            if(board[i][j]==1){
                return false;
            }
        }
        return true;
    }
}
