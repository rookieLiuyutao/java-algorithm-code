package Acwing1010导弹拦截;

import java.util.Scanner;
/**
 * 线性dp
 * https://www.luogu.com.cn/problem/P1020
 * nlogn
 * https://www.acwing.com/solution/content/6525/
 */
public class MissileInterception {

    static Scanner sc = new Scanner(System.in);
    static final int N = 100010;
    static int[] dp = new int[N], q = new int[N], g = new int[N];
    static int n;

    public static void main(String[] args) {
        while (sc.hasNext()) {
            q[n++] = sc.nextInt();
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (q[j] > q[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            int k = 0;
            while (k < count && g[k] < q[i]) {
                k++;
            }
            g[k] = q[i];
            if (k >= count) {
                count++;
            }
        }
        System.out.println(res);
        System.out.println(count);
    }


}
