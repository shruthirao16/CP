package CP;

import java.util.Scanner;

/*
Tubby a Third Class Student has given a Assignment on Time Chapter by his class teacher.
Tubby is supposed to change the time given in AM/PM Format to 24 Hours Format.
Help Tubby Solve the Problem

The Maths teacher gave him the time in the following Format - HH:MM:SS:AM/PM

Assume all HH,MM,SS are in the valid range only

Note: Midnight is 12:00:00AM on a 12-hour clock,  and 00:00:00 on a 24-hour clock.
Noon is 12:00:00PM on a 12-hour clock,  and 12:00:00 on a 24-hour clock.

Assume all input times are valid


Example:
input = 06:10:20PM
output = 18:10:20




 */
public class D10P3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        time(s);
    }
    public static void time(String s){
        int h = Integer.parseInt(s.substring(0,2));
        String m = s.substring(3,5);
        String ss = s.substring(6,8);
        String str =s.substring(8,10);
        if(str.equals("PM")){
            if(h==12) h=0;
            else if(h!=12) h+=12;
        }
        System.out.printf("%02d:%s:%s\n", h, m, ss);
    }
}
