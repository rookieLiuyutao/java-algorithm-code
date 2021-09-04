package Acwing1057股票买卖IV;

import java.io.*;
import java.util.Arrays;

/**
 * https://www.acwing.com/problem/content/1059/
 */
public class StockTradingIV {

    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static int nextInt() throws Exception {
        in.nextToken();
        return (int) in.nval;
    }

    static String next() throws Exception {
        in.nextToken();
        return in.sval;
    }

    public static void main(String[] args) throws Exception {
        int n = nextInt();
        int k = nextInt();
        int[][][] dp = new int[n + 1][k + 1][2];

        for(int i = 0; i <=n; i++) {
          for(int j = 0; j <=k; j++) {
              Arrays.fill(dp[i][j],-0x3f3f);
          }
        }

        for (int i = 0; i <= n; i++) {
            dp[i][0][0] = 0;//手中无股票
        }
        for (int i = 1; i <= n; i++) {
            int x = nextInt();
            for (int j = 1; j <= k; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + x);//有股票后卖出x，赚x
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - x);
            }
        }
        int res = 0;
        for(int i = 0; i <=n; i++) {
          res = Math.max(res,dp[i][k][0]);
        }
        System.out.println(res);
    }

}
