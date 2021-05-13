package leetcode1269停在原定的方案数;



/**
 * @see 路径dp https://leetcode-cn.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/
 */
public class numWaysClass {
    public int numWays(int steps, int arrLen) {
        int MOD = (int) (1e9 + 7);

        //arrLen-1的原因：
        int smaller = Math.min(steps, arrLen - 1);
        int[][] dp = new int[steps + 1][smaller + 1];

        dp[0][0] = 1;
        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j <= smaller; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - 1 >= 0) {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i][j]) % MOD;
                }
                if (j + 1 <= smaller) {
                    dp[i][j] = (dp[i][j] + dp[i-1][j + 1]) % MOD;
                }
            }
        }
        return dp[steps][0];
    }

    public static void main(String[] args) {
        System.out.println(new numWaysClass().numWays(3, 2));


    }
}
