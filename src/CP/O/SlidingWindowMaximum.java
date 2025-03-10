package CP.O;

import java.util.*;
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int[] res = maxSlidingWindow(arr, k, n);
        System.out.println(res.toString());
    }
    public static int[] maxSlidingWindow(int[] nums, int k, int n) {
        //ArrayList<Integer> al = new ArrayList<>();
        int[] arr = new int[nums.length-2];
        Deque<Integer> pq = new LinkedList<>();
        for(int i=0; i<n; i++){
            while(!pq.isEmpty() && pq.peek()<i-k+1){
                pq.poll();
            }
            while(!pq.isEmpty() && nums[pq.peek()]<nums[i]){
                pq.poll();
            }
            pq.offer(i);

            int x=0;
            if(i>=k-1){
                //al.add(pq.peekFirst());
                arr[x]=pq.peek();
                if(x<arr.length-1) x++;
            }
        }
        //return al;
        return arr;
    }
}
