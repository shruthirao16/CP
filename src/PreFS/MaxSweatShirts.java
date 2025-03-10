package PreFS;

/*A store contains n sweatshirts. A person has money D $
input n, D
input prices array where prices[i] represents price of ith sweatshirt

Find maximum no of sweatshirts he can buy

Sample input :
7 15
6 7 12 15 9 5 1

Output: 3

*/

import java.util.*;
public class MaxSweatShirts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int D= sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(maxSweatshirts(arr, n, D));
    }
    public static int maxSweatshirts(int[] arr, int n, int D){
        Arrays.sort(arr);
        int low = 0, high = n;
        if(low>D) return 0;
//        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
//        for(int i=0; i<n; i++){
//            low =
//        }
        while(low<=high){
            int mid = (low+high)/2;
            int expD = expD(arr, mid);
            if(expD<=D){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return high;
    }
    public static int expD(int[] arr, int mid){
        int sum=0;
        for(int i=0; i<mid; i++){
            sum+=arr[i];
        }
        return sum;
    }
}




//public static int maxSweatshirts(int[] arr, int n, int D){
//    Arrays.sort(arr);
//    int sum=0;
//    for(int i=0; i<n; i++){
//        sum+= arr[i];
//        if(sum>D){
//            return i;
//        }
//    }
//    return 0;
//}