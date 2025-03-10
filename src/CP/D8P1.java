package CP;

import java.util.Scanner;

/*
write a java program to find the greatest of 4 numbers using ternary operator

input = 3 4 5 6
output = 6
 */
public class D8P1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        System.out.println(grt(a, b, c, d));
    }
    public static int grt(int a, int b, int c, int d){
        return (a>b)? ((a>c)? ((a>d) ? a : d) : ((c>d)? c : d)) : ((b>c) ? ((b>d) ? b : d) : (c>d)? c : d);
    }

}