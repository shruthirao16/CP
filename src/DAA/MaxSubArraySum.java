package DAA;

import java.util.Scanner;

public class MaxSubArraySum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] points = new int[n];
        for(int i=0; i<n; i++){
            points[i]=sc.nextInt();
        }
        System.out.println(maxSum(points));
    }
    public static int maxSum(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for(int i = 1; i < nums.length; i++){
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }
}
