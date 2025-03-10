package CP;

/*
Magic Reflections: In a mystical world, a spell can concatenate the essence of two magical artifacts represented as sequences of integers.
Once combined, the new sequence may reflect ancient symmetrical magic if it appears the same from both ends.
As a novice wizard,your task is to determine if the resulting sequence from combining two artifacts holds this reflective, symmetrical property.


Test Case 1:
Input = 1 4 9
9 4 1
output true

Test Case 2:
Input = 1 2 3
3 2 4
output false

 */
import java.util.*;
public class D6P1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] s1 = sc.nextLine().split(" ");       //********* TO TAKE NUMBERS INPUT AS STRING
        String[] s2 = sc.nextLine().split(" ");

        System.out.println(solve(s1, s2));
        //System.out.println(solve(s1+" "+s2));

    }
    public static boolean solve(String[] s1, String[] s2){
        ArrayList<String> al = new ArrayList<>();
        for(int i=0; i<s1.length; i++){
            al.add(s1[i]);
        }
        for(int j=0; j<s2.length; j++){
            al.add(s2[j]);
        }
        int i=0, j=al.size()-1;
        while(i<=j){
            if(!al.get(i).equals(al.get(j))) return false;
            i++; j--;
        }
        return true;
    }
}
