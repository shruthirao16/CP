import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class UniqueSplit {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer>l=new ArrayList<Integer>();
        if(divide(n,l)){
            System.out.print(l);
        }
        else{
            System.out.print(new ArrayList<Integer>());
        }
    }
    public static boolean divide(int n,List<Integer>l){
        if(n%2!=0) return false;

        if(n==0) return true;

        // if(n==2){
        //     l.add(2);
        //     return true;
        // }
        for(int i=2;i<=n;i=i+2){
            if(done(i,l,n)){
                l.add(i);
                if(divide(n-i,l)){
                    return true;
                }
                l.remove(l.size()-1);
            }
        }
        return false;
    }
    public static boolean done(int i,List<Integer>l,int n){
        if(l.contains(i) || l.contains(n) || l.contains(n-i) || (n-i)<0 ){
            return false;
        }
        return true;
    }
}


//public class UniqueSplit {
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        System.out.println(maxSplit(n));
//    }
//    public static List<Integer> maxSplit(int n){
//        List<Integer> res = new ArrayList<>();
//        if(n%2 != 0) return res;
//
//        int num=0, sum=0;
//        while(num<=n){
//            num += 2;
//            sum += num;
//            if(sum>n){
//                sum-=num;
//                res.add(res.removeLast()+(n-sum));
//                return res;
//            }
//            res.add(num);
//        }
//        return res;
//    }
//}

//A system is designed to distribute even-sized allocations for a given
//resourceLimit. The goal is to maximize the number of unique allocations
//while ensuring that their sum equals resourceLimit.
//
//Given an integer resourceLimit, split it into a sum of a maximum number of
//unique positive even integers. The following conditions must be met:
//        - Each allocation must be a unique positive even integer.
//    - The total sum of the integers must equal resourceLimit.
//    - The number of integers in the split must be maximized.
//
//If it is not possible to split resourceLimit into valid even allocations,
//return an empty list.
//
//Input Format:
//        -------------
//A single integer, resourceLimit (1 ≤ resourceLimit ≤ 10^9).
//
//Output Format:
//        --------------
//A list of integers representing the allocations.
//If no valid allocations exist, return an empty list.
//
//
//Sample Input-1:
//        ---------------
//        12
//
//Sample Output-1:
//        ----------------
//        [2, 4, 6]
//
//Explanation:
//        ------------
//The possible splits are:
//        - [12] (1 allocation)
//        - [2, 10] (2 allocations)
//        - [2, 4, 6] (3 allocations)
//The split [2, 4, 6] has the maximum number of allocations.
//
//
//Sample Input-2:
//        ---------------
//        7
//
//Sample Output-2:
//        ----------------
//        []
//
//Explanation:
//        ------------
//It's not possible to split 7 into unique positive even integers.
//
//Sample Input-3:
//        ---------------
//        28
//
//Sample Output-3:
//        ----------------
//        [2, 4, 6, 16]
//
//Explanation:
//The possible splits are:
//        - [2, 26] (2 allocations)
//        - [6, 8, 2, 12] (4 allocations)
//        - [2, 4, 6, 16] (4 allocations)
//
//The split [2, 4, 6, 16] has the maximum number of allocations.
//
//NOTE:
//        =====
//Please refer the sample outputs to generate the solution.
