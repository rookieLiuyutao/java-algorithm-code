package leetcode300最长递增子序列;

/**
 * @see 动态规划模板 https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */
public class lengthOfLISClass {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int res = 1;

        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {6};
        System.out.println(lengthOfLIS(arr));
    }


}
