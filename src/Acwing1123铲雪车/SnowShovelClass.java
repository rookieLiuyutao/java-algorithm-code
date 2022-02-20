package Acwing1123铲雪车;

import java.util.Scanner;

/**
 * @see 有向图欧拉路径 http://ybt.ssoier.cn:8088/problem_show.php?pid=1374
 * https://www.acwing.com/solution/content/4877/
 */
public class SnowShovelClass {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double sum = 0;
        int x0 = sc.nextInt();
        int y0 = sc.nextInt();
        while (sc.hasNext()){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            double d = Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
            sum+=d*2;

        }
        long time = Math.round(sum/1000/20*60);
        long hour = time/60;
        long minute = time%60;
        System.out.printf("%d:%02d\n",hour,minute);
    }

}
