package leetcode1473粉刷房子3;

/**
 * @see 线性dp https://leetcode-cn.com/problems/paint-house-iii/
 */
public class minCostClass {
    /**
     * 集合：定义 f[i][j][k]为考虑前i间房子，且第i间房子的颜色编号为j，前i间房子形成的分区数量为k的所有方案中的「最小上色成本」
     *
     * @param houses 是第 i个房子的颜色，house[i]=0表示这个房子还没有被涂色。
     * @param cost   是将第 i 个房子涂成颜色 j+1 的花费
     * @param m      房子的数量
     * @param n      颜色的数量
     * @param target 目标街区的数量
     * @return
     */
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int inf = Integer.MAX_VALUE / 2;
        int[][][] dp = new int[m + 1][n + 1][target + 1];

        //因为所求集合的属性是最小值，所以先把每个房子的每种颜色的花费初始化为inf
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j][0] = inf;
            }
        }

        for (int i = 1; i <= m; i++) {//枚举第i个房子
            int color = houses[i - 1];//因为i是从1开始的，要保证颜色与原数组对应
            for (int j = 1; j <= n; j++) {//枚举当前房子可能刷的每一种颜色
                for (int neighbor = 1; neighbor <= target; neighbor++) {//枚举该方案下可以形成的每一种分区的情况
                    if (neighbor > i) {//分区数量不可能大于房子的数量
                        dp[i][j][neighbor] = inf;
                        continue;
                    }
                    if (color != 0) {//当前房子本来有颜色
                        if (j == color) {//当前房子本来的颜色是颜色j
                            int temp = inf;
                            //
                            for (int previousColor = 1; previousColor <= n; previousColor++) {//枚举前一个房子的颜色
                                if (previousColor != j) {//当前房间的颜色不等于前一个房间的颜色
                                    //对于前一个房子的前一种颜色属于前前个街区，和当前房子当前颜色形成的新的街区 的两个选择中取花钱最小的其中一个
                                    temp = Math.min(temp, dp[i - 1][previousColor][neighbor - 1]);
                                }
                            }
                            //当前房间的颜色等于上一个房间的颜色
                            dp[i][j][neighbor] = Math.min(dp[i - 1][j][neighbor], temp);
                        } else {
                            dp[i][j][neighbor] = inf;
                        }
                    } else {
                        int u = cost[i - 1][j - 1];//匹配下标
                        int temp = inf;
                        for (int previousColor = 1; previousColor <= n; previousColor++) {
                            if (previousColor != j) {
                                temp = Math.min(temp, dp[i - 1][previousColor][neighbor - 1]);
                            }
                        }
                        dp[i][j][neighbor] = Math.min(dp[i - 1][j][neighbor], temp) + u;
                    }
                }
            }
        }
        int res = inf;
        for (int i = 1; i <= n; i++) {
            res = Math.min(res, dp[m][i][target]);
        }
        return res == inf ? -1 : res;
    }

}
