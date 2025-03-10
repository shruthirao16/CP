package CP;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/*
You are given an array consisting of N integers, and an integer, K.
Your task is to determine the minimum element in subarrays of size K.

Sample Input1:
--------------
5
10 12 14 11 15
3

Sample Output1:
---------------
10 11 11

Sample Input2:
--------------
5
5 2 1 1 1
4

Sample Output2:
---------------
1 1

 */
public class p7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(func(arr, k));
    }
    public static ArrayList<Integer> func(int[] arr, int k){
        ArrayList<Integer> al = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();
        for(int i=0; i<arr.length; i++){
            while(!dq.isEmpty() && dq.peekFirst()<i-k+1){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && arr[dq.peekFirst()]>arr[i]){
                dq.pollFirst();
            }
            dq.offer(i);

            if(i>=k-1){
                al.add(arr[dq.peekFirst()]);
            }
        }
        return al;
    }
}
