package leetcode879盈利计划;

public class profitableSchemesClass2 {

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int len = group.length;
        int MOD = (int) 1e9 + 7;
        int [][][]dp = new int[len+1][n+1][minProfit+1];
        dp[0][0][0]= 1;

        for(int i = 1; i <=len; i++) {
            int x= group[i-1],y = profit[i-1];
            for(int j = 1; j <=n; j++) {
                for(int k = 1; k <=minProfit; k++) {
                    if (x > j) {
                        dp[i][j][k] = dp[i-1][j][k];
                    }else {
                        dp[i][j][k]  = (dp[i-1][j][k]+dp[i-1][j-x][Math.max(0,k-y)])%MOD;
                    }
                }
            }
        }
        int res = 0;
        for(int i = 0; i <=n; i++) {
            res = (res+dp[len][i][minProfit])%MOD;
        }
        return res;
    }

}
