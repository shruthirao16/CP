import java.util.Scanner;
public class Day46_prog1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(palindromeCount(s));
    }
    public static int palindromeCount(String s){
        int count=0;
        for(int i=0; i<s.length(); i++){
            count += solve(s, i, i);

            count += solve(s, i, i+1);
        }
        return count;
    }
    public static int solve(String s, int left, int right){
        int c=0;
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            c++;
            left--; right++;
        }
        return c;
    }
}

//divider - 9