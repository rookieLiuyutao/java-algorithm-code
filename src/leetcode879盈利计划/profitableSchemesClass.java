package leetcode879盈利计划;

import java.util.Arrays;

/**
 * @see 动态规划  https://leetcode-cn.com/problems/profitable-schemes/
 */
public class profitableSchemesClass {

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int m = group.length;
        int MOD = (int)1e9+7;
        int [][]dp  = new int[n+1][minProfit+1];
        for(int i = 0; i <=n; i++) {
            dp[i][0] = 1;
        }
        for(int i = 1; i <=m; i++) {
            int x= group[i-1],get = profit[i-1];
            for(int j = n; j >=x; j--) {
                for(int k = minProfit; k>=0; k--) {
                    dp[j][k] = (dp[j][k]+dp[j-x][Math.max(0,k-get)])%MOD;
                }
            }
        }
        for (int []a:dp){
            System.out.println(Arrays.toString(a));
        }
        return dp[n][minProfit];
    }

    public static void main(String[] args) {
        System.out.println(new profitableSchemesClass().profitableSchemes(10,5,new int[]{2,3,5},new int[]{6,7,8}));
    }

}
