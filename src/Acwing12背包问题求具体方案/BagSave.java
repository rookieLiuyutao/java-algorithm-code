package Acwing12背包问题求具体方案;

import java.util.Scanner;

/**
 * @see 12.背包问题求具体方案 https://www.acwing.com/problem/content/12/
 * 数据范围
 * 0<N,V≤1000
 * 0<vi,wi≤1000
 */
public class BagSave {
    static int N = 1010;
    static int n, v;//n为物品数量，v为背包容量
    static int[] volume = new int[N], worth = new int[N];
    static int[][] dp = new int[N][N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        v = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            volume[i] = sc.nextInt();
            worth[i] = sc.nextInt();
        }


//        for (int i = 1; i <= n; i++) {
//            for (int j = 0; j <= v; j++) {
//                dp[i][j] = dp[i - 1][j];
//                if (j >= volume[i - 1]) {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - volume[i - 1]] + worth[i - 1]);
//                }
//
//            }
//
//        }
        //倒着dp
        for (int i = n; i>=1; i -- ) {
            for (int j = 0; j <= v; j++) {
                dp[i][j] = dp[i + 1][j];
                if (j >= volume[i])
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - volume[i]] + worth[i]);
            }
        }
        int i = 1, j = v;
        while (i <= n) {
            if (j >= volume[i] && dp[i + 1][j - volume[i]] +worth[i]>= dp[i + 1][j]) {
                System.out.print(i + " ");
                j -= volume[i];
                i++;
            } else {
                i++;
            }
        }
    }
}
