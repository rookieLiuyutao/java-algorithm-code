package leetcode309最佳买卖股票时机含冷冻期;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int [][]dp = new int[n+1][3];
        //手中有货
        dp[0][0] = -0x3f3f3f;
        //手中无货1天
        dp[0][1] = -0x3f3f3f;
        //手中无货大于2天
        dp[0][2] = 0;
        for(int i = 1; i <=n; i++) {
          dp[i][0] = Math.max(dp[i-1][0],dp[i-1][2]-prices[i-1]);
          dp[i][1] = (dp[i-1][0]+prices[i-1]);
          dp[i][2] = Math.max(dp[i-1][1],dp[i-1][2]);
        }
        return Math.max(dp[n][1],dp[n][2]);
    }

}
