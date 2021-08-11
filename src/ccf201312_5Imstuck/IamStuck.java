package ccf201312_5Imstuck;

import java.io.*;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/3199/
 */
public class IamStuck {
    static Scanner sc = new Scanner(System.in);

    static int n, m;
    static char[][] g;
    static boolean[][] st1, st2;
    static int[] dx = {-1, 0, 1, 0}, dy = {0,1,0,-1};

    static boolean check(int x, int y, int k) {
        char c = g[x][y];
        if (c == '+' || c == 'S' || c == 'T') {
            return true;
        }
        if (c=='-'&&(k==1||k==3)){
            return true;
        }
        if (c=='|'&&(k==0||k==2)){
            return true;
        }
        if (c=='.'&&(k==2)){
            return true;
        }
        return false;
    }

    static void dfs1(int x, int y) {
        st1[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int a = x + dx[i], b = y + dy[i];
            if (a < 0 || a >= n || b < 0 || b >= m || g[a][b] == '#') {
                continue;
            }
            if (st1[a][b]) {
                continue;
            }
            if (check(x, y, i)) {
                dfs1(a, b);
            }
        }

    }

    static void dfs2(int x, int y) {
        st2[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int a = x + dx[i], b = y + dy[i];
            if (a < 0 || a >= n || b < 0 || b >= m || g[a][b] == '#') {
                continue;
            }
            if (st2[a][b]) {
                continue;
            }
            if (check(a, b, i ^ 2)) {
                dfs2(a, b);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        n = sc.nextInt();
        m = sc.nextInt();
        g = new char[n + 1][m + 1];
        st1 = new boolean[n + 1][m + 1];
        st2 = new boolean[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            String ss = sc.next();
            for (int j = 0; j < m; j++) {
                g[i][j] = ss.charAt(j);
            }
        }
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == 'S') {
                    dfs1(i, j);
                } else if (g[i][j] == 'T') {
                    x = i;
                    y = j;
                    dfs2(i, j);
                }
            }
        }
        if (!st1[x][y]) {
            System.out.println("I'm stuck!");
            return;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (st1[i][j] && !st2[i][j]) {
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}
