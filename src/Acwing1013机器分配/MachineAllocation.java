package Acwing1013机器分配;

import java.util.Scanner;

/**
 * http://ybt.ssoier.cn:8088/problem_show.php?pid=1266
 */
public class MachineAllocation {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] dp = new int[n + 1][m + 1], w = new int[n + 1][m + 1];
        int[] path = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                w[i][j] = sc.nextInt();
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k] + w[i][k]);
                }
            }
        }
        System.out.println(dp[n][m]);
        int j = m;
        for (int i = n;i>0;i--){
            for (int k = 0; k <= j; k++) {
                if (dp[i][j] == dp[i - 1][j - k] + w[i][k]) {
                    path[i] = k;
                    j -= k;
                    break;
                }
            }
        }
        for (int k = 1; k <= n; k++) {
            System.out.println(k + " " + path[k] + " ");
        }
    }

}
