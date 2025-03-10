package DAA;

import java.util.*;

class NoOfDistinctIslandsBFS {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int grid[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.println(DistinctIslands(grid));
    }

    public static int DistinctIslands(int[][] grid) {
        Set<String> islands = new HashSet<>();
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
                if(grid[row][col] == 1) {
                    String island = bfs(grid, row , col);
                    islands.add(island);
                }
            }
        }
        return islands.size();
    }

    public static String bfs(int[][] grid, int row, int col)
    {
        Queue<int[]> queue = new LinkedList<>();
// row, col
        int[][] dirs = {{1, 0},  {0, 1}, {-1, 0}, {0, -1}};
        char direction[] = {'d','r','u','l'};

        queue.offer(new int[]{row, col});

        int rows = grid.length;
        int cols = grid[0].length;

        StringBuilder builder = new StringBuilder();
        grid[row][col] = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int count=0;
                for(int[] dir : dirs) {
                    int r = cell[0] + dir[0];
                    int c = cell[1] + dir[1];

                    if(inBound(rows, cols, r, c) && grid[r][c] == 1) {
                        grid[r][c] = 0;
                        builder.append(direction[count]);
                        System.out.println("r " + r + " c " + c);
                        queue.offer(new int[]{r, c});
                    }
                    count++;
                }
                builder.append('b');
            }
        }
        System.out.println(builder.toString());
        return builder.toString();
    }

    private static boolean inBound(int rows, int cols, int row, int col) {
        return row >= 0 && col >= 0 && row < rows && col < cols;
    }
}
