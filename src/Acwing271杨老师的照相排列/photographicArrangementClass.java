package Acwing271杨老师的照相排列;

/**
 * @see 线性dp https://www.acwing.com/problem/content/description/273/
 */

import java.util.Scanner;

public class photographicArrangementClass {
    static int N = 31;
    static long[][][][][] dp = new long[N][N][N][N][N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int k = sc.nextInt();
            if (k == 0) break;
            int[] row = new int[5];
            for (int i = 0; i < k; i++) {
                row[i] = sc.nextInt();
            }
            dp[0][0][0][0][0] = 1;
            for (int a = 0; a <= row[0]; a++) {
                for (int b = 0; b <= Math.min(a, row[1]); b++) {
                    for (int c = 0; c <= Math.min(b, row[2]); c++) {
                        for (int d = 0; d <= Math.min(c, row[3]); d++) {
                            for (int e = 0; e <= Math.min(d, row[4]); e++) {
                                if (a > 0) dp[a][b][c][d][e] = dp[a - 1][b][c][d][e];
                                if (b > 0) dp[a][b][c][d][e] += dp[a][b - 1][c][d][e];
                                if (c > 0) dp[a][b][c][d][e] += dp[a][b][c - 1][d][e];
                                if (d > 0) dp[a][b][c][d][e] += dp[a][b][c][d - 1][e];
                                if (e > 0) dp[a][b][c][d][e] += dp[a][b][c][d][e - 1];

                            }
                        }
                    }
                }
            }
            System.out.println(dp[row[0]][row[1]][row[2]][row[3]][row[4]]);
        }
    }


}
