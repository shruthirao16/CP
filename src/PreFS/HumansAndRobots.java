package PreFS;
import  java.util.*;

/*
You are given an n x n matrix consisting of cells containing either 'X' (representing humans)
or 'O' (representing robots). A human ('X') will become a robot ('O') if it is surrounded in
all four cardinal directions (up, down, left, and right) by robots ('O').

Write a function that takes the matrix as input and returns the no of new humans after all
transformations are applied. The transformation rules should be applied simultaneously for
all humans in the matrix.


input:
5 5
O X O X O
O X O O O
O X O X O
O O X O O
O O O X O
2

5 5
O X O X X
O O X O O
O X O X O
O O O O O
X X O X X
3

 */


public class HumansAndRobots {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        char[][] mat = new char[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                mat[i][j] = sc.next().charAt(0);
            }
        }
        System.out.println(noOfNewHumans(mat, m, n));
    }
    public static int noOfNewHumans(char[][] mat, int m, int n){
        int[][] dist = {{0,1}, {-1,0}, {0,-1}, {1,0}};
        int count=0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j]=='X'){
                    int c=0;

                    for(int[] dir: dist){
                        int nx = i+dir[0];
                        int ny = j+dir[1];

                        if(nx>=0 && ny>=0 && nx<m && ny<n && mat[nx][ny]=='O'){
                            c++;
                        }
                    }
                    if(c==4) count++;
                }
            }
        }
        return count;
    }
}

//public static int noOfNewHumans(char[][] mat, int m, int n){
//    Queue<int[]> q = new LinkedList<>();
//    int[][] dist = {{0,1}, {1,0}, {-1,0}, {0,-1}};
//    int count=0, totalCount=0;
//
//    for(int i=0; i<m; i++){
//        for(int j=0; j<n; j++){
//            if(mat[i][j]=='X'){
//                //q.add(new int[]{i,j});
//                for(int[] dir: dist){
//                    int ni = i+dir[0];
//                    int nj = j+dir[1];
//
//                    if(ni>=0 && nj>=0 && ni<m && nj<n && mat[ni][nj]=='O'){
//                        count++;
//                    }
//                }
//                if(count==4) totalCount++;
//                count=0;
//                mat[i][j] = '0';
//            }
//        }
//    }
//    return totalCount;
//}