package PreFS;

import java.util.*;

/*
In a given array of numbers add two minimum numbers and retrieve that sum
add this sum to the remaining numbers and again add that to output sum

Given an array of integers, write a function that continuously adds the two minimum numbers
in the array, sums their values, and inserts the resulting sum back into the array.
This process is repeated until only one number remains in the array. The function should return
the total sum accumulated from all such additions.

Example:
Input:
nums = [4, 3, 2, 6]
Output:
29
 */

public class SumOfsums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(totalSum(arr,n));
    }
    public static int totalSum(int[] arr, int n){
        Queue<Integer> pq =new PriorityQueue<>();
        int totalsum = 0, curr=0;
        for(int i=0; i<n; i++){
            pq.offer(arr[i]);
        }
        while(pq.size()>1){
            int a = pq.poll();
            int b = pq.poll();
            curr = a+b;

            totalsum+= curr;
            pq.offer(curr);
        }
        return totalsum;
    }
}
