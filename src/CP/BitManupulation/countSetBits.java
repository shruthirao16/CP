package CP.BitManupulation;

import java.util.Arrays;
import java.util.Scanner;

public class countSetBits {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        for(int i=0; i<=n; i++){
            arr[i] = bitwise(i);
        }
        System.out.println(Arrays.toString(arr));
    }
    public static int bitwise(int num){
        int cnt=0;
        while(num>0){
            // if((n & 1)==1) cnt++;
            cnt += (num&1);
            num = num>>1;
        }
        return cnt;
    }

//    public static void bitwise(int n){
//        for(int i=0; i<=n; i++){
//            int cnt=0, num = i;
//            while(num>0){
//                // if((n & 1)==1) cnt++;
//                cnt += (num&1);
//                num = num>>1;
//            }
//            System.out.print(cnt+ " ");
//        }
//    }
}
