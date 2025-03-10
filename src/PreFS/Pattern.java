package PreFS;

import java.util.Scanner;
/*
7
A B C D E F G
H I J K L M
N O P Q R
S T U V
W X Y
A B
C
 */
public class Pattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char ch = 'A';
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                System.out.print(ch+" ");
                ch++;
                if(ch=='Z'){
                    ch='A';
                }
            }
            System.out.println();
        }
    }
}
