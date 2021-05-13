package leetcode154寻找旋转排序数组中的最小值2;

public class findMin2 {
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right && nums[right] == nums[0]) {
            right--;
        }
        while (left < right) {


            int mid = left + right + 1 >> 1;
            if (nums[0] <= nums[mid]) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return right + 1 < nums.length ? nums[right + 1] : nums[0];
    }

    public static void main(String[] args) {
        int[] arr = {2,2,2,0,0,1};
        System.out.println(findMin(arr));
    }
}
