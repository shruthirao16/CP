package CP;

import java.util.Scanner;

public class D11P2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().replace(" ", "");
        System.out.println(lonelyLetter(s));
    }
    public static char lonelyLetter(String s){
          char ch=0;
//        for(int i=0; i<s.length(); i++){
//            ch ^= s.charAt(i);
//            System.out.println(ch);
//        }
//        if(ch==0) System.out.print("-1");
//        return ch;
        char[] arr = s.toCharArray();
        for(char c : arr){
            ch^= c;

        }
        return ch;
    }
}
