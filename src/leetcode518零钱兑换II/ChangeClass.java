package leetcode518零钱兑换II;

/**
 * @see 动态规划 https://leetcode-cn.com/problems/coin-change-2/
 */
public class ChangeClass {

    public int change(int amount, int[] coins) {

        int n = coins.length;

        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {

            for (int j = coins[i - 1]; j <= amount; j++) {

                dp[j] = dp[j - coins[i - 1]] + 1;

            }
        }
        return dp[amount];
    }

}
