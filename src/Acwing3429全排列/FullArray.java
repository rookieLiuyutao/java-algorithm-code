package Acwing3429全排列;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/3432/
 * 深搜 dfs
 */
public class FullArray {

    static Scanner sc = new Scanner(System.in);
    static int n;

    static char[] path = new char[10], a = new char[10];
    static boolean[] st = new boolean[10];

    static void dfs(int u) {
        if (u >= n) {
            for (int i = 0; i < n; i++) {
                System.out.println(path[i]);
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!st[i]) {
                path[u] = a[i];
                st[i] = true;
                dfs(u+1);
                st[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        String ss = sc.nextLine();
        a = ss.toCharArray();
        n = a.length;
        dfs(0);
    }
}
