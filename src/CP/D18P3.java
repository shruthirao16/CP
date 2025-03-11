package CP;

import java.util.Scanner;

/*
A teacher is writing a test with n true/false questions, with 'T' denoting true and 'F' denoting false.

He wants to confuse the students by maximizing the number of consecutive questions with the same answer (multiple trues or multiple falses in a row).

You are given a string answerKey, where answerKey[i] is the original answer to the ith question.

In addition, you are given an integer k, the maximum number of times you may perform the following operation:

Change the answer key for any question to 'T' or 'F' (i.e., set answerKey[i] to 'T' or 'F').
Return the maximum number of consecutive 'T's or 'F's in the answer key after performing the operation at most k times.



Example 1:
Input  = TTFF
2
Output = 4

Explanation: We can replace both the 'F's with 'T's to make answerKey = "TTTT".
There are four consecutive 'T's.

Example 2:
Input  = TFFT
1
Output = 3

Explanation: We can replace the first 'T' with an 'F' to make answerKey = "FFFT".
Alternatively, we can replace the second 'T' with an 'F' to make answerKey = "TFFF".
In both cases, there are three consecutive 'F's.


Example 3:
Input = TTFTTFTT
1
Output = 5
Explanation: We can replace the first 'F' to make answerKey = "TTTTTFTT"
Alternatively, we can replace the second 'F' to make answerKey = "TTFTTTTT".
In both cases, there are five consecutive 'T's.

 */
public class D18P3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k=sc.nextInt();
        System.out.println(maxConsecutives(s, k));
    }
    public static int maxConsecutives(String s, int k){
        return Math.max(TF(s, 'T', k), TF(s, 'F', k));
    }
    public static int TF(String s, char ch, int k){
        int l=0, changes=0, maxi=0;
        for(int r=0; r<s.length(); r++){
            if(s.charAt(r) != ch){
                changes++;
            }
            while(changes>k){

                if(s.charAt(l)!=ch) {
                    changes--;
                }
                l++;
            }

            maxi = Math.max(maxi, r-l+1);
        }
        return maxi;
    }
}



//public int maxConsecutiveAnswers(String answerKey, int k) {
//         int i =0 ;int j =0; int len = answerKey.length();
//         int max_val = 0;

//         int countT = 0; int countF =0;

//         while(j<len){

//             if(answerKey.charAt(j) == 'T')countT++;else countF++;
//             int min_val = Math.min(countT, countF);

//             if(min_val>k){
//                 if(answerKey.charAt(i) == 'T')countT--;
//                 else countF--;
//                 i++;
//             }

//             max_val = Math.max(max_val, j-i+1);
//             j++;
//         }
//         return max_val;
//     }