package AcWing3489星期几;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @see 模拟题 https://www.acwing.com/problem/content/3492/
 */
public class dayOfTheWeekClass {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //思路：因为1年1月1日是星期一（已知）
        //算出所求日期与此的差值，即为过的总天数
        //因为不管在哪年哪月，一周都是7天，用总天数除以7的余数即为今天星期几
        while (sc.hasNext()) {
            HashMap<String, Integer> map = new HashMap<>();
            map.put("January", 1);
            map.put("February", 2);
            map.put("March", 3);
            map.put("April", 4);
            map.put("May", 5);
            map.put("June", 6);
            map.put("July", 7);
            map.put("August", 8);
            map.put("September", 9);
            map.put("October", 10);
            map.put("November", 11);
            map.put("December", 12);
            String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
            int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            int day = sc.nextInt();
            String month = sc.next();
            int year = sc.nextInt();
            //days表示从1年1月1日算起过了几天
            int days = 0;
            //算“年”过了多少天
            for (int years = 1; years < year; years++) {
                for (int i = 1; i <= 12; i++) {
                    days += months[i];
                    //特判闰年
                    if (i == 2) {
                        if (years % 4 == 0 && years % 100 != 0 || years % 400 == 0) {
                            days++;
                        }
                    }
                }
            }
            //算“月”过了多少天
            for(int m = 1; m < map.get(month); m++) {
              days+=months[m];
                if (m == 2) {
                    if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                        days++;
                    }
                }
            }
            //已经加过了“年”，“月”；把“日”加上因为起点是1月1日，相当于多加了1，要减去
            days += day-1;
            System.out.println(week[days % 7]);
        }
    }

}
