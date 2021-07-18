package leetcode983最低票价;

/**
 * https://leetcode-cn.com/problems/minimum-cost-for-tickets/
 */
public class MincostTickets {

    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int maxDay = days[n - 1], minDay = days[0];
        int[] dp = new int[maxDay + 31];

        for (int i = maxDay, j = n - 1; i >= minDay; i++) {
            if (i == days[j]) {
                dp[i] = Math.min(Math.min(dp[i + 1]+costs[0], dp[i + 7]+costs[1]), dp[i + 30]+costs[2]);
                j--;
            }else {
                dp[i] = dp[i+1];
            }
        }
        return dp[minDay];
    }

}
