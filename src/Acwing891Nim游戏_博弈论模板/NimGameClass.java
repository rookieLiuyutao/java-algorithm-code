package Acwing891Nim游戏_博弈论模板;

import java.util.Scanner;

/**
 * @see 博弈论 https://www.luogu.com.cn/problem/P2197
 */
public class NimGameClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        while (m-- != 0) {
            int n = sc.nextInt();
            int res = 0;
            while (n-- != 0) {
                int x = sc.nextInt();
                res ^= x;
            }
            if (res == 0) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        }

    }


}
