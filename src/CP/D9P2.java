package CP;

import java.util.Scanner;

/*
You are given a 0-indexed string blocks of length n,
where blocks[i] is either 'W' or 'B', representing the color of the ith block.
The characters 'W' and 'B' denote the colors white and black, respectively.

You are also given an integer k, which is the desired number of consecutive black
blocks.

In one operation, you can recolor a white block such that it becomes a black block.

Return the minimum number of operations needed such that there is at least one
occurrence of k consecutive black blocks.

Input Format:
-------------
Line-1: A string
Line-2: An integer(k)

Output Format:
--------------
An Integer

Sample Input-1:
---------------
WBBWWBBWBW
7

Sample Output-1:
----------------
3

Explanation:
-------------
One way to achieve 7 consecutive black blocks is to recolor the 0th, 3rd
and 4th blocks

so that blocks = "BBBBBBBWBW".

It can be shown that there is no way to achieve 7 consecutive black blocks
in less than 3 operations.Therefore, we return 3.

Sample Input-2:
---------------
WBWBBBW
2

Sample Output-2:
----------------
0

Explanation:
-------------
No changes need to be made, since 2 consecutive black blocks already exist.
Therefore, we return 0.


Constraints:
------------
n == blocks.length
1 <= n <= 100
blocks[i] is either 'W' or 'B'.
1 <= k <= n
 */
public class D9P2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();
        System.out.println(minOp(s, k));
    }
    public static int minOp(String s, int k){
        int cnt = 0, minCnt=k;
        for(int i=0; i<k; i++){
            if(s.charAt(i)=='W') cnt++;
        }
        minCnt = cnt;
        int l=0, r=k;
        while(r<s.length()){
            if(s.charAt(l)=='W') cnt--;
            if(s.charAt(r)=='W') cnt++;
            minCnt = Math.min(minCnt, cnt);
            l++; r++;
        }
        return minCnt;
    }
}
