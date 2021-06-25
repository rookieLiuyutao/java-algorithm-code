package leetcode4寻找两个正序数组的中位数;

import java.util.ArrayList;
import java.util.Collections;


/**
 * @see https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 */
public class FindMedianSortedArraysClass {
    /**
     * 暴力解法
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i : nums1) {
            list.add(i);
        }
        for (int i : nums2) {
            list.add(i);
        }
        Collections.sort(list);
        int n = list.size();
        double res = 0;
        if (n % 2 == 0) {
            res = list.get(n / 2) + list.get(n / 2 - 1);
            res /= 2;
        } else {
            res = list.get(n / 2);
        }
        return res;
    }

    /**
     * 递归 num1和num2 都是有序的
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if (total % 2 == 0) {
            int left = find(nums1, 0, nums2, 0, total / 2);
            int right = find(nums1, 0, nums2, 0, total / 2 + 1);
            return (double) (left + right) / 2;
        } else {
            return (double) find(nums1, 0, nums2, 0, total / 2 + 1);
        }

    }

    /**
     * @param nums1
     * @param i     从num1的第i位作为开始的起点
     * @param nums2
     * @param j     从num2的第j位作为开始的起点
     * @param k     要搜的中位数的下标是k
     * @return
     */
    int find(int[] nums1, int i, int[] nums2, int j, int k) {
        int n = nums1.length;
        int m = nums2.length;
        if (n - i > m - j) {
            return find(nums2, j, nums1, i, k);
        }
        if (k == 1) {//k=1即为搜到了最后
            if (nums1.length == i) {//较短的数组为空
                return nums2[j];
            } else {
                return Math.min(nums1[i], nums2[j]);
            }
        }
        if (n == i) {
            return nums2[j + k - 1];
        }
        int si = Math.min(n, i + k / 2);//对于长度较小的数组，i+k/2可能会越界
        int sj = j + k - k / 2;
        if (nums1[si - 1] > nums2[sj - 1]) {
            return find(nums1, i, nums2, sj, k - (sj - j));
        } else {
            return find(nums1, si, nums2, j, k - (si - i));
        }

    }

}
