package leetcode18四数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see 字符串 双指针 https://leetcode-cn.com/problems/4sum/
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int k = j + 1, l = n - 1;
                while (k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                    } else if (sum < target) {
                        k++;
                        continue;
                    } else {
                        l--;
                        continue;
                    }
                    do {
                        k++;
                    } while (k < l && nums[k] == nums[k - 1]);
                    do {
                        l--;
                    } while (k < l && nums[l] == nums[l + 1]);
                }
            }

        }
        return res;
    }


}
