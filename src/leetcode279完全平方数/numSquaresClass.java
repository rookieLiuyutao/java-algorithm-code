package leetcode279完全平方数;

import java.util.Arrays;

/**
 * @see 动态规划 https://leetcode-cn.com/problems/perfect-squares/
 */
public class numSquaresClass {

    public int numSquares(int n) {
        int [] dp =  new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE/2);
        dp[0] = 0;
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


    public int numSquares2(int n) {
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



    public static void main(String[] args) {
        System.out.println(new numSquaresClass().numSquares(12));
    }
}
