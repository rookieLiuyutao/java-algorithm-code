package Acwing9分组背包问题;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/9/
 */
public class GroupKnapsackProblem {
    static Scanner sc = new Scanner(System.in);
    static final int N = 105;
    static int[] v = new int[N], w = new int[N], dp = new int[N];

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            int s = sc.nextInt();
            for (int j = 1; j <= s; j++) {
                v[i] = sc.nextInt();
                w[i] = sc.nextInt();
            }
            for (int j = m; j >= 0; j--) {
                for (int k = 1; k <= s; k++) {
                    if (j>=v[k]){
                        dp[j] = Math.max(dp[j], dp[j - v[k]] + w[k]);
                    }
                }
            }
        }
        System.out.println(dp[m]);
    }


}
