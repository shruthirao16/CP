package CP;
/*

 */

//import java.util.*;
//class Node{
//    int data;
//    Node next;
//
//    public Node(int data) {
//        this.data = data;
//        this.next = null;
//    }
//}
//
//
//class Solution
//{
//
//    Node getmid (Node head)
//    {
//        Node slow = head, fast=head;
//        while(fast.next!=null){
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        return slow;
//    }
//
//    Node reverse(Node head)
//    {
//        Node prev = null, curr = head, next;
//        while(curr != null){
//            next = curr.next;
//            curr.next = prev;
//            prev=curr;
//            curr = next;
//        }
//        return prev;
//    }
//
//    boolean isPalindrome(Node head)
//    {
//
//
//    }
//}
//
//
//
//public class D8P3
//{
//    public Node head = null;
//    public Node tail = null;
//
//    public void addNode(int data)
//    {
//        Node newNode = new Node(data);
//        if(head == null)
//        {
//            head = newNode;
//            tail = newNode;
//        }
//        else
//        {
//            tail.next = newNode;
//            tail = newNode;
//        }
//    }
//
//    public static void main(String[] args)
//    {
//        Scanner sc=new Scanner(System.in);
//        PalindromeList list = new PalindromeList();
//        String list2[]=sc.nextLine().split(" ");
//        for(int i=0;i<list2.length;i++)
//            list.addNode(Integer.parseInt(list2[i]));
//        Solution sl=new Solution();
//        System.out.println(sl.isPalindrome(list.head));
//    }
//}
//
//
////Your friend  is working on the singly linked list.
////He is given a list of boxes arranged as singly linked list,
////where each box is printed a positive number on it.
////
////Your task is to help your friend  to find the given list is equivalent to
////the reverse of it or not. If yes, print "true", otherwise print "false"
////
////Input Format:
////        -------------
////Line-1: space separated integers, boxes as list.
////
////Output Format:
////        --------------
////Print a boolean a value.
////
////Sample Input-1:
////        ---------------
////        3 6 2 6 3
////
////Sample Output-1:
////        ----------------
////        true
////
////
////Sample Input-2:
////        ---------------
////        3 6 2 3 6
////
////Sample Output-2:
////        ----------------
////        false
//
//////Code to create the Linked List of Nodes
////
////        import java.util.*;
////
////class Node{
////    int data;
////    Node next;
////
////    public Node(int data) {
////        this.data = data;
////        this.next = null;
////    }
////}
////
////
////class Solution
////{
////
////    Node getmid (Node head)
////    {
////
////    }
////
////    Node reverse(Node head)
////    {
////
////    }
////
////    boolean isPalindrome(Node head)
////    {
////
////    }
////}
////
////
////
////public class PalindromeList
////{
////    public Node head = null;
////    public Node tail = null;
////
////    public void addNode(int data)
////    {
////        Node newNode = new Node(data);
////        if(head == null)
////        {
////            head = newNode;
////            tail = newNode;
////        }
////        else
////        {
////            tail.next = newNode;
////            tail = newNode;
////        }
////    }
////
////    public static void main(String[] args)
////    {
////        Scanner sc=new Scanner(System.in);
////        PalindromeList list = new PalindromeList();
////        String list2[]=sc.nextLine().split(" ");
////        for(int i=0;i<list2.length;i++)
////            list.addNode(Integer.parseInt(list2[i]));
////        Solution sl=new Solution();
////        System.out.println(sl.isPalindrome(list.head));
////    }
////}