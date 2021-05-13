package leetcode1473粉刷房子3;

import java.util.Arrays;

public class minCost3Class {
    /**
     * 集合：定义 f[i][j][k]为考虑前i间房子，且以第i间房子形成的所有分区数量为j，其涂的颜色为k
     * 集合划分：以第i-1个房子是那种颜色作为划分 可以
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
        int[][][] dp = new int[m][target+1][n+1];
        //因为所求集合的属性是最小值，所以先把每个房子的每种颜色的花费初始化为inf
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= target; j++) {
                Arrays.fill(dp[i][j],inf);
            }
        }

        if (houses[0] != 0) {
            dp[0][1][houses[0]] =0;
        }else {
            for(int i = 1; i <=n; i++) {
              dp[0][1][i] = cost[0][i-1];
            }
        }

        for(int i = 1; i < m; i++) {
          for(int j = 1; j <=target; j++) {
            if (houses[i]!=0){
                int k = houses[i];
                for(int u = 1; u <=n; u++) {
                    if (u == k) {
                        dp[i][j][k] = Math.min(dp[i][j][k],dp[i-1][j][u]);
                    }else {
                        dp[i][j][k] = Math.min(dp[i][j][k],dp[i-1][j-1][u]);
                    }
                }
            }else {
                for(int k = 1; k <=n; k++) {
                    for(int u = 1; u <=n; u++) {
                        if (k == u) {
                            dp[i][j][k] = Math.min(dp[i][j][k],dp[i-1][j][u]+cost[i][k-1]);
                        }else {
                            dp[i][j][k] = Math.min(dp[i][j][k],dp[i-1][j-1][u]+cost[i][k-1]);
                        }
                    }
                }
            }
          }
        }
        for(int i = 1; i <=m; i++) {
            for(int j = 1; j <=target; j++) {
                for(int k = 1; k <=n; k++) {
                    System.out.print(dp[i][j][k]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }

        int res = inf;
        for(int i = 1; i <=n; i++) {
            res = Math.min(res,dp[m-1][target][i]);
        }
        return res == inf ? -1 : res;
    }
}
