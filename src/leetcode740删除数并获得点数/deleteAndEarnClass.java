package leetcode740删除数并获得点数;

import java.util.Arrays;

/**
 * @see 线性dp https://leetcode-cn.com/problems/delete-and-earn/
 * 数据范围
 * 1 <= nums.length <= 20000
 * 1 <= nums[i] <= 10000
 */
public class deleteAndEarnClass {
    /**
     * 集合:删除的数是第i个数
     * 属性：获得点数的最大值
     * 集合划分：是否删除第i个数
     * 要想实现以上状态转移，先要给数组去重，并统计每个数出现的次数
     * @param nums
     * @return
     */
    public static int deleteAndEarn(int[] nums) {
        //枚举数据范围内的所有数
        int[] dp = new int[10010];
        int[] count = new int[10010];
        for (int num : nums) {
            count[num]++;
        }
        //dp[0] 表示删除0，在本题中无意义
        dp[1] = count[1];
        for(int i = 2; i <10001; i++) {
          dp[i] = Math.max(dp[i-1],dp[i-2]+i*count[i]);
        }
        return dp[10000];
    }

    public static void main(String[] args) {
        int[]arr = {2,2,3,4};
        System.out.println(deleteAndEarn(arr));
    }
}
