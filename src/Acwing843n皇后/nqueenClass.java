package Acwing843n皇后;

import java.util.Scanner;

/**
 * @see 深搜 https://www.acwing.com/problem/content/845/
 */
class nQueenClass {

    static final int N = 20;
    static int n;
    static char[][] checkerboard ;
    static boolean[] col = new boolean[N], lDiagonal = new boolean[N], rDiagonal = new boolean[N];

    /**
     * 按行搜索：每行只能放一个皇后，所以我们枚举一行的各种情况下的放法
     */
    static void dfs(int u) {
        if (u == n) {
            for (int j = 0; j < n; j++) {
                System.out.println(checkerboard[j]);
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!col[i] && !lDiagonal[i + u] && !rDiagonal[n - u + i]) {
                checkerboard[u][i] = 'Q';
                col[i] = lDiagonal[u + i] = rDiagonal[n - u + i] = true;
                dfs(u + 1);
                col[i] = lDiagonal[u + i] = rDiagonal[n - u + i] = false;
                checkerboard[u][i] = '.';
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        checkerboard = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                checkerboard[i][j] = '.';
            }
        }
        dfs(0);
    }

}
