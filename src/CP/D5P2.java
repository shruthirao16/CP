package CP;

import java.util.*;

/*
Amazon fire tv stick keyboard wanted to be operated on number pad.
You will be given the below pad.
You are supposed to print all possible words in alphabetic order for a given number (0-9)

	1		2		3
		   abc	  def

	4		5		6
   ghi     jkl    mno

	7		8		9
  pqrs     tuv   wxyz

	*		0		#


You will be given a string S which contains (2-9)  only
For example: S = "3", then the possible words are "d", "e", "f".

Input Format:
-------------2
String(2-9)

Output Format:
--------------
Print the list of words in alphabetical order


Sample Input-1:
---------------
2

Sample Output-1:
----------------
a b c


Sample Input-2:
---------------
24

Sample Output-2:
----------------
ag ah ai bg bh bi cg ch ci

 */
class D5P2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        List<String> res = new ArrayList<>();
        String[] digitsToLetters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        solve(s, 0, "" ,res, digitsToLetters);
        System.out.println(res);
    }
    public static void solve(String s, int ind, String comb, List<String> res, String[] dl){
        if(ind==s.length()){
            res.add(comb);
            return;
        }
        String letters = dl[s.charAt(ind)-'2'];
        for(char ch : letters.toCharArray()){
            solve(s, ind+1, comb+ch , res, dl);
        }
    }
}
