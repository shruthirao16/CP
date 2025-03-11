package CP;

/*
Imagine you have a row of treasure chests, each containing a certain amount of gold coins.
However, some chests might contain the same amount of gold as others.

Your goal is to find a sequence of consecutive chests where no two chests have the same amount
of gold. Once you identify such a sequence, you must collect the maximum possible gold from one
of these unique sets.

Find the highest amount of gold you can gather by picking exactly one such sequence of chests
and collecting all the coins inside.

Input Format:
-------------
Line-1: An integer N, representing the Total number of treasure chest .
Line-2: Space-separated integers, representing the amount of gold in each treasure chest.

Output Format:
--------------
Line-1: A single integer, representisxxng the maximum sum of a contiguous subarray with all
unique elements.

Sample Input-1:
---------------
5
4 2 4 5 6

Sample Output-1:
----------------
17

Explanation:
-------------
The longest unique maximum gold is [2, 4, 5, 6] with a sum of 2 + 4 + 5 + 6 = 17.
This is the maximum possible sum that can be obtained.


Sample Input-2:
---------------
6
1 2 3 1 2 3

Sample Output-2:
----------------
6


Explanation:
------------
The longest unique maximum gold is [1, 2, 3] with a sum of 1 + 2 + 3 = 6.
This sum cannot be improved by choosing another unique subarray.

 */
import java.util.HashSet;
import java.util.Scanner;

public class D18P1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(maxSum(arr, n));
    }
    public static int maxSum(int[] arr, int n){
        HashSet<Integer> hs = new HashSet<>();
        int sum=0, maxSum=0, l=0;
        for(int r=0; r<n; r++){
            while(hs.contains(arr[r])){
                hs.remove(arr[l]);
                sum-=arr[l];
                l++;
            }
            hs.add(arr[r]);
            sum += arr[r];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
