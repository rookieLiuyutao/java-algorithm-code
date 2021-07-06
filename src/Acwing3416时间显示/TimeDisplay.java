package Acwing3416时间显示;

import java.util.Scanner;

/**
 * @see 字符串 https://www.acwing.com/problem/content/3419/
 */
public class TimeDisplay {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        long second = sc.nextLong();
        second /= 1000;
        long z = second % 60;
        second/=60;
        long y = second%(60);
        second/=60;
        long x = second % 24;
        System.out.printf("%02d:%02d:%02d",x,y,z);
    }

}
