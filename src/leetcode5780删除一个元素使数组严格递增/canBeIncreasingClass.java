package leetcode5780删除一个元素使数组严格递增;

/**
 * @see
 */
public class canBeIncreasingClass {


    public boolean canBeIncreasing(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int i = 1; i < n && count <= 1; i++) {
            if (nums[i] > nums[i - 1]) {
                continue;
            }
            count++;
            if (i - 1 > 0 && nums[i] <= nums[i - 2]) {
                nums[i] = nums[i - 1];
            }
        }

        return count <= 1;

    }

    public static void main(String[] args) {
        int[] arr = {105, 924, 32, 968};
        System.out.println(new canBeIncreasingClass().canBeIncreasing(arr));
    }
}
