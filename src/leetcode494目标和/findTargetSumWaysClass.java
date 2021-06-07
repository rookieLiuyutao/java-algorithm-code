package leetcode494目标和;

import java.util.Arrays;

/**
 * @see 动态规划 线性dp https://leetcode-cn.com/problems/target-sum/
 */
public class findTargetSumWaysClass {

    public int findTargetSumWays(int[] nums, int target) {
        int n= nums.length;
        int sum = Arrays.stream(nums).sum();
        int diff = sum-target;
        int neg = diff/2;
//-----------------------------------
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
//-------------------------------------------
        int[][]dp = new int[n+1][neg+1];

        dp[0][0] = 1;
        for(int i = 1; i <=n; i++) {
          int m = nums[i-1];
          for(int j = 0; j <=neg; j++) {
              dp[i][j]   = dp[i-1][j];
            if (j>=m){
                dp[i][j]+=dp[i-1][j-m];
            }
          }
        }
    return dp[n][neg];
    }

}
