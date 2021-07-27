package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] month = {" ", "Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        System.out.println("day count : "+dayCount(2,5));
        System.out.print("enter dd : ");
        int dd = sc.nextInt();
        System.out.println("enter mm : ");
        int mm = sc.nextInt();
        System.out.println("enter yy : ");
        int yy = sc.nextInt();
        int[] ansDay = dayForward(dd,mm,yy,5);
        System.out.println(ansDay[1]+" "+month[ansDay[2]]+" "+ansDay[3]);

    }
    public static int dayCount(int c,int d){
        int a = 0, b = 360, n = 0;
        while (a != b) {
            a = a + c;
            b = b - d;
            n++;
            //System.out.println("nnn" + n);
            if (b == 0) b = 360;
            if (a == 360) a = 0;
            //System.out.println("n" + "-->" + a + " " + b);
            if ((a == 0 && b == 360) || (a == 360 && b == 0)) break;
        }
        return n;
    }

    public static boolean leapyear(int year){
        if((year%4==0)&&((year%100!=0)||(year%400==0))) return true;
        else return false;
    }

    public static int [] dayForward(int dd, int mm, int yy, int noOfDay){
        int[] dayMonth = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        int sum=0;
        int [] ans = new int[4];
        if(leapyear(yy)) dayMonth[2]=29;
        while(sum<noOfDay){
            sum++; dd++;
            if(dd>dayMonth[mm]){
                dd=1; mm++;
                if(mm==13){
                    mm=1; yy++; dayMonth[2]=28;
                    if(leapyear(yy)) dayMonth[2]=29;
                }
            }
        }
        ans[1] = dd; ans[2]=mm; ans[3]=yy;
        return ans;
    }
}
