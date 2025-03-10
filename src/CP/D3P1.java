package CP;


import java.util.*;
/*
A string is good if there are no repeated characters.
Given a string s, return the number of good substrings of length three in s.
Note that if there are multiple occurrences of the same substring, every occurrence should be counted.
A substring is a contiguous sequence of characters in a string.

Sample Input-1:
---------------
xyzzaz

Sample Output-1:
----------------
1

Explanation:
------------
There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz".
The only good substring of length 3 is "xyz".

Sample Input-2:
---------------
aababcabc

Sample Output-2:
----------------
4

Explanation:
------------
There are 7 substrings of size 3: "aab", "aba", "bab", "abc", "bca", "cab", and "abc".
The good substrings are "abc", "bca", "cab", and "abc".
 */
public class D3P1 {
    //public static int res=0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
//        goodStrings(s);
        System.out.println(goodStrings1(s));
        //System.out.println(goodStrings2(s));
        System.out.println(goodStrings3(s));
    }
    public static int goodStrings1(String s) {
        int l = 0; int res=0;
        HashSet<Character> hs = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            while (hs.contains(s.charAt(i))) {
                hs.remove(s.charAt(l));
                l++;
            }
            hs.add(s.charAt(i));
            if (i - l + 1 == 3) {
                res++;
                hs.remove(s.charAt(l));
                l++;
            }
        }
        return res;
    }
//    public static int goodStrings2(String s){
//        int res=0;
//        if(s.length()<3) return 0;
//        Set<Character> hs = new HashSet<>();
//        for(int i=0; i<3; i++){
//            hs.add(s.charAt(i));
//        }
//        if(hs.size()==3) res++;
//        for(int i=3; i<s.length(); i++){
//            hs.add(s.charAt(i));
//            hs.remove(s.charAt(i-3));
//            if(hs.size()==3){
//                res++;
//            }
//        }
//        return res;
//    }
    public static int goodStrings3(String s){
        int res=0;
        for(int i=0; i<s.length()-3; i++){
            char a = s.charAt(i);
            char b = s.charAt(i+1);
            char c = s.charAt(i+2);

            if(a != b && b != c){
                res++;
            }
        }
        return res;
    }
}


