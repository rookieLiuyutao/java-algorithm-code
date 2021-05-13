package leetcode363矩形区域不超过K的最大数值和;

import java.util.TreeSet;

/**
 * @see https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/
 * @see 三叶的题解 https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/solution/gong-shui-san-xie-you-hua-mei-ju-de-ji-b-dh8s/
 * 数据范围
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -100 <= matrix[i][j] <= 100
 * -105 <= k <= 105
 */
public class maxSumSubmatrixClass {
    /**
     * 暴力解法
     *
     * @param matrix 正方形矩阵
     * @param k
     * @return
     */
    public static int maxSumSubmatrix(int[][] matrix, int k) {
        int n = matrix.length, m = matrix[0].length;
        int[][] s = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        int res = Integer.MIN_VALUE;
        //枚举每个左上角和右下角的点，算每一个子矩阵的和，取出满足条件最大的那一个
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int a = i; a <= n; a++) {
                    for (int b = j; b <= m; b++) {
                        int sum = s[a][b] - s[i - 1][b] - s[a][j - 1] + s[i - 1][j - 1];
                        if (sum <= k) res = Math.max(res, sum);
                    }
                }
            }
        }
        return res;
    }

    /**
     * 优化后的解法
     *
     * @param matrix
     * @param k
     * @return
     */
    public static int maxSumSubmatrix2(int[][] matrix, int k) {
        int n = matrix.length, m = matrix[0].length;
        int[][] s = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        /**
         *搜索所有子矩阵需要枚举「矩形左上角」和「矩形右下角」，复杂度是 O(m^2 * n^2)O(m2∗n2)。
         * 因此，如果把本题当做二维前缀和模板题来做的话，整体复杂度是 O(m^2 * n^2)O(m2∗n2)。
         *观察数据范围矩阵的长度范围是100，n^4是10^8，n^3是10^6,思路是把其中一个n方优化成nlogn
         * 见到nlogn想到二分
         * 对应到本题，我们可以枚举其中三条边，然后使用数据结构来加速找第四条边。
         * 对于这个一维问题，我们可以先预处理出「前缀和」，然后枚举子数组的左端点，然后通过「二分」来求解其右端点的位置。
         */
        int res = Integer.MIN_VALUE;
        //
        for (int top = 1; top <= n; top++) {
            for (int below = top; below <= n; below++) {
                TreeSet<Integer> tree = new TreeSet<>();
                tree.add(0);
                for (int right = 1; right <= m; right++) {
                    //降维到一维前缀和
                    int rightIntervalSum = s[below][right] - s[top - 1][right];
                    //二分查找left
                    Integer left = tree.ceiling(rightIntervalSum - k);
                    if (left != null) {
                        res = Math.max(res, rightIntervalSum - left);
                    }
                    //将遍历过的right加入集合
                    tree.add(rightIntervalSum);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 1}, {0, -2, 3}};
        int k = 2;
        System.out.println(maxSumSubmatrix2(matrix, k));
    }
}
