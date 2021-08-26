package leetcode31下一个排列;

import java.util.Collections;

/**
 * https://leetcode-cn.com/problems/next-permutation/
 */
public class NextPermutation {

    public  void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

    public void reserve(int []a,int l,int r){
        while (l < r) {
            swap(a, l++, r--);
        }
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int k = n-1;
        while (k>0&&nums[k-1]>=nums[k]){
            k--;
        }
        if (k <= 0) {
            reserve(nums,0,n-1);
        }else {
            int t = k;
            while (t<nums.length &&nums[t]>nums[k-1]){
                t++;
            }
            swap(nums,t-1,k-1);
            reserve(nums,k,nums.length-1);
        }
    }

}
