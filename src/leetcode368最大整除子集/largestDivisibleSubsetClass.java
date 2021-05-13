package leetcode368最大整除子集;
/**
 * @see 动态规划 背包变形 https://leetcode-cn.com/problems/largest-divisible-subset/
 */

import java.util.*;

public class largestDivisibleSubsetClass {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] save = new int[n];
        for (int i = 0; i < n; i++) {
            int len = 1, prev = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
//                    dp[i] = Math.max(dp[i],dp[j]+1);
                    //该如何保存这个过程中每一步的最优选择？
                    if (dp[j] + 1 > len) //如果选了当前这个数，就把这个数保存下来
                    {
                        len = dp[j] + 1;
                        prev = j;
                    }
                }
            }
            //dp[i] = Math.max(dp[i],dp[j]+1);
            dp[i] = len;
            save[i] = prev;
        }

        int maxLen = -1, index = -1;
        for (int i = 0; i < n; i++) {
            if (dp[i] > maxLen) {
                index = i;
                maxLen = dp[i];
            }
        }


        List<Integer> res = new ArrayList<>();
        while (res.size() != maxLen) {
            res.add(nums[index]);
            index = save[index];
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6, 8};
        System.out.println(largestDivisibleSubset(arr));
    }
}
