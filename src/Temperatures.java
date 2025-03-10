import java.util.*;
public class Temperatures {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int res=0;
        int[][] arr = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
            res += temp(arr[i], 0, n-1);
        }
        System.out.println(res);

    }
    public static int temp(int[] arr, int low, int high){
        int count=0;
        if(low>high) return count;
        int mid = low + (high - low) / 2;

        if (arr[mid] >= 0) {
            count+= temp(arr, mid+1, high);
        }
        else if(arr[mid]<0){
            count++;
            count+= temp(arr, low, mid - 1);
            count+= temp(arr, mid + 1, high);
        }
        return count;
    }
}







//Given a m x n matrix temperatureGrid representing the recorded
//temperatures in a region over several days. The matrix is sorted
//in non-increasing order both row-wise and column-wise, meaning
//the temperatures are getting colder as you move right or down.
//Each temperature is recorded in degrees Celsius.
//
//You are tasked with determining the number of freezing temperature
//readings in the grid. In this case, a freezing temperature is
//defined as any temperature less than 0°C.
//
//        Constraints:
//        ------------
//m == temperatureGrid.length
//n == temperatureGrid[i].length
//1 <= m, n <= 100
//        -100 <= temperatureGrid[i][j] <= 100
//
//
//Input Format:
//        -------------
//Line-1: two space separated integers, M and N
//Next M lines : N space separated integers, temperatures grid.

//Output Format:
//        -------------
//        An integer, number of freezing temperatures
//
//
//Sample Input-1:
//        ---------------
//        4 4
//        10 5 2 -1
//        7 3 0 -2
//        5 2 -2 -4
//        2 -1 -3 -6
//
//Sample Output-1:
//        ----------------
//        7
//
//Explanation:
//        ------------
//There are 7 freezing temperatures (< 0°C) in the matrix:
//        -1, -2, -2, -4, -1, -3, -6.
//
//Sample Input-2:
//        ---------------
//        1 3
//        12 95 4
//
//Sample Output-2:
//        ----------------
//        0
//
//Explanation:
//        ------------
//There are no freezing temperatures in the matrix.
