package leetcode42接雨水;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 思路：用两个数组保存从左右两边遍历出的最大高度
 */
public class trapClass {
    public static int trap(int[] height) {
        int n = height.length;
        if (n==0) {
            return 0;
        }

        int left[] = new int[n];

        int right[]= new int[n];
        left[0] =height[0];
        right[n-1]  =height[n-1];
        for (int i = 1; i < n; i++) {
            left[i]=Math.max(left[i-1],height[i]);

        }
        for (int i = n-2; i >=0; i--) {
            right[i] = Math.max(right[i+1],height[i]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res+=Math.min(left[i],right[i])-height[i];
        }
        return res;

    }

    public static void main(String[] args) {
        int[] arr= new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(arr));
    }

}
