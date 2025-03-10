import java.util.HashMap;
import java.util.Scanner;

public class UniqueMapping {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String alpha = sc.next();
        String beta = sc.next();
        System.out.println(unique(alpha, beta));
    }
    public static boolean unique(String a, String b){
        if(a.length()!= b.length()) return false;

        HashMap<Character, Character> hm = new HashMap<>();
        for(int i=0; i<a.length(); i++){
            if(hm.containsKey(a.charAt(i))){
                if(!hm.get(a.charAt(i)).equals(b.charAt(i))){
                    return false;
                }
            }
            else if(hm.containsValue(b.charAt(i))){
                return false;
            }
            else{
                hm.put(a.charAt(i), b.charAt(i));
            }
        }
        return true;
    }
}


//In a secret code system, two distinct ancient civilizations, `Alpha` and `Beta`,
//used their own unique symbols to encode messages. However, these symbols
//represent the same meanings in their respective languages.
//
//Given two encoded messages, one from Alpha and one from Beta, determine
//if these messages are translatable — meaning that the symbols used in Alpha's
//message can be uniquely translated to the symbols in Beta's message.
//
//The translation must follow these rules:
//        - Each symbol in Alpha's message must map to exactly one symbol in Beta's
//message, and vice versa.
//    - No two symbols from Alpha's message can map to the same symbol in Beta's
//message.
//    - The order of symbols must be preserved in the translation.
//        - A symbol may map to itself if needed.
//
//Your task is to determine whether these ancient messages from two different
//civilizations can be translated perfectly while maintaining their symbolic
//structure. If yes print "true", otherwise, "false".
//
//Input Format:
//        -------------
//Space separated strings, Alpha and Beta messages.
//
//Output Format:
//        --------------
//Boolean value.
//
//
//Sample Input-1:
//        ---------------
//star moon
//
//Sample Output-1:
//        ----------------
//        false
//
//Explanation:
//        ------------
//In this case, 's' would need to map to 'm', and 't' would need to map to 'o',
//but then 'a' and 'r' would both need to map to 'n', which violates the rule
//that no two symbols may map to the same symbol.
//
//
//Sample Input-2:
//        ---------------
//sun day
//
//Sample Output-2:
//        ----------------
//        true
//
//Explanation:
//        ------------
//Here, each symbol in the Alpha message has a unique mapping to the Beta message,
//preserving the order and meaning: 's' -> 'd', 'u' -> 'a', and 'n' -> 'y'.
//
//Constraints:
//        ------------
//        - 1 ≤ length of Alpha's message ≤ 50,000
//        - The length of Beta's message is equal to the length of Alpha's message.
//        - Both messages consist of any valid ASCII characters.

