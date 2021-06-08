package leetcode1049最后一块石头的重量II;

import java.util.Arrays;

/**
 * @see 动态规划 https://leetcode-cn.com/problems/last-stone-weight-ii/
 */
public class lastStoneWeightIIClass {

    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = Arrays.stream(stones).sum();
        int target = sum/2;
        int [][]dp  = new int[n+1][target+1];

        for(int i = 1; i <=n; i++) {
            int x = stones[i-1];
            for(int j = 1; j <=target; j++) {
                dp[i][j] = dp[i-1][j];
                if (j>=x){
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-x]+x);
                }
            }
        }
        return Math.abs(sum-dp[n][target]);
    }


}
