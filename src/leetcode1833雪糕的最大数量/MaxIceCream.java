package leetcode1833雪糕的最大数量;

import java.util.Arrays;

/**
 * @see 贪心 https://leetcode-cn.com/problems/maximum-ice-cream-bars/
 */
public class MaxIceCream {

    public int maxIceCream(int[] costs, int coins) {
        int n = costs.length;
        Arrays.sort(costs);
        int count = 0;
        for (int cost : costs) {
            if (coins > 0&&coins>=cost) {
                coins -= cost;
                count++;
            }
        }
        return count;

    }

    public static void main(String[] args) {

        int []arr = {1,3,2,4,1};
        System.out.println(new MaxIceCream().maxIceCream(arr,7));
    }

}
