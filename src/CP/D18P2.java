package CP;

import java.util.*;

/*
Imagine you are analyzing the popularity of different songs on a music streaming platform.
Each song has been played a certain number of times, and you have a list of song IDs representing
these plays.

Your task is to identify the top k most played songs based on their frequency.
If two songs have been played the same number of times, the song with the higher ID should be prioritized.

Challenge:

Given a list of song IDs representing plays and an integer k, determine the k most popular songs,
sorted in descending order of play count. If multiple songs have the same number of plays,
the song with the higher ID should appear first.

Are you ready to rank the top hits?

Input Format:
-------------
Line-1: An integer N, representing the number of elements in the array.
Line-2: A line with N space-separated integers representing the elements of the array.
Line-3: An integer k, representing the number of most frequent elements to return.

Output Format:
--------------
Line-1: An array, comma-separated integers in descending order of frequency.
If two elements have the same frequency, the higher number should appear first.


Sample Input-1:
--------------
6
1 1 1 2 2 3
2

Sample Output-1:
----------------
[1, 2]


Sample Input-2:
--------------
1
1
1

Sample Output-2:
----------------
[1]

 */
public class D18P2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        freq(arr, k, n);

    }
    public static void freq(int[] arr, int k, int n){
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i : arr){
            hm.put(i, hm.getOrDefault(i, 0)+1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a,b)-> (hm.get(b).equals(hm.get(a))) ? Integer.compare(b.getKey(), a.getKey()) :Integer.compare(b.getValue(), a.getValue())
        );

        pq.addAll(hm.entrySet());
        for(int i=0; i<k; i++){
            res.add(pq.poll().getKey());
        }
        System.out.println(res);
    }
}
