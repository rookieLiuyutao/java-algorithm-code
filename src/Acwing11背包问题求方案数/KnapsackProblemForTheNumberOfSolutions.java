package Acwing11背包问题求方案数;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/description/11/
 */
public class KnapsackProblemForTheNumberOfSolutions {

    static Scanner sc = new Scanner(System.in);
    static final int MOD = (int) 1e9 + 7, INF = (int) 10e4;
    static int n, m;
    //paln数组储存体积为j时的方案数
    static int[] dp, plan;

    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();
        dp = new int[m + 2];
        plan = new int[m + 2];
        for (int i = 0; i <= m; i++) {
            plan[i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            int v = sc.nextInt(), w = sc.nextInt();
            for (int j = m; j >= v; j--) {
                //用t保存两个状态中的一个
                int t = dp[j - v] + w;
                if (t > dp[j]) {
                    //将两个值中的最大的一个
                    dp[j] = t;
                    plan[j] = plan[j - v];
                } else if (t == dp[j]) {
                    plan[j] = (plan[j] + plan[j - v]) % MOD;
                }
            }
        }
        System.out.println(plan[m]);
    }

}
