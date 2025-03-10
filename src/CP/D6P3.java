package CP;

import java.util.Arrays;
import java.util.Scanner;

/*
You are given an array people where people[i] is the weight of the ith person,
and an infinite number of boats where each boat can carry a maximum weight of limit.
Each boat carries at most two people at the same time,
provided the sum of the weight of those people is at most limit.

Return the minimum number of boats to carry every given person.

Example 1:

Input: 2
1 2
3
Output: 1
Explanation: 1 boat (1, 2)
Example 2:

Input:4
3 2 2 1
3
Output: 3
Explanation: 3 boats (1, 2), (2) and (3)
Example 3:

Input:4
3 5 3 4
5
Output: 4
Explanation: 4 boats (3), (3), (4), (5)

 */
public class D6P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int limit = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(minBoats(arr, limit));
    }
    public static int minBoats(int[] arr, int limit){
        Arrays.sort(arr);
        int l=0, r=arr.length-1, count=0;
        while(l<=r){
            while(arr[l]+arr[r]<=limit){
                 l++;
            }
            count++; r--;
        }
        return count;
    }
}
