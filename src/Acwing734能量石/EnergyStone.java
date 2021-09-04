package Acwing734能量石;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/736/
 */
public class EnergyStone {

    static class Stone {
        int s, e, l;

        public Stone(int s, int e, int l) {
            this.s = s;
            this.e = e;
            this.l = l;
        }
    }
    static final int INF = 0x3f3f3f;
    static Scanner sc = new Scanner(System.in);
    static int[] dp = new int[100010];

    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int u = 1; u <= t; u++) {
            int n = sc.nextInt();

            int sum = 0;
            Stone[] stones = new Stone[n + 1];
            for (int i = 1; i <= n; i++) {
                int s = sc.nextInt(), e = sc.nextInt(), l = sc.nextInt();
                stones[i] = new Stone(s, e, l);
                sum += s;
            }
            Arrays.sort(stones, 1, n + 1, (o1, o2) -> o1.s * o2.l - o2.s * o1.l);
            Arrays.fill(dp,-INF);
            dp[0] = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = sum; j >= stones[i].s; j--) {
                    dp[j] = Math.max(dp[j - stones[i].s] + stones[i].e - (j - stones[i].s) * stones[i].l, dp[j]);
                }
            }
            int res = 0;
            for (int i = 0; i <= sum; i++) {
                res = Math.max(res, dp[i]);
            }
            System.out.println("Case #"+u+": "+res);
        }
    }

}
