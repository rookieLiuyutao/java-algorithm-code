package leetcode15三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see 双指针 https://leetcode-cn.com/problems/3sum/
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1, k = n - 1; j < k; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                while (j < k - 1 && nums[j] + nums[k-1] + nums[i] >= 0) {
                    k--;
                }
                if (nums[j] + nums[k] + nums[i] == 0) {
                    ArrayList<Integer> ans = new ArrayList<>();
                    ans.add(nums[i]);
                    ans.add(nums[j]);
                    ans.add(nums[k]);
                    res.add(ans);
                }
            }

        }


        return res;
    }

}
