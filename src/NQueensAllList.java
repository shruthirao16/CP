import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NQueensAllList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solveNQueens(n));
    }
    public static List<List<String>> solveNQueens(int n){
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(board[i],'.');
        }
        solve(res, board, 0, n);
        return res;
    }
    public static void solve(List<List<String>> res, char[][] board,int col, int n){
        if(col>=n){
            res.add(formatBoard(board, n));
            return;
        }
        for(int row=0; row<n; row++){
            if(isSafe(board, row, col)){
                board[row][col]='Q';
                solve(res, board, col+1, n);
                board[row][col]='.';
            }
        }
    }
    public static boolean isSafe(char[][] board, int row, int col){
        for(int i=col; i>=0; i--){
            if(board[row][i]=='Q'){
                return false;
            }
        }
        for(int i=row, j=col; i>=0 && j>=0;  i--, j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        for(int i=row, j=col; i<board.length && j>=0; i++, j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    public static List<String> formatBoard(char[][] board, int n){
        List<String> fmt = new ArrayList<>();
        for(int i=0; i<n; i++){
            fmt.add(new String(board[i]));
        }
        return fmt;
    }

}
//The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
//
//Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
//
//Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
//
//
//
//Example 1:
//
//
//Input: n = 4
//Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
//Example 2:
//
//Input: n = 1
//Output: [["Q"]]
//
//
//Constraints:
//
//        1 <= n <= 9