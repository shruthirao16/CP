package CP.O;

/*
Malika taught a new fun time program practice for Engineering Students.
As a part of this she has given set of N numbers, and asked the students
to perform the operations listed below:
1. sumRange(start, end) - return the sum of numbers between the indices start and end, both are inclusive.
2. update(ind, val) - update the value at the index 'ind' to 'val'.

Your task is to solve this problem using Segment Tree concept.

Input Format:
-------------
Line-1: Two integers N and Q, size of the array(set of numbers) and query count.
Line-2: N space separated integers.
next Q lines: Three integers option, start/ind and end/val.

Output Format:
--------------
An integer result, for every sumRange query.


Sample Input:
-------------
8 5
4 2 13 4 25 16 17 8
1 2 6		//sumRange
1 0 7		//sumRange
2 2 18	//update
2 4 17	//update
1 2 7		//sumRange

8 5
4 2 13 4 25 16 17 8
1 2 6
1 0 7
2 2 18
2 4 17
1 2 7

Sample Output:
--------------
75
89
80

*/

import java.util.*;

public class SegmentTree
{
    class SegmentTreeNode
    {
        int start, end;
        SegmentTreeNode left, right;
        int sum;

        public SegmentTreeNode(int start, int end)
        {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
    }

    SegmentTreeNode root = null;

    public SegmentTree(int[] nums)
    {
        root = buildTree(nums, 0, nums.length-1);
        printTree(root);
    }

    public void printTree(SegmentTreeNode root)
    {
        if(root == null)
            return;

        printTree(root.left);
        System.out.println(root.start + " " + root.end + " " +
                root.left + " " + root.right + " " + root.sum);
        printTree(root.right);
    }

    private SegmentTreeNode buildTree(int[] nums, int start, int end)
    {
        System.out.println("Start " + start + " End " + end);
        if (start > end) {
            return null;
        }
        else
        {
            SegmentTreeNode ret = new SegmentTreeNode(start, end);
            if (start == end) {
                ret.sum = nums[start];
            } else {
                int mid = start  + (end - start) / 2;
                ret.left = buildTree(nums, start, mid);
                ret.right = buildTree(nums, mid + 1, end);
                ret.sum = ret.left.sum + ret.right.sum;
            }
            return ret;
        }
    }

    void update(int i, int val) {
        update(root, i, val);
    }

    void update(SegmentTreeNode root, int pos, int val)
    {
        System.out.println("update pos " + pos + " val " + val +
                " root.start " + root.start + " root.end " + root.end);
        if (root.start == root.end) {
            root.sum = val;
        }
        else
        {
            int mid = root.start + (root.end - root.start) / 2;
            if (pos <= mid) {
                update(root.left, pos, val);
            } else {
                update(root.right, pos, val);
            }
            root.sum = root.left.sum + root.right.sum;
        }
        printTree(root);
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }

