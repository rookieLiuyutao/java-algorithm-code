package dp记忆化搜索_跳台阶;
/**
 * @see 821. 动态规划 https://www.acwing.com/problem/content/823/
 */

import java.util.Scanner;

public class jumpClass {
    static int n;
    static int[] dp = new int[20];

//    public static int dfs(int n) {
//        if (n == 0 || n == 1) {
//           if (dp[n]==0){
//               return dp[n];
//
//           }else {
//               dp[n] = 1;
//               return dp[n];
//
//           }
//        } else {
//           if (dp[n]==0){
//               return dp[n];
//           }else {
//               dp[n] = dfs(n-1)+dfs(n-2);
//               return dp[n];
//           }
//        }
//    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
//        System.out.println(dfs(n));
        dp[0] = 1;dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[n]);
    }

}

