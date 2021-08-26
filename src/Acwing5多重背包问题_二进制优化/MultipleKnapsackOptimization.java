package Acwing5多重背包问题_二进制优化;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/6/
 * 多重背包二进制优化模板
 */
public class MultipleKnapsackOptimization {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt(), m = sc.nextInt();
        int[] dp = new int[m + 1];
        for (int i = 0; i < n; i++) {
            int v = sc.nextInt(), w = sc.nextInt(), s = sc.nextInt();
            for (int k = 1; k <= s; k *= 2) {
                for (int j = m; j >= k * v; j--) {
                    dp[j] = Math.max(dp[j], dp[j - k * v] + k * w);
                }
                s -= k;
            }
            if (s > 0) {
                for (int j = m; j >= s * v; j--) {
                    dp[j] = Math.max(dp[j], dp[j - s * v] + s * w);
                }
            }
        }
        System.out.println(dp[m]);
    }

}
