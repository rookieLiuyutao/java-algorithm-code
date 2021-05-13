package AcWing3499序列最大收益;

import java.util.Scanner;

/**
 * @see 动态规划 https://www.acwing.com/problem/content/3502/
 */
public class maximumProfitClass {
    static int N = 210;
    static int m, n, k;
    static int[] arr = new int[N];
    static int[][] worth = new int[N][N];
    static int[][] dp = new int[N][N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        m = sc.nextInt();
        for (int i = 1; i <= m; i++) {
            arr[i] = sc.nextInt();

        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                worth[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        //集合：表示以原数组的第i个元素结尾，删除了j个数
        //属性：max
        //划分：倒数第二个数是原数组的第几个数
        //考虑在倒数第二个数与倒数第一个数之间，被删去了i-k-1个数，那么在倒数第二个数之前，被删了j-(i-k-1)个数
        //因为最后两个数已经确定，要使得前k个数的收益最大
        dp[1][0] = 0;
        for (int i = 2; i <= m; i++) {
            for (int j = 0; j <= k; j++) {
                for (int u = 1; u < i; u++) {
                    if (j >= i - u - 1) {
                        //最后两个数是原数组中第u和第i个数
                        dp[i][j] = Math.max(dp[i][j], dp[u][j - (i - u - 1)] + worth[arr[u]][arr[i]]);

                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i <= k; i++) {
            res = Math.max(res, dp[m][i]);
        }
        System.out.println(res);
    }


}
