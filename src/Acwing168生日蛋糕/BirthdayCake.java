package Acwing168生日蛋糕;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/170/
 */
public class BirthdayCake {
    static final int N = 25;
    static Scanner sc = new Scanner(System.in);
    static int n, m, ans = 100000;
    static int[] mv = new int[N], ms = new int[N], rArr = new int[N], hArr = new int[N];

    static void dfs(int u, int v, int s) {
        if (v + mv[u] > n) {
            return;
        }
        if (s + ms[u] >= ans) {
            return;
        }
        if (s + 2 * (n - v) / rArr[u + 1] >= ans) {
            return;
        }
        if (u == 0) {
            if (v == n) {
                ans = s;
            }
            return;
        }
        for (int r = Math.min((int) Math.sqrt(n - v), rArr[u + 1] - 1); r >= u; r--) {
            for (int h = Math.min((n - v) / r / r, hArr[u + 1] - 1); h >= u; h--) {
                int t = 0;
                if (u == m) {
                    t = r * r;
                }
                rArr[u] = r;
                hArr[u] = h;
                dfs(u - 1, r * r * h, 2 * r * h + t);
            }
        }
    }

    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 1; i <= m; i++) {
            mv[i] = mv[i - 1] + i * i * i;
            ms[i] = ms[i - 1] + 2 * i * i;
        }
        rArr[m + 1] = hArr[m + 1] = 100000;
        dfs(m, 0, 0);
        if (ans == 100000) {
            ans = 0;
        }
        System.out.println(ans);
    }

}
