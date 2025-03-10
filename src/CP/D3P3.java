package CP;

public class D3P3 {
}
/*
A tenth standard student has been given a task to analyze a set of P subject marks.


Given an integer I, student needs to determine the I-th least sum among all possible contiguous subarrays of the marks list.

Input Format:
        --------------
Line-1: Two space-separated integers, P (number of subjects) and I (the required index in the sorted sums list).
Line-2: P space-separated integers, representing the marks in each subject.

Output Format:
        --------------
Line-1: Print a single integer, which is the I-th least sum among all possible contiguous subarrays.

Sample Input-1:
        --------------
        3 4
        3 2 4

Sample output-1:
        ---------------
        5

Explanation:
        ------------
The subarrays of 3 2 4 are:
        1st subarray: 3 the sum is 3
        2nd subarray: 2 the sum is 2
        3rd subarray: 4 the sum is 4
        4th subarray: 3,2 the sum is 5
        5th subarray: 2,4 the sum is 6
        6th subarray: 3,2,4 the sum is 9

The 4th smallest is 5

Sample Input-2:
        ---------------
        4 7
        2 2 4 4

Sample output-2:
        ----------------
        8

Explanation:
        ------------
The subarrays of 2 2 4 4 are

1st subarray: 2 the sum is 2
        2nd subarray: 2 the sum is 2
        3rd subarray: 4 the sum is 4
        4th subarray: 4 the sum is 4
        5th subarray: 2,2 the sum is 4
        6th subarray: 2,4 the sum is 6
        7th subarray: 4,4 the sum is 8
        8th subarray: 2,2,4 the sum is 8
        9th subarray: 2,4,4 the sum is 10
        10th subarray: 2,2,4,4 the sum is 12

The 7th smallest is 8

 */