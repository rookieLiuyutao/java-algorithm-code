package Acwing1049大盗阿福;

import java.io.*;

/**
 * http://ybt.ssoier.cn:8088/problem_show.php?pid=1301
 */
public class RobberAfu {

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
        int t = nextInt();
        while (t-- > 0) {
            int n = nextInt();
            int[][] dp = new int[n+1][2];
            //dp[n+1][0]表示不选第i个店铺
            //dp[n+1][1]表示选第i个店铺
            dp[0][0] = 0;
            dp[0][1] = -0x3f3f3f3f;
            for (int i = 1; i <= n; i++) {
                int x = nextInt();
                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
                dp[i][1] = (dp[i-1][0]+x);
            }
            int res = Math.max(dp[n][0],dp[n][1]);
            out.println(res);
        }
        out.flush();
    }

}
