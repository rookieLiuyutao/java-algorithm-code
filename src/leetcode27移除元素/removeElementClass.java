package leetcode27移除元素;

/**
 * @see 双指针 https://leetcode-cn.com/problems/remove-element/
 */
public class removeElementClass {
    public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }

        }
        return j;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 3, 4, 5};
        int res = removeElement(arr, 3);
        for (int i = 0; i < res; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
