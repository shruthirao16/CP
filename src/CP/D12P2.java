package CP;

import java.util.Scanner;

/*
Liam was a curious boy who loved playing with secret codes.

One day, while flipping through an old book in his grandfather’s library, he found a strange note that read:
"To reveal the true form of a letter, flip its hidden switch!"

Liam scratched his head. What could it mean?
He decided to experiment. He took a small chalkboard and wrote down a few letters:
H e L l O W o R l D
He then noticed something interesting—each letter had a twin in a different case.
Some were uppercase, some were lowercase. "What if I could magically switch them?" he wondered.

As he played with the letters, he discovered a fascinating trick.
If he used a simple rule—flipping just the right part of a letter’s identity—he could swap between uppercase and lowercase instantly.

Excited by his discovery, Liam ran to his grandfather, who smiled and said,
"Ah, you’ve uncovered the XOR trick! With a simple flip, letters can change their form."

Your Task:
Liam wants to automate his discovery.
Can you help him write a program that takes a word and swaps the case of each letter using his newly found trick?

Input Format:
A single string containing uppercase and lowercase letters.

Output Format:
A string where each letter has been swapped to the opposite case.

Example 1:
Input =HeLLo WoRLd
Output= hEllO wOrlD

 */
public class D12P2 {
    public static void main(String[] agrs){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.print(solve(s));
    }
    public static String solve(String s){
        char[] arr = s.toCharArray();
        for(int i=0; i<s.length(); i++){
            if(Character.isLetter(arr[i])) arr[i]^=32;   // A-Z -> 65-90     a-z -> 97-122
        }
        return new String(arr);
    }
}
