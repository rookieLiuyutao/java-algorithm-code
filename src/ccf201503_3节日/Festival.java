package ccf201503_3节日;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/3217/
 * 日期模拟
 */
public class Festival {

    static Scanner sc = new Scanner(System.in);
    static int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    static boolean isLeap(int year) {
        return year % 400 == 0 || year % 4 == 0 && year % 100 != 0;
    }

    static int getMonthDays(int year, int month) {
        if (month == 2 && isLeap(year)) {
            return months[month]+1;
        }
        return months[month];
    }

    public static void main(String[] args) {
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt(), y1 = sc.nextInt(), y2 = sc.nextInt();
        int days = 0;
        for (int year = 1850; year <= y2; year++) {
            for (int month = 1; month <= 12; month++) {
                if (year >= y1 && month == a) {
                    int week = (days + 1) % 7, count = 0;
                    for (int day = 1; day <= getMonthDays(year, month); day++) {
                        if (week == c - 1) {
                            count++;
                            if (count == b) {
                                System.out.printf("%04d/%02d/%02d\n", year, month, day);
                                break;
                            }
                        }
                        week = (week + 1) % 7;
                    }
                    if (count < b) {
                        System.out.println("none");
                    }
                }
            days+=getMonthDays(year,month);
            }
        }
    }

}
