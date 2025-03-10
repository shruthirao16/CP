package CP;

import java.util.Scanner;

/*
Given an integer n, return an array ans of length n such that for each i
(1 ≤ i ≤ n), ans[i-1] is the number of 0's in the 32-bit binary representation of i.

Assume input n>=1


input = 5
output = 31 31 30 31 30

Explanation (32-bit binary representation):
1 → 00000000000000000000000000000001 → 31 zeros
2 → 00000000000000000000000000000010 → 31 zeros
3 → 00000000000000000000000000000011 → 30 zeros
4 → 00000000000000000000000000000100 → 31 zeros
5 → 00000000000000000000000000000101 → 30 zeros

 */
public class D10P4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1; i<=n; i++){
            System.out.print(countBits(i)+" ");
        }
    }
    public static int countBits(int num){
        int cnt=0;
        while(num>0){
            cnt++;
            num &= (num-1);
        }
        return 32-cnt;
    }
}
