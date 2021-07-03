package leetcode15三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @see 双指针 https://leetcode-cn.com/problems/3sum/
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0,j = n-1; i <n&&i<j; i++) {
          int x = nums[i]+nums[j];
          set.add(x);



        }
        return res;
    }

}
