package Acwing426开心的金明;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/428/
 * 背包问题
 */
public class HappyJinMing {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int money = sc.nextInt();
        int n = sc.nextInt();
        int[] dp = new int[money + 1];
        for (int i = 0; i < n; i++) {
            int v = sc.nextInt(), p = sc.nextInt();
            for (int j = money; j >= v; j--) {
                dp[j] = Math.min(dp[j], dp[j - v] + p * v);
            }
        }
        System.out.println(dp[money]);
    }

}
