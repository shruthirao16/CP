package CP;


import java.util.HashSet;
import java.util.*;

public class Test{
    public static void main(String[] args) {
        System.out.println(8>>1);
    }
}




//class Employee
//{
//    String ename;
//    int eno;
//    Employee(String ename,int eno)
//    {
//        this.ename = ename;
//        this.eno = eno;
//    }
//    public boolean equals(Object o)
//    {
//        if(o instanceof Employee)
//        {
//            Employee e=(Employee)o;
//            if(this.eno == e.eno && this.ename.equals(e.ename))
//                return true;
//        }
//        return false;
//    }
//}
//
//class EmployeeTest
//{
//    public static void main(String[] args)
//    {
//        Employee e1 =new Employee("Satyam",100);
//        Employee e2=new Employee("Satyam",100);
//        System.out.println(e1==e2);
//        System.out.println(e1.equals(e2));
//
//
//    }
//}

//public class Test{


//    public static void main(String[] args)
//    {
//	/*	String a="kmit";
//		String b="kmit";
//
//		System.out.println(a==b);
//		System.out.println(a.equals(b));*/
//
//
//
//        String a="kmit";
//        String b=new String("kmit");
//
//        System.out.println(a==b);
//        System.out.println(a.equals(b));
//
//
//    }

//}





//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        char[] s1 = sc.next().toCharArray();
//        char[] s2 = sc.next().toCharArray();
//
//        sc.nextLine();
//        System.out.println(solve(s1, s2));
//        //System.out.println(solve(s1+" "+s2));
//
//    }
//    // public static boolean solve(String s1, String 2){
//    //     int i=0, j=s2.length()-1;
//    //     while(i<s1.length()-1 && j>=0){
//    //         id(s1,charAt(i)!=s2.charAt(j))
//    //     }
//    // }
//    public static boolean solve(char[] s1, char[] s2){
//        ArrayList<Integer> al = new ArrayList<>();
//        for(int i=0; i<s1.length; i++){
//            al.add((int)s1[i]);
//        }
//        for(int i=0; i<s2.length; i++){
//            al.add((int)s2[i]);
//        }
//        int i=0, j=al.size()-1;
//        while(i<=j){
//            if(al.get(i) != al.get(j)) return false;
//        }
//        return true;
//    }







// public static void main(String[] args){
//     Scanner sc = new Scanner(System.in);
//     int n1 = sc.nextInt();
//     int n2 = sc.nextInt();
//     int[] arr = new int[n1+n2];
//     for(int i=0; i<n1; i++){
//         arr[i] = sc.nextInt();
//     }
//     for(int i=0; i<n2; i++){
//         arr[n1+i] = sc.nextInt();
//     }
//     System.out.println(solve(arr));
// }
// public static boolean solve(int[] arr){
//     int i=0, j=arr.length-1;
//     while(i<=j){
//         if(arr[i] != arr[j]) return false;
//         i++; j--;
//     }
//     return true;
// }


