package CP;

import java.util.Scanner;

/*
In the enchanted kingdom of Lumina, a grand celebration is being prepared,
featuring a spectacular wall of bulbs that can toggle between calming blue and vibrant red light.

The grand sorcerer wants the entire wall to glow with a serene blue light for the festival.

However, the bulbs are currently in a mix of blue and red, and can only be changed by casting spells on either entire rows or columns.

As an adept apprentice, your task is to determine if it's possible to use these spells to turn all bulbs blue.
If it's possible, print "possible" else "impossible"

Constraints:
1 ≤ M, N ≤ 100
The grid contains only 0s (blue light) and 1s (red light).

Input Format:
The first line contains two space-separated integers, M and N, representing the dimensions of the grid.
The next M lines contain N space-separated integers each, describing the current state of each bulb (either 0 for blue or 1 for red).
Output Format:
"Possible"  if the transformation to all blue bulbs is feasible.
"Impossible"  if no sequence of toggles can achieve the goal.

Sample Input-1:
3 3
1 0 1
0 1 0
1 0 1
Sample Output-1:
possible

Explanation:
1) Toggle column 1 and column 3, the grid becomes:
0 0 0
1 1 1
0 0 0

2) Toggle row 2, the grid becomes:
0 0 0
0 0 0
0 0 0

3) Now, all bulbs emit blue light (0). Hence, output is possible.

Toggling the specified columns and row transforms all bulbs to blue, achieving the goal for the festival.


Sample Input-2:
3 3
1 0 0
0 1 0
0 0 0
Sample Output-2:
impossible
 */
public class D11P1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        bulb(grid, m, n);
    }
    public static void bulb(int[][] grid, int m, int n){
        for(int i=0; i<m; i++){
            boolean isSame = true, isComp = true;
            for(int j=0; j<n; j++){
                if(grid[i][j] != grid[0][j]){
                    isSame = false;
                }
                if(grid[i][j] != (1-grid[0][j])){
                    isComp = false;
                }
            }
            if(!isSame && !isComp){
                System.out.println("impossible");
            }
        }
        System.out.println("possible");

    }
}