package leecode5767检查是否区域内所有整数都被覆盖;

/**
 * @see 不会枚举区间就枚举所有数 https://leetcode-cn.com/problems/check-if-all-the-integers-in-a-range-are-covered/
 */
public class isCoveredClass {
    /**
     * 枚举[left,right]的所有数，对于每个数枚举所有区间，如果都被区间包含，返回true
     *
     * @param ranges
     * @param left
     * @param right
     * @return
     */
    public boolean isCovered(int[][] ranges, int left, int right) {
        int n = ranges.length;
        for (int i = left; i <= right; i++) {
            boolean flag = false;
            for (int j = 0; j < n; j++) {
                if (i >= ranges[j][0] && i <= ranges[j][1]) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return false;
            }
        }
        return true;
    }

}
