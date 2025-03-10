package CP;

/*
Given an expression in string format print the value of the expression after evaluating

Rules for Evaluation :
The expression is Evaluated from Left to Right and operators allowed are only +,-,/,*
Ignore Operator Precedence and evaluate the expression from left to right
Assume the expression only consists of numbers(0-9)(both postive and negative) and
operators(+,-,*,/)

Test Case-1
input = 2+3*6
output = 30

Explanation :- The sum of 2+3 is 5 and 5*6 = 30


Test Case-2
input = 5+7-9+0*0+1
output = 1

Explanation - The sum of 5+7 is 12
12-9 is 3 and 3+0 is 3, 3*0 is 0 and 0+1 is 1


Test Case-3
input = -1+-1*2
output = -4

Explanation -
-1 + -1 is -2
and -2 * 2 is -4

 */
import java.util.Scanner;

public class D6P2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
//        System.out.println(solve(s));
    }
//    public static int solve(String s){
//        int sign=1, i=0;
//        if(s.charAt(0)=='-'){
//            sign=-1;
//            i++;
//        }
//        int k = (s.charAt(i)-'0')*sign;
//        i++;
//        while(i<s.length()){
//            char op = s.charAt(i);
//            int num;
//            int nextIndex = i+1;
//            if(nextIndex=='-'){
//                nextIndex++;
//                sign=-1;
//            }
//            num = (s.charAt(nextIndex)-'0')*sign;
//
//        }
//    }
}


//int k = s.charAt(0);
//        int sign=1;
//        if(!Character.isDigit(k)){
//            if(k=='-') sign = '-';
//            k='0';
//        } else{
//            res = k-'0';
//        }
//
//        for(int i=1; i<s.length()-1; i+=2){
//            if(Character.isDigit(s.charAt(i-1))){
//                int num = s.charAt(i-1)-'0';
//                switch(s.charAt(i)){
//                    case '+' : res += num;
//                        break;
//                    case '-' : res -= num;
//                        break;
//                    case '*' : res *= num;
//                        break;
//                    case '/' : res /= num;
//                        break;
//                }
//                sign=1;
//            }
//            else if(Character.isDigit(s.charAt(i-1)){
//
//            }
//        }
