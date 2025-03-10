package CP;

import java.util.Scanner;

/*
In a mysterious manuscript, scholars have discovered a sequence S consisting of letters and numbers.
Your task is to analyze this sequence and determine how many distinct patterns exist.

A pattern is a continuous segment where all characters are identical.
Each individual character is also considered a valid pattern.

Input Format:
A single string S.

Output Format:
Print a single integer representing the total number of distinct patterns present in S.

Sample Input-1:
---------------
paddy

Sample Output-1:
----------------
6

Explanation:
------------
The words are : p, a, d, d, dd, y


Sample Input-2:
---------------
abcde

Sample Output-2:
----------------
5

Explanation:
------------
The words are : a,b,c,d,e
 */
public class D12P1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(distinct(s));
    }
    public static int distinct(String s){
        //int count=0, res=0;
        int count=1, res=1;
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i)==s.charAt(i-1)){
                count++;
            } else{
                count=1;
            }
            res+= count;
        }
        return res;
//        for(int r=0; r<s.length(); r++){
//            if(r>0 && s.charAt(r)==s.charAt(r-1)){
//                count += r-l+1;
//            }
//            count++; l=r;
//        }
//        return count;
    }
}
//aaaba420gaaaaadu143guddddduuuuuflowwwwweeeeerrrrrr