package Acwing275传纸条;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/description/277/
 */
public class PassingANote {

    static Scanner sc = new Scanner(System.in);
    static int[][] w;
    static int[][][] dp;

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        w = new int[n + 1][m + 1];
        dp = new int[n + m + 1][n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                w[i][j] = sc.nextInt();
            }
        }

        for (int k = 2; k <= n + m; k++) {
            for (int i1 = 1; i1 <= n; i1++) {
                for (int i2 = 1; i2 <= n; i2++) {
                    int j1 = k - i1, j2 = k - i2;
                    if (j1 > 0 && j1 <= m && j2 > 0 && j2 <= m) {
                        int t = w[i1][j1];
                        if (i1 != i2) {
                            t += w[i2][j2];
                        }
                        for (int i = 0; i <= 1; i++) {
                            for (int j = 0; j <= 1; j++) {
                                dp[k][i1][i2] = Math.max(dp[k][i1][i2], dp[k - 1][i1 - i][i2 - j] + t);
                            }
                        }
                    }

                }
            }
        }
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= m; j++) {
//                System.out.print(w[i][j]+" ");
//            }
//            System.out.println();
//        }
//        for (int k = 2; k <= m + n; k++) {
//            for (int i = 1; i <= n; i++) {
//                for (int j = 1; j <= n; j++) {
//                    System.out.print(dp[k][i][j] + " ");
//                }
//                System.out.println();
//            }
//        }
        System.out.println(dp[n + m][n][n]);
    }

}
