package leetcode5832构造元素不等于两相邻元素平均值的数组;

import java.util.Arrays;

public class RearrangeArray {

    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        if (n == 3) {
            int t = nums[1];
            nums[1] = nums[2];
            nums[2] = t;
        }
        for(int i = 1; i <n-2; i++) {
          if (2*nums[i]-nums[i-1]!=nums[i+1]){
              continue;
          }
          int t = nums[i+2];
          nums[i+2] = nums[i+1];
          nums[i+1] = t;
        }
        if (2*nums[n-2]-nums[n-3]==nums[n-1]){
            int t = nums[n-1];
            nums[n-1] = nums[n-3];
            nums[n-3] = t;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[]a = {0,4,1,5,3};
        System.out.println(Arrays.toString(new RearrangeArray().rearrangeArray(a)));
    }

}
