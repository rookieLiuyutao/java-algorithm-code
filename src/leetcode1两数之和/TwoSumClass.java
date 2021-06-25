package leetcode1两数之和;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @see 哈希表 https://leetcode-cn.com/problems/two-sum/
 */
public class TwoSumClass {
    static HashMap<Integer,Integer> map = new HashMap<>();

    public int[] twoSum(int[] nums, int target) {

        int n = nums.length;
        for(int i = 0; i <n; i++) {
          int x = target - nums[i];
          if (map.containsKey(nums[i])){
              return new int[] {map.get(nums[i]),i};
          }
            map.put(x,i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] arr = {3,3 };
        int target = 6;
        System.out.println(Arrays.toString(new TwoSumClass().twoSum(arr, target)));

    }
}
