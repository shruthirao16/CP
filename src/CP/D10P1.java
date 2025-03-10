package CP;

import java.util.Arrays;
import java.util.Scanner;
/*
Given an array, rotate the array to the right by k steps, where k is non-negative. For example, if
our input array is [a, b, c, d, e] and k is 2, then the output should be [d, e, a, b, c].
We can solve this by having two loops again which will make the time complexity O(n^2) or by
using an extra, temporary array, but that will make the space complexity O(n).

example
input=5
a b c d e
2
output=d e a b c
 */
public class D10P1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] arr = new char[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.next().charAt(0);
        }
        int k = sc.nextInt();
        swap(arr, 0, n-1);
        swap(arr, 0, k-1);
        swap(arr, k, n-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void swap(char[] arr, int i, int j){
        while(i<j){
            arr[i] ^= arr[j];
            arr[j] ^= arr[i];
            arr[i] ^= arr[j];
            i++; j--;
        }
    }
}
