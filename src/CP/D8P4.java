package CP;

import java.util.Scanner;

/*
You are given an array nums of size n+1,
where each element is an integer between 1 and n (inclusive).

The array contains exactly one duplicated number, which appears at least twice, while all other numbers appear exactly once.

Your task is to find and return the repeated number without modifying the array and using only constant extra space.

Input Format:
-------------
Line-1: An integer N, size of array
Line-2: N space separated integer

Output Format:
--------------
Line-1: An integer, duplicate value

Sample Input-1:
---------------
5
1 3 4 2 2

Sample Output-1:
----------------
2

Sample Input-2:
---------------
5
3 1 3 4 2

Sample Output-2:
----------------
3


Constraints:
-> 1 ≤ n ≤ 10⁵
-> nums.length = n + 1
-> 1 ≤ nums[i] ≤ n
-> All numbers appear exactly once except for one number which appears at least twice.

 */
public class D8P4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n+1];
        for(int i=0; i<n; i++){
            nums[i] = sc.nextInt();
        }
        System.out.println(solve(nums));
    }
    public static int solve(int[] nums){
        if(nums == null || nums.length<=1){
            return 0;
        }
        int slow = nums[0], fast = nums[0];
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);

        slow = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}