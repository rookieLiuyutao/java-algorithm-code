package leetcode1011在D天内送达包裹的能力;

/**
 * @see 1011在D天内送达包裹的能力 https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/
 */
public class shipWithinDaysClass {
    /**
     *
     * @param weight
     * @param transportCapacity 当前枚举的运载能力
     * @param day 规定天数
     * @return
     */
    static boolean check(int[] weight, int transportCapacity, int day) {
        if (weight[0] > transportCapacity) {
            return false;
        }
        int n = weight.length;
        int count = 0;
        for (int i = 0; i < n;  count++) {
            int sum = 0;
            if (weight[i] > transportCapacity) {
                return false;
            }
            while (i < n && sum + weight[i] <= transportCapacity) {
                sum += weight[i];
                i++;
            }
        }
        return count  <= day;
    }

    /**
     * 思路：运载能力的数据范围内，暴力查找出满足条件的最小的运载能力
     * @param weights
     * @param day
     * @return
     */
    public static int shipWithinDays(int[] weights, int day) {
        int left = 0, right = (int) 1e8;
        while (left < right) {
            int mid = left + right >> 1;
            if (check(weights, mid, day)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }

    public static void main(String[] args) {
        int[]arr = {3,2,2,4,1,4};
        System.out.println(shipWithinDays(arr,3));
    }
}