    public int sumRange(SegmentTreeNode root, int start, int end)
    {
        System.out.println("sumRange start " + start + " end " + end +
                " root.start " + root.start + " root.end " + root.end);
        if (root.start == start && root.end == end)
        {
            return root.sum;
        }
        else
        {
            int mid = root.start + (root.end - root.start) / 2;
            System.out.println("mid " + mid);

            if (end <= mid)
            {
                return sumRange(root.left, start, end);
            }
            else if (start >= mid+1)
            {
                return sumRange(root.right, start, end);
            }
            else
            {
                return sumRange(root.left, start, mid) +
                        sumRange(root.right, mid+1, end);
            }
        }
    }
}

class SegmentTreeTest
{
    public static void main(String args[] )
    {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int q=scan.nextInt();
        int[] nums=new int[n];
        for(int i=0; i<n; i++)
        {
            nums[i] = scan.nextInt();
        }
        SegmentTree st = new SegmentTree(nums);
        while(q != 0){
            int opt=scan.nextInt();
            if(opt==1){
                int s1 = scan.nextInt();
                int s2 = scan.nextInt();
                System.out.println(st.sumRange(s1,s2));
            }
            else{
                int ind = scan.nextInt();
                int val= scan.nextInt();
                st.update(ind, val);
            }
            q--;
        }
    }
}

/*
=== testcases ===
case =1
input =8 5
1 2 13 4 25 16 17 8
1 2 6
1 0 7
2 2 18
2 4 17
1 2 7
output =75
86
80

case =2
input =100 8
-75 92 -88 35 26 -98 38 6 -78 -46 -71 28 51 54 8 22 35 45 -7 83 97 2 -80 41 -98 -30 -72 -73 78 -72 -99 49 -11 -98 -56 31 18 -72 -71 -94 73 85 68 -5 -4 89 -61 -70 -31 -79 -34 29 -70 -99 45 -61 -42 -38 -74 -33 88 -74 -81 -32 63 45 69 74 -14 67 76 29 16 -83 -20 70 -20 -36 -70 -51 16 -90 -92 -48 67 -81 -94 47 -45 74 47 -49 -28 66 -13 61 -63 -50 55 72
1 20 87
1 13 99
2 5 45
2 37 23
1 29 67
1 0 99
2 97 99
1 0 99
output =-1081
-714
-540
-656
-507

case =3
input =500 10
67 30 -61 -85 99 73 11 -79 -2 -32 -94 90 -13 58 21 37 -93 57 3 45 100 -44 -31 50 -26 -43 14 -21 100 -43 -98 -10 -55 11 -44 56 47 57 -67 -71 81 95 -89 -81 22 99 -22 100 41 45 -40 -94 82 -44 -48 -41 -18 96 -89 -69 5 -9 83 14 -47 8 13 19 97 75 -31 -21 74 70 -48 91 -66 -69 -20 -84 -34 8 47 38 -56 -70 -5 -31 49 -58 -6 -19 53 62 -52 66 -31 -70 -95 80 28 -4 -11 81 65 -9 -60 53 96 59 -69 24 -83 41 -73 -87 -64 -25 -36 -16 -24 44 24 84 -61 10 10 -29 -87 36 -50 -71 12 59 -49 -9 57 -97 -85 83 58 75 -81 33 36 -65 48 53 6 91 92 71 -47 -99 40 -77 -84 -56 -81 -87 -6 -71 -22 -18 -35 -24 65 63 -88 98 95 24 -8 57 63 -64 60 -80 -79 67 50 83 3 18 -64 90 71 62 -22 -52 -74 62 48 82 -83 -2 40 -45 -65 47 -96 95 94 44 51 59 20 76 99 -18 45 -25 33 -91 38 27 11 -56 67 9 96 -72 18 -34 -12 18 48 28 16 92 -89 -63 15 94 67 -70 -23 53 -7 36 29 -13 77 82 0 74 63 44 -25 -8 -60 -81 -80 86 -88 43 76 -50 26 -22 28 19 89 67 46 16 48 2 -31 -72 11 -11 70 53 -36 60 -21 -51 -97 42 20 43 53 100 -36 -89 89 -13 -80 66 99 -37 32 61 -77 -84 20 48 22 29 -67 -48 -38 29 75 -28 -36 8 13 -30 48 -35 40 86 -63 13 60 -33 8 -71 -10 57 -94 56 96 -40 -19 -78 94 25 18 60 -96 -57 85 75 68 73 3 4 -77 8 35 -70 58 -45 79 16 42 44 -86 29 -6 81 92 35 69 62 54 91 -89 -8 -46 85 -40 77 -4 15 12 93 68 90 -24 -64 13 26 -1 -63 67 58 5 -10 92 9 32 -46 -92 -94 86 35 -83 1 88 22 27 -68 12 -26 -27 87 -23 8 -8 -27 -41 77 -20 76 -5 12 63 -53 -93 46 65 -3 -90 16 -18 -51 54 -41 -18 34 33 70 100 71 -47 35 -10 19 -90 11 6 44 -12 78 36 48 -27 88 -14 43 80 26 57 10 59 -85 -98 16 23 38 18 -77 -61 35 11 46 100 21 15 65 5 92 94 -45 46 -51 -54 93 -33 79 52 97 -53 -25 -69 97 34 89 -52 -97 86 -15 32 -33 99 -79 36 -26 -35 87 81 92 -85 44 -9 76
1 27 439
1 24 376
2 45 89
2 85 100
1 100 499
2 299 100
1 100 499
2 432 65
1 0 499
1 100 499
output =2750
2231
3871
3942
4327
4097

case =4
input =750 10
47 -88 99 -27 53 -36 49 3 -4 85 70 82 70 94 -16 -25 52 18 73 20 50 -24 56 -94 86 77 59 5 -40 36 -28 20 -35 -81 -73 -26 -31 -72 94 -80 -94 -12 -21 29 83 30 91 -49 -47 39 52 37 6 -14 77 7 -15 -20 -50 -22 36 -65 -15 -38 95 66 29 -9 -76 -91 -41 -26 72 97 -43 -10 27 67 9 -94 -68 81 80 -67 8 82 64 54 -86 44 13 66 23 85 -19 60 -51 -7 27 86 28 94 3 42 54 -45 15 79 28 2 -60 39 17 -59 5 -22 35 33 30 -11 -63 0 67 -99 99 -78 -54 17 13 75 47 -67 33 29 -53 -12 -7 29 83 -74 -66 69 3 2 -81 -97 -29 18 -93 25 -21 96 -45 36 99 -27 -47 33 -41 -68 -79 -1 17 -12 23 60 90 57 -17 72 26 -68 -6 -41 61 87 -39 -88 -86 -22 40 1 -85 -29 -33 3 68 68 -11 -80 64 76 -9 -27 67 -10 33 -22 -78 57 94 -73 -57 14 -5 -72 -4 -74 -17 -5 -21 -71 72 9 78 66 -47 41 -97 90 -71 -40 62 -83 17 63 68 -42 -72 7 5 -61 -87 -13 -93 59 43 -85 5 83 -36 14 -17 -14 -96 -82 -97 -88 -18 61 17 60 3 -38 -48 71 63 -89 7 -38 -51 -3 79 15 91 -15 -73 -26 -74 -98 95 19 74 59 -7 22 97 22 -98 -40 -24 -65 -47 74 64 59 60 -69 51 -4 7 -10 -9 61 -65 12 -53 -52 -71 -54 15 61 64 -59 -3 70 87 -24 -68 -13 -84 -35 -70 -61 16 0 -76 -1 -52 -74 -39 71 44 -35 -56 -50 57 -41 43 -30 34 -15 10 -52 -81 33 -22 -24 70 -88 68 -5 -92 -60 77 23 48 17 6 -93 -45 78 -42 -62 -40 -24 64 -57 -6 -89 23 82 60 97 -58 99 68 31 -76 89 44 73 -28 -19 -10 -91 85 -21 37 -11 -88 -82 53 80 -10 -27 -29 83 9 99 -45 -36 -51 -51 87 4 -26 44 93 85 -60 17 81 94 47 38 87 92 33 -80 72 76 72 6 -94 -89 -97 63 -7 33 -34 -46 73 -74 -56 0 90 -55 83 14 -17 -49 80 -32 -44 60 33 4 93 29 64 -2 81 78 82 -100 51 90 58 44 52 70 83 -70 46 -40 -89 -77 94 -26 17 31 67 55 82 -35 -96 -35 31 -63 34 79 -33 26 -57 85 37 59 29 53 97 69 -38 -11 -82 -50 -66 -7 -99 -90 75 -17 -99 -81 -48 80 -100 -22 48 96 -84 -11 58 41 -4 43 -7 78 60 6 57 49 -57 -32 -47 53 -31 95 -1 32 58 -88 -33 98 15 6 -58 3 -57 -78 -46 -82 -99 -3 -93 -6 -47 -61 70 -47 80 41 67 -45 10 3 29 57 -56 14 -14 22 -24 -73 -48 92 -73 89 -11 5 99 96 6 -67 28 37 -98 19 72 -28 -71 -66 -71 98 100 -73 -64 -80 -68 -4 47 3 54 56 -39 38 -84 81 74 10 99 91 -88 -60 -81 -38 -3 24 -17 33 5 39 70 -15 -56 94 -81 -14 3 -91 -34 27 2 18 -49 -49 -76 18 2 -31 -27 28 -41 -6 -69 -20 50 84 -39 99 -1 -36 -41 32 -78 -80 -10 -23 -9 -43 17 -43 46 -49 22 -73 -60 -58 41 -51 60 9 25 23 -68 -72 87 47 90 0 -46 -40 48 59 79 -34 -77 -7 -74 -34 92 7 -34 -69 2 -59 94 58 34 -19 64 -17 20 -46 -55 90 91 -32 92 -36 27 30 24 -13 66 -67 -59 -30 -47 -95 78 -65 -84 -49 -97 -15 -75 -43 2 -90 -45 2 36 -30 20 69 -81 -62 -32 13 -94 86 -83 -4 54 91 -10 -97 -42 52 -91 -77 26 51 46 -78 57 4 13 50 -32 -64 -24 -3 27 -50 -28 41 -7 -52
1 127 639
1 224 576
2 145 689
2 685 100
1 0 749
2 429 100
1 100 699
2 532 657
1 0 749
1 100 699
output =-188
417
1071
853
1913
1609

case =5
input =1000 12
-81 -65 11 94 -70 -31 85 58 47 27 29 40 -6 -57 -49 11 -5 97 -87 -38 -22 -56 87 0 30 43 -48 -77 55 65 -87 88 -50 -4 -4 53 -8 -64 35 98 -83 51 44 4 82 25 -58 91 94 65 -88 -66 -20 19 94 37 -49 -82 90 -6 94 1 -54 9 -25 -38 -25 72 -83 65 1 99 60 47 -78 28 -33 84 39 28 -43 -64 -92 22 44 -32 58 32 5 -93 7 63 31 -95 40 -49 -86 3 -71 -77 -71 77 -68 -39 -89 -59 -64 -1 -98 45 57 -40 19 96 -44 92 27 -65 74 -55 29 -66 -59 -52 -84 -72 20 68 95 3 63 -49 23 66 16 -25 -83 -19 4 61 -79 -93 -32 -63 -93 53 49 95 -67 -11 -86 85 -41 -57 -85 32 -52 -51 13 87 -48 76 68 51 61 14 -99 -72 -58 29 12 -16 -47 53 -33 79 -99 77 66 -35 75 -92 90 12 -95 -11 39 26 -27 83 88 34 59 18 19 62 78 -24 50 61 -51 -58 -7 -34 67 -56 -62 -15 49 -9 -74 16 76 -56 -73 22 4 -45 43 24 78 7 -31 87 -78 -47 -29 -91 -17 56 63 -17 -91 29 -56 -51 82 5 79 74 93 -53 44 -54 83 -58 99 -59 -53 13 16 63 0 -71 -71 75 13 -39 -17 -2 -82 2 5 -66 -93 -26 51 -74 20 -50 -56 -83 30 41 19 -19 -1 -36 -2 -1 33 -47 91 1 -15 -8 36 -10 -14 -65 -67 86 1 40 29 -16 -38 82 85 74 66 52 46 74 75 -85 86 43 20 -9 88 -15 40 73 -8 -14 90 96 -19 -58 46 -18 -99 58 -12 21 30 -40 69 59 -2 12 -52 7 31 -9 1 -82 -25 -29 11 99 -36 31 -54 69 -80 79 23 16 -20 -44 -7 33 -79 63 -5 -98 -29 -66 99 29 41 -96 66 31 10 17 37 8 55 -13 -63 -91 65 10 -64 -54 -77 97 -90 -61 62 -44 63 -57 48 -17 -85 -67 75 11 50 83 -62 94 -85 52 96 -39 -42 46 5 -38 40 -35 3 -9 97 -4 -67 -74 53 -65 -83 -27 74 -48 21 -80 -75 -32 16 2 -31 -30 -27 82 -28 23 24 19 7 -85 37 -25 79 9 -47 0 43 57 9 -49 -80 55 -66 -85 11 90 -31 -95 -42 -96 -88 -99 58 87 6 15 -77 71 77 -25 47 55 32 -27 3 26 -54 83 1 -42 53 23 10 99 3 -56 66 1 93 40 94 58 37 -43 -10 93 -48 92 95 62 -66 98 -54 89 -98 78 92 -37 -61 -99 90 -89 6 88 -20 -65 -47 -91 -62 16 88 -56 36 -6 -58 -36 39 3 86 66 -72 -50 31 47 -8 -71 84 5 -57 -60 84 -52 -14 62 -73 84 39 -95 45 -23 -5 -30 -85 -96 -51 14 17 -47 -67 -31 -28 56 63 -69 -1 -67 96 -69 -81 21 53 37 -82 -77 -89 38 35 -96 -55 50 -30 -56 59 53 -43 -77 -92 -86 -77 -39 -95 -56 -27 58 60 -16 -13 26 -20 -60 8 -93 23 -30 -34 -36 -77 89 1 100 11 1 -99 -84 -90 62 51 15 40 -78 7 64 -40 -21 8 -26 97 -22 -82 -53 69 -27 -41 -25 -36 -32 -81 -37 -27 -68 89 38 42 18 12 96 -39 10 -46 71 59 -48 51 -4 -62 -88 -50 70 1 -42 82 17 27 -3 -48 97 -68 80 -99 3 57 -71 44 -95 72 72 -81 -75 -73 30 -3 40 -65 -28 73 -42 80 -31 90 -6 45 7 21 -76 10 -76 9 -6 -5 -28 -26 70 -35 -30 -71 53 7 5 42 89 -95 -50 53 0 -40 -82 0 66 -48 55 79 -40 37 -6 30 44 17 52 86 39 42 -54 -48 -41 -83 -10 44 -79 -62 -57 44 1 -6 76 -25 -76 68 20 -84 98 -23 -54 -18 71 -78 52 -6 -12 -43 3 -66 -54 30 -15 -51 1 -29 -5 91 26 74 60 -85 97 80 -41 28 -78 12 38 54 -30 -86 -36 -92 75 -29 -67 7 86 38 -6 -31 -86 -19 -89 58 -88 -48 18 -65 86 19 -87 -51 96 61 -18 -57 96 56 -42 76 -3 6 -80 -72 36 95 -25 21 -92 94 -27 -67 -7 -8 17 -75 -29 55 -88 79 -73 42 97 -61 14 -66 -55 84 -15 -95 43 -19 54 99 44 52 50 -59 -27 21 -37 68 -38 -44 5 24 52 -73 0 -45 79 -4 -73 67 -96 -72 81 8 33 -51 23 60 -83 -34 67 42 100 60 -21 -22 -17 -64 57 84 -56 52 -32 39 3 35 26 -69 44 -13 -41 -62 -97 60 19 -31 -44 -73 -77 51 94 -70 -17 -90 -1 -12 -43 -98 -32 -90 89 -50 29 55 1 73 -59 39 -82 -68 -27 60 50 79 -97 2 -8 24 -34 41 -61 91 82 94 79 18 56 -34 -15 -81 -51 25 4 14 -94 -25 -33 -59 -18 -68 -95 27 -62 -37 -58 -23 75 -11 32 61 -44 -17 -90 -50 27 -73 -86 85 10 -74 87 57 -46 -32 -78 -85 -50 -94 44 -22 53 84 24 14 32 -45 -80 -39 51 -52 20 -35 -26 -62 4 23 44 -48 54
1 127 839
1 224 976
2 145 689
2 885 100
1 100 899
2 429 100
1 100 999
2 932 657
1 0 999
2 765 878
1 100 999
1 0 999
output =-1019
-2140
-777
-1573
-725
-189
93



*/

//
//import java.util.*;
//public class SegmentTree
//{
//    class SegmentTreeNode{
//        int start, end;
//        SegmentTreeNode left, right;
//        int sum;
//        public SegmentTreeNode(int start, int end) {
//            this.start = start;
//            this.end = end;
//            this.left = null;
//            this.right = null;
//            this.sum = 0;
//        }
//    }
//    SegmentTreeNode root = null;
//    public SegmentTree(int[] nums) {
//        root = buildTree(nums, 0, nums.length - 1);
//    }
//    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
//        if (start > end) {
//            return null;
//        }
//        SegmentTreeNode node = new SegmentTreeNode(start, end);
//        if (start == end) {
//            node.sum = nums[start];
//        } else {
//            int mid = start + (end - start) / 2;
//            node.left = buildTree(nums, start, mid);
//            node.right = buildTree(nums, mid + 1, end);
//            node.sum = node.left.sum + node.right.sum;
//        }
//        return node;
//    }
//    void update(int i, int val) {
//        update(root, i, val);
//    }
//    void update(SegmentTreeNode root, int pos, int val) {
//        if (root.start == root.end) {
//            root.sum = val;
//        } else {
//            int mid = root.start + (root.end - root.start) / 2;
//            if (pos <= mid) {
//                update(root.left, pos, val);
//            } else {
//                update(root.right, pos, val);
//            }
//            root.sum = root.left.sum + root.right.sum;
//        }
//    }
//    public int sumRange(int i, int j) {
//        return sumRange(root, i, j);
//    }
//    public int sumRange(SegmentTreeNode root, int start, int end) {
//        if (root.start == start && root.end == end) {
//            return root.sum;
//        } else {
//            int mid = root.start + (root.end - root.start) / 2;
//            if (end <= mid) {
//                return sumRange(root.left, start, end);
//            } else if (start >= mid + 1) {
//                return sumRange(root.right, start, end);
//            } else {
//                return sumRange(root.left, start, mid) + sumRange(root.right, mid + 1, end);
//            }
//        }
//    }
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int q = sc.nextInt();
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = sc.nextInt();
//        }
//        SegmentTree st = new SegmentTree(nums);
//        while (q-- > 0) {
//            int opt = sc.nextInt();
//            if (opt == 1) {
//                int s1 = sc.nextInt();
//                int s2 = sc.nextInt();
//                System.out.println(st.sumRange(s1, s2));
//            } else if (opt == 2) {
//                int ind = sc.nextInt();
//                int val = sc.nextInt();
//                st.update(ind, val);
//            }
//        }
//    }
//
//}