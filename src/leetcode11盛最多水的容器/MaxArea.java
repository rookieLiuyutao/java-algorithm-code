package leetcode11盛最多水的容器;

/**
 * @see 左右贪心 https://leetcode-cn.com/problems/container-with-most-water/submissions/
 */
public class MaxArea {

        public static int maxArea(int[] height) {
            int n = height.length;
            int left = 0;
            int right = n - 1;
            int res = 0;
            while (left < right) {
                int water = Math.min(height[left], height[right]) * (right - left);
                res = Math.max(res, water);
                if (height[left] < height[right]) {
                    left++;
                } else {
                    right--;
                }

            }
            return res;
        }

    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(arr));
    }



}
