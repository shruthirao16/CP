package CP;

import java.util.Scanner;


public class D2P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(maxProduct(arr));
    }
    public static int maxProduct(int[] nums){
        int l=0, prod=1, maxProd=Integer.MIN_VALUE;
         for(int i=0; i<3; i++){
             prod*= nums[i];
         }
         maxProd = prod;
         for(int i=3; i<nums.length; i++){
             prod*= nums[i];
             if(nums[l]!=0){
                 prod/=nums[l]; l++;
             }
             else{
                 // If the outgoing element was 0, recalculate the product from scratch
                 prod = nums[i]*nums[i-1]*nums[i-2];
             }
             maxProd = Math.max(maxProd, prod);
         }
         return maxProd;
    }
}
