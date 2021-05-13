package leetcode1011在D天内送达包裹的能力;
/**
 * @see 1011在D天内送达包裹的能力 https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/
 */

import java.util.Arrays;

public class ShipWithinDaysClass2 {
    /**
     *
     * @param weights
     * @param cargoCapacity
     * @param day
     * @return
     */
    static boolean check(int[] weights, int cargoCapacity, int day) {
        //need表示当前sum下需要的天数
        //sum表示前i个物品的重量和
        int need = 1, sum = 0;
        for (int weight : weights) {
            //如果当前物品重量和大于运载能力，就需要多运一天
            if (sum + weight > cargoCapacity) {
                ++need;
                sum = 0;
            }
            sum += weight;
        }
        return need <= day;
    }

    /**
     *二分的小边界应该是数组里最重的物品，最大边界应该是所有物品之和
     * @param weights
     * @param day
     * @return
     */
    public static int shipWithinDays2(int[] weights, int day) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();
        while (left < right) {
            int mid = left + right >> 1;
            if (check(weights,mid,day)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        int[]arr = {3,2,2,4,1,4};
        System.out.println(shipWithinDays2(arr,3));
    }
}
