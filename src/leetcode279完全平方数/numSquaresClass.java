package leetcode279完全平方数;

import java.util.Arrays;

/**
 * @see 动态规划 https://leetcode-cn.com/problems/perfect-squares/
 */
public class numSquaresClass {

    public int numSquares(int n) {
        int [] dp =  new int[n+1];
        //初始化时的要求：
        //因为求的是min，都必须初始化为极大数
        //dp[1]为最初状态，其含义为：n=1时的最小方法数，应该为1；
        //而dp[1]是由dp[0]转移而来，所以有dp[0]=0;
        Arrays.fill(dp,Integer.MAX_VALUE/2);
        dp[1] = 1;
        for (int num = 1; num <= Math.sqrt(n); num++){
            for (int i = 0; i <= n; i++)
            {
                if (i >= num * num) {
                    dp[i] = Math.min(dp[i], dp[i - num * num] + 1);
                }
            }
        }
        // System.out.println(Arrays.toString(dp));

        return dp[n];
    }


    public int numSquares3(int n) {
        int m = (int) (Math.sqrt(n) + 1);
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int min = Integer.MIN_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] += 1;
        }
        return dp[n];
    }

    public int numSquares2(int n) {
        int m = (int) (Math.sqrt(n) + 1);
        int[][] dp = new int[m+1][n + 1];
        for(int i = 0; i <=m; i++) {
            for(int j = 0; j <=n; j++) {
                if (i == 0) {
                    dp[i][j] = 1;
                }else {
                    dp[i][j] = Integer.MAX_VALUE/2;
                }
            }
        }
        dp[0][0] = 1;
        //用i*i为最大数的方案凑出了j
        for(int i = 1; i <=m; i++) {
            int p = i*i;
            for(int j = 1;j <=n; j++) {
                if (j>=p){
                    dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-p]+1);
                }
            }
        }
        int res = Integer.MAX_VALUE/2;
        for(int i = 1; i <=m; i++) {
          res = Math.min(res,dp[i][n]);
        }
        for (int[]x:dp){
            System.out.println(Arrays.toString(x));
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new numSquaresClass().numSquares2(12));
    }
}
