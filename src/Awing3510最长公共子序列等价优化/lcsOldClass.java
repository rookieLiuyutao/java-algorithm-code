package Awing3510最长公共子序列等价优化;

import java.util.Scanner;

/**
 * @see 动态规划 线性dp https://www.acwing.com/problem/content/3513/
 */
public class lcsOldClass {
    static int N = 10010;

    static int[][] dp = new int[N][N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
         int[] arr1 = new int[n+1];
        int[] arr2 = new int[n+1];
        for(int i = 1; i <=n; i++) {
          arr1[i] = sc.nextInt();

        }
        for(int i = 1; i <=n; i++) {
          arr2[i] = sc.nextInt();
        }

        for(int i = 1; i <=n; i++) {
            for(int j = 1; j <=n; j++) {
                if (arr1[i] == arr2[j]){
                    dp[i][j] = dp[i-1][j-1] +1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[n][n]);
//        int res = 0;
//        for(int i = 1; i <=n; i++) {
//          res = Math.max(res,dp[n][i]);
//        }
//        System.out.println(res);
    }



}
