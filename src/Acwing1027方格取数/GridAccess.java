package Acwing1027方格取数;

import java.util.Scanner;

/**
 * 线性dp 数字三角形模型
 * https://www.luogu.com.cn/problem/P1004
 */
public class GridAccess {

    static Scanner sc = new Scanner(System.in);

    static int N = 15;
    static int[][][] dp = new int[N * 2][N][N];
    static int[][] w = new int[N][N];

    public static void main(String[] args) {
        int n = sc.nextInt();
        while (sc.hasNext()) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            if (a == 0 && b == 0 && c == 0) {
                break;
            }
            w[a][b] = c;
            for (int k = 2; k <= n * 2; k++) {
                for (int i1 = 1; i1 <= n; i1++) {
                    for (int i2 = 1; i2 <= n; i2++) {
                        int j1 = k - i1, j2 = k - i2;
                        if (j1 > 0 && j1 <= n && j2 > 0 && j2 <= n) {
                            int t = w[i1][j1];
                            if (i1 != i2) {
                                t += w[i2][j2];
                            }
                            dp[k][i1][i2] = Math.max(dp[k][i1][i2], dp[k-1][i1 - 1][i2 - 1]+t) ;
                            dp[k][i1][i2] = Math.max(dp[k][i1][i2], dp[k - 1][i1 - 1][i2]+t) ;
                            dp[k][i1][i2] = Math.max(dp[k][i1][i2], dp[k - 1][i1][i2 - 1]+t) ;
                            dp[k][i1][i2] = Math.max(dp[k][i1][i2], dp[k - 1][i1][i2]+t) ;
                        }
                    }
                }
            }
        }
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= n; j++) {
//                System.out.print(w[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println(dp[n * 2][n][n]);
    }
}
