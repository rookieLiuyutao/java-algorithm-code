package leetcode1482制作m束花的最小天数;

import java.util.Arrays;

/**
 * @see 二分 https://leetcode-cn.com/problems/minimum-number-of-days-to-make-m-bouquets/
 */
public class minDaysClass {
    static boolean check(int m, int k, int[] bloomDay, int mid, int n) {
        int flowers = 0;
        for (int i = 0; i < n && m>0; i++) {
            if (bloomDay[i] <= mid) {
                flowers++;
                if (flowers == k) {
                    m--;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }
        return m<=0;
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (n < m * k) {
            return -1;
        }
        int left = 1, right = Arrays.stream(bloomDay).max().getAsInt();

        while (left < right) {
            int mid = left + right >> 1;
            if (check(m, k, bloomDay, mid, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[]arr = {1,10,2,9,3,8,4,7,5,6};
        System.out.println(minDays(arr,4,2));
    }

}
