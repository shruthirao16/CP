package CP;

import java.util.HashSet;
import java.util.Scanner;
import java.util.*;
/*
Mr.Bob and Mr.Cob are working on a Military Mission.
They are supposed to encode the message and send the message to the under-cover team.

Where Cob has written a script. Where the Script says double all the ascii values other than mentioned in the bracket
(97,101,105,111,117,65,69,73,79,85) and place a '#' in between.

Help Bob in writing the Code.


Sample Test Case-1
input = attack the enemy
output = at#tt#tac#ck#k t#th#he en#nem#my#y

 */
public class D1P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(func(s));
    }
    public static String func(String s){
        StringBuilder sb = new StringBuilder();
        HashSet<Integer> hs = new HashSet<>(Arrays.asList(97,101,105,111,117,65,69,73,79,85));
        for(int i=0; i<s.length(); i++){
            if(hs.contains((int)s.charAt(i)) || s.charAt(i)==' '){
                sb.append(s.charAt(i));
            }else{
//                sb.append(s.charAt(i));
//                sb.append("#");
//                sb.append(s.charAt(i));

                sb.append(s.charAt(i)).append("#").append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
