package CP;

/*
Cob is working an Group of numbers.
His teacher gave him to print the Maximum product of the 'k' consiqutive numbers.

The first line of input contains the group size followed by group numbers followed by k

 */

import java.util.Scanner;

public class P9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        //System.out.println(func(arr, k));
    }
//    public static int func(int[] arr, int k){
//        int prod=1, maxProd=1;
//
//    }
}


/*
sample input 1 :
----------------
5
1 5 3 2 10
3
sample output 1 :
-----------------
60

sample input 2 :
----------------
7
8 7 1 8 2 9 1
2
sample output 2:
----------------
56

 */