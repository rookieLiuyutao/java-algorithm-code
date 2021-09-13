package Acwing1118质数分组;

import java.util.Scanner;

/**
 * http://ybt.ssoier.cn:8088/problem_show.php?pid=1221
 */
public class PrimeNumberGrouping {
    static Scanner sc = new Scanner(System.in);
    static int[] a = new int[10];
    static int[][] group = new int[10][10];
    static boolean[] st = new boolean[10];
    static int n, res = 10;

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static boolean check(int[] group, int gc, int x) {
        for (int i = 0; i < gc; i++) {
            if (gcd(a[group[i]], a[x]) > 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param u     当前在搜哪一组
     * @param gc    当前组数的数量
     * @param tc    总共搜过的数的数量
     * @param start 当前组从哪开始搜
     */
    static void dfs(int u, int gc, int tc, int start) {
        if (u >= res) {
            return;
        }
        if (tc == n) {
            res = u;
            return;
        }
        for (int i = start; i < n; i++) {
            if (check(group[u], gc, i) && !st[i]) {
                st[i] = true;
                group[u][gc] = i;
                dfs(u, gc + 1, tc + 1, i + 1);
                st[i] = false;
            }
        }
        dfs(u + 1, 0, tc + 1, 0);
    }

    public static void main(String[] args) {
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        dfs(1, 0, 0, 0);
        System.out.println(res);
    }
}
