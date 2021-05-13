package leetcode1473粉刷房子3;

import java.util.Arrays;

/**
 * @see 线性dp https://leetcode-cn.com/problems/paint-house-iii/solution/fen-shua-fang-zi-iii-by-leetcode-solutio-powb/
 */
public class minCost2Class {
        // 极大值
        // 选择 Integer.MAX_VALUE / 2 的原因是防止整数相加溢出
        static final int INFTY = Integer.MAX_VALUE / 2;

    /**
     * 集合：定义 f[i][j][k]为考虑前i间房子，且第i间房子的颜色编号为j，前i间房子形成的分区数量为k的所有方案中的「最小上色成本」
     * @param houses 是第 i个房子的颜色，house[i]=0表示这个房子还没有被涂色。
     * @param cost 是将第 i 个房子涂成颜色 j+1 的花费
     * @param m 房子的数量
     * @param n 颜色的数量
     * @param target 目标街区的数量
     * @return
     */
        public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
            // 将颜色调整为从 0 开始编号，没有被涂色标记为 -1
            for (int i = 0; i < m; ++i) {
                --houses[i];
            }

            // dp 所有元素初始化为极大值
            int[][][] dp = new int[m][n][target];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    Arrays.fill(dp[i][j], INFTY);
                }
            }

            for (int i = 0; i < m; ++i) {//枚举第i个房子
                for (int j = 0; j < n; ++j) {//枚举当前房子可能刷的每一种颜色
                    if (houses[i] != -1 && houses[i] != j) {//当前房子有颜色或
                        continue;
                    }

                    for (int k = 0; k < target; ++k) {
                        for (int j0 = 0; j0 < n; ++j0) {
                            if (j == j0) {
                                if (i == 0) {
                                    if (k == 0) {
                                        dp[i][j][k] = 0;
                                    }
                                } else {
                                    dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j][k]);
                                }
                            } else if (i > 0 && k > 0) {
                                dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j0][k - 1]);
                            }
                        }

                        if (dp[i][j][k] != INFTY && houses[i] == -1) {
                            dp[i][j][k] += cost[i][j];
                        }
                    }
                }
            }

            int ans = INFTY;
            for (int j = 0; j < n; ++j) {
                ans = Math.min(ans, dp[m - 1][j][target - 1]);
            }
            return ans == INFTY ? -1 : ans;
        }




}
