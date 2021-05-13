package Acwing897最长公共子序列;

import java.util.Scanner;

/**
 * @see 线性dp https://www.acwing.com/problem/content/899/
 */
public class longestCommonSubsequenceClass {
    static int N = 1010;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        String a = sc.next();
        String b = sc.next();

        String sa = " " + a;
        String sb = " " + b;

        char[] cs1 = sa.toCharArray();
        char[] cs2 = sb.toCharArray();

        int[][] dp  = new int[n+1][m+1];

        for(int i = 0; i <=n; i++) {
            for(int j = 0; j <=m; j++) {
                dp[i][j]= 0;
            }
        }

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= m; j++) {
                if (cs1[i]==cs2[j]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
