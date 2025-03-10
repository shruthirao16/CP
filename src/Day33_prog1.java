//Given a classic mobile phone, and the key pad of the phone looks like below.
//        1		2		3
//abc	   def
//
//	4		5		6
//ghi    jkl     mno
//
//	7		8		9
//pqrs    tuv     wxyz
//
//	*		0		#
//
//
//You are given a string S contains digits between [2-9] only,
//For example: S = "2", then the possible words are "a", "b", "c".
//
//Now your task is to find all possible words that the string S could represent.
//and print them in a lexicographical order.
//
//Input Format:
//        -------------
//A string S, consist of digits [2-9]
//
//Output Format:
//        --------------
//Print the list of words in lexicographical order.
//
//
//Sample Input-1:
//        ---------------
//        2
//
//Sample Output-1:
//        ----------------
//        [a, b, c]
//
//
//Sample Input-2:
//        ---------------
//        24
//
//Sample Output-2:
//        ----------------
//        [ag, ah, ai, bg, bh, bi, cg, ch, ci]


import java.util.*;
public class Day33_prog1 {
    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length()==0 || digits==null){
            return res;
        }

        String[] digitsToLetters = {"", "", "abc", "def", "ghi", "jkl", "mno",
                "pqrs", "tuv", "wxyz"};
        backtrack(digits, 0, "", res, digitsToLetters);
        return res;
    }
    public static void backtrack(String digits, int ind, String comb, List<String> res, String[] dl){
        if(ind==digits.length()){
            res.add(comb);
            return;
        }
        String letters = dl[digits.charAt(ind)-'0'];

        for(char ch: letters.toCharArray()){
            backtrack(digits, ind+1, comb+ch, res, dl);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String digits = sc.next();
        List<String> ans = letterCombinations(digits);
        System.out.println(ans);
    }
}