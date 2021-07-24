package Acwing8二维费用背包问题;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/8/
 */
public class TwoDimensionalCostBackpack {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt(), v = sc.nextInt(), m = sc.nextInt();
        int[][] dp = new int[v + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            int sv = sc.nextInt(), sm = sc.nextInt(), w = sc.nextInt();

            for (int j = v; j >= sv; j--) {
                for (int k = m; k >= sm; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - sv][k - sm] + w);
                }
            }
        }
        System.out.println(dp[v][m]);
    }


}
