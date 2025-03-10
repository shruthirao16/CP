package DAA;

import java.util.*;

public class NoOfDistinctIslandsDFS {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] mat = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                mat[i][j] = sc.nextInt();
            }
        }
        System.out.println(distinctIslands(mat, m, n));
    }
    public static int distinctIslands(int[][] mat, int m, int n){
        boolean[][] vis = new boolean[m][n];
        Set<List<List<Integer>>> s = new HashSet<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                List<List<Integer>> island = new ArrayList<>();
                if(dfs(mat, i, j, i, j, vis, island, m, n)){
                    s.add(island);
                }
            }
        }
        return s.size();
    }
    public static boolean dfs(int[][] mat, int i0, int j0, int i, int j, boolean[][] vis, List<List<Integer>> island, int m, int n){
        int[][] dist = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        if(i>=0 && j>=0 && i<m && j<n && mat[i][j]==1 && !vis[i][j]){
            island.add(Arrays.asList(i-i0, j-j0));
            vis[i][j]=true;
            for(int d=0; d<4; d++) {
                dfs(mat, i0, j0, i + dist[d][0], j + dist[d][1], vis, island, m, n);
            }
        }
        else{
            return false;
        }
        return true;
    }
}




//Sample Input-1:
//        ---------------
//        5 5
//        0 1 0 1 1
//        1 1 1 0 1
//        0 1 0 1 0
//        1 0 1 1 1
//        1 1 0 1 0
//
//Sample Output-1:
//        ----------------
//        3
//
//Explanation-1:
//        ------------
//The unique patterns are as follows:
//        1			1 1		1
//        1 1 1		   1  	,	1 1
//        1		,
//