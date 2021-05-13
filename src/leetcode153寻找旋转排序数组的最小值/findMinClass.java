package leetcode153寻找旋转排序数组的最小值;

public class findMinClass {
    public static int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + right + 1 >> 1;
            if (nums[mid] < nums[0]) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        //考虑right + 1 = nums.length的情况，发现此时右指针指向数组的末尾，
        // 说明这个数组整体升序排列 此时应该返回nums[0]
        return right + 1 < nums.length ? nums[right+1] : nums[0];
    }

    public static void main(String[] args) {
        int[] arr = {11, 13, 15, 17};
        System.out.println(findMin(arr));
    }
}
