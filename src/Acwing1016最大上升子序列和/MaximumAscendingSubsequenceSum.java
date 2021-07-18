package Acwing1016最大上升子序列和;

import java.util.Scanner;

/**
 * 线性dp
 * http://ybt.ssoier.cn:8088/problem_show.php?pid=1285
 */
public class MaximumAscendingSubsequenceSum {
    static Scanner sc = new Scanner(System.in);
    static int []a ,dp;
    public static void main(String[] args) {
        int n = sc.nextInt();
        a = new int[n+1];
        dp = new int[n+1];

        for(int i = 1; i <=n; i++) {
          a[i] = sc.nextInt();
        }
        for(int i = 1; i <=n; i++) {
          for(int j = 1; j <i; j++) {
            if (a[i]>a[j]){
                dp[i] = Math.max(dp[i],dp[j]+a[i] );
            }
          }
        }
        int res = 0;
        for(int i = 1; i <=n; i++) {
          res = Math.max(res,dp[i]);
        }
        System.out.println(res);
    }

}
