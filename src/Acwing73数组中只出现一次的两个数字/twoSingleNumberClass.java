package Acwing73数组中只出现一次的两个数字;

import java.util.Arrays;

/**
 * @see 位运算异或 https://www.acwing.com/problem/content/69/
 */
public class twoSingleNumberClass {
    public static int[] findNumsAppearOnce(int[] nums) {
        int res = 0;
        for (int i : nums) {
            res ^= i;
        }
        int k = 0;
        while ((res >> k & 1) == 0) {
            k++;
        }
        int t = 0;
        for (int i : nums) {
            if ((i >> k & 1) == 1) {
                t ^= i;
            }
        }
        return new int[]{t, res ^ t};
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2,1, 4, 5};
        System.out.println(Arrays.toString(findNumsAppearOnce(arr)));
    }
}
