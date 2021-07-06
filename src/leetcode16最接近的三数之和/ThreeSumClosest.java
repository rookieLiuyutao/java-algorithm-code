package leetcode16最接近的三数之和;

import java.util.Arrays;

/**
 * @see 双指针 https://leetcode-cn.com/problems/3sum-closest/
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE / 2;
        for (int i = 0; i < n; i++) {
            //排序后如果出现相同的数，之前一定是把这个数的所有情况都枚举过了，所以可以跳过
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1, k = n - 1; j < k; ) {
                int x = nums[i] + nums[j] + nums[k];
                if (Math.abs(x-target)<Math.abs(res-target)){
                    res = x;
                }
                if (x==target){
                    return res;
                } else if (x < target) {
                    j++;
                }else {
                    k--;
                }
            }
        }
        return res;
    }
}
