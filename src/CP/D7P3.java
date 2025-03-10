package CP;

import java.util.Scanner;

/*
Given a string s, reverse only all the vowels in the
string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can
appear in both lower and upper cases, more than once.

Sample Input-1:
---------------
hello

Sample Output-1:
----------------
holle

Sample Input-2:
----------------
Keshavmemorial

Sample Output-2:
----------------
Kashivmomerael
 */
public class D7P3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(revVowels(s));
    }
    public static String revVowels(String s){
        int i=0, j=s.length()-1;
        char[] arr = s.toCharArray();
        while(i<j){
            while(i<j && !isVowel(arr[i])){
                i++;
            }
            while(i<j && !isVowel(arr[j])){
                j--;
            }
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++; j--;
        }
        return new String(arr);
    }
    public static boolean isVowel(char ch){
        return (ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U');
    }
}
