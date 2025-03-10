package PreFS;

import java.util.*;
public class LetterCasePermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(letterCasePermutation(s));
    }
    public static List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        backtrack(s.toCharArray(), 0, res);
        return res;
    }
    public static void backtrack(char[] chars, int ind, List<String> res){
        if(ind==chars.length){
            res.add(new String(chars));
            return;
        }
        backtrack(chars, ind+1, res);
        if(Character.isLowerCase(chars[ind])){
            chars[ind] = Character.toUpperCase(chars[ind]);
            backtrack(chars, ind+1, res);
            chars[ind] = Character.toLowerCase(chars[ind]);
        }
        else if(Character.isUpperCase(chars[ind])){
            chars[ind] = Character.toLowerCase(chars[ind]);
            backtrack(chars, ind+1, res);
            chars[ind] = Character.toUpperCase(chars[ind]);
        }
    }

}



//public void generate(char[] arr, int idx, List<String>res) {
//    if (idx == arr.length) {
//        res.add(new String(arr));
//        return;
//    }
//
//    if (Character.isDigit(arr[idx])) {
//        generate(arr, idx + 1);
//        return;
//    }
//
//    arr[idx] = Character.toLowerCase(arr[idx]);
//    generate(arr, idx + 1);
//
//    arr[idx] = Character.toUpperCase(arr[idx]);
//    generate(arr, idx + 1);
//}




//Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.
//
//Return a list of all possible strings we could create. Return the output in any order.
//
//
//
//Example 1:
//
//Input: s = "a1b2"
//Output: ["a1b2","a1B2","A1b2","A1B2"]
//Example 2:
//
//Input: s = "3z4"
//Output: ["3z4","3Z4"]