package CP;

import java.util.Arrays;
import java.util.Scanner;

/*
Agent X is on a top-secret mission to access a secure vault that contains classified information.
To unlock the vault, Agent X has received an encrypted numeric sequence from an anonymous source. However, the sequence follows a unique encryption pattern based on a circular array and a key value (k).

To decrypt the sequence, follow these rules:

If k > 0, replace each number with the sum of the next k numbers in the sequence.
If k < 0, replace each number with the sum of the previous |k| numbers.
If k == 0, replace each number with 0.

Since the sequence is circular, the next element of the last number is the first number
and the previous element of the first number is the last number.
Can you help Agent X decrypt the vault code?

Input Format:
-------------
An integer n representing the length of the numeric sequence.
A list of n integers representing the encrypted sequence.
An integer k representing the key.

Output Format:
--------------
A list of n integers representing the decrypted sequence.

Example 1:
Input:
------
5
3 6 1 8 4
2
Output:
-------
[7, 9, 12, 12, 9]

Explanation:
Each number is replaced by the sum of the next 2 numbers:

3 → (6 + 1) = 7
6 → (1 + 8) = 9
1 → (8 + 4) = 12
8 → (4 + 3) = 12 (wraps around)
4 → (3 + 6) = 9 (wraps around)

Example 2:
Input:
4
2 5 7 1
-2
Output:
[8, 9, 6, 12]

Explanation:
------------
Each number is replaced by the sum of the previous 2 numbers:

2 → (1 + 7) = 8
5 → (2 + 1) = 9
7 → (5 + 2) = 6
1 → (7 + 5) = 12

Constraints:
------------
1 ≤ n ≤ 100
1 ≤ sequence[i] ≤ 100
-(n - 1) ≤ k ≤ n - 1

Challenge:
----------
Can you optimize your solution to run efficiently for large values of n?

 */
public class D14P1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int[] res = decryptedSequence(arr, k, n);
        System.out.println(Arrays.toString(res));
    }
    public static int[] decryptedSequence(int[] arr, int k, int n){
        int[] res = new int[n];
        int start=1, end=k, sum=0;
        if(k<0){
            k=-k;
            start = n-k;
            end = n-1;
        }
        for(int i=start; i!=(end+1)%n; i=(i+1)%n){
            sum+= arr[i];
            //System.out.print(sum+" ");
        }
        for(int i=0; i<n; i++){
            res[i]=sum;
            sum -= arr[start];
            //System.out.print(sum+" ");

            start = (start+1)%n;
            end = (end+1)%n;

            sum += arr[end];
            //System.out.print(sum+" ");
        }
        return res;
    }
}
