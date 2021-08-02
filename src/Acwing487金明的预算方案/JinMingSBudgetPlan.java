package Acwing487金明的预算方案;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/description/489/
 * 分组背包拓展
 */
public class JinMingSBudgetPlan {
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static final int N = 32010, M = 70;
    static Scanner sc = new Scanner(System.in);
    static Point[] master = new Point[N];
    static ArrayList<Point>[] s = new ArrayList[N];
    static int[] dp = new int[N];

    public static void main(String[] args) {
        int m = sc.nextInt();
        int n = sc.nextInt();
        for (int i = 0; i < N; i++) {
            s[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            int v = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();
            p *= v;
            if (q == 0) {
                master[i] = new Point(v, p);
            } else {
                s[q].add(new Point(v, p));
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= 0; j--) {
                for (int k = 0; k < (1 << s[i].size()); k++) {
                    if (master[i] == null) {
                        continue;
                    }
                    int v = master[i].x, w = master[i].y;
                    for (int u = 0; u < s[i].size(); u++) {
                        if (((k >> u) & 1) == 1) {
                            v += s[i].get(u).x;
                            w += s[i].get(u).y;
                        }
                    }
                    if (j>=v){
                        dp[j]  = Math.max(dp[j],dp[j-v]+w);
                    }
                }
            }
        }
        System.out.println(dp[m]);
    }

}
