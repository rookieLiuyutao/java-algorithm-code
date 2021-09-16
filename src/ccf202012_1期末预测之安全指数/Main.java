package ccf202012_1期末预测之安全指数;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/3300/
 */
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        int res = 0;
        for(int i = 0; i <n; i++) {
            int x = sc.nextInt(),y = sc.nextInt();
            res+=x*y;
        }
        System.out.println(Math.max(res, 0));
    }

}
