package ccf201509_2日期计算;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/3221/
 */
public class DateCalculation {
    static Scanner sc = new Scanner(System.in);
    static int []months = {0,31,28,31,30,31,30,31,31, 30,31,30,31};
    static boolean isLeap(int year){
        return year%400==0||year%4==0&&year%100!=0;
    }
    static int getMonthDays(int year,int month){
        if (isLeap(year)&&month==2){
            return months[month]+1;
        }
        return months[month];
    }

    public static void main(String[] args) {
        int y = sc.nextInt(),d = sc.nextInt();
        int pass = 0;
        for(int month = 1; month <=12; month++) {
          int days = getMonthDays(y,month);
          if (pass+days>=d){
              System.out.println(month);
              System.out.println(d-pass);
              break;
          }
          pass+=days;
        }
    }

}
