package leetcode137只出现一次的数字;

/**
 * @see 双指针 https://leetcode-cn.com/problems/single-number-ii/submissions/
 */

import java.util.Arrays;
public class singleNumberClass {
    public static int singleNumber(int[] nums) {
        int res = 0;
        int n = nums.length;
        //特判，如果只有一个数
        if (n == 1) return nums[0];
        int j= 0;
        Arrays.sort(nums);
        for (int i = 1; i < n - 1; i++) {
            while (nums[i] == nums[j]) {
                j++;
            }
            //特判，如果所求数是最大的
            if (j == n - 1) return nums[n - 1];
            if ( nums[j] != nums[j + 1]) {
                res = nums[j];
                break;
            }
            i = j;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2,2,3,2};
        System.out.println(singleNumber(arr));
    }
}
