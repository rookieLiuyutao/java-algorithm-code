package AcWing1018最低通行费;

import java.io.*;

/**
 * 线性dp 数字三角形模型
 * http://ybt.ssoier.cn:8088/problem_show.php?pid=1287
 */
public class MinimumToll {
    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    static int nextInt() throws Exception{
        in.nextToken();
        return (int)in.nval;
    }
    static String next()throws Exception{
        in.nextToken();
        return in.sval;
    }
    static int [][]dp;

    public static void main(String[] args)throws Exception {
        int n = nextInt();
        dp = new int[n+2][n+2];
        for(int i = 1; i <=n; i++) {
            for(int j = 1; j <=n; j++) {
                int x = nextInt();
                int a = dp[i-1][j],b = dp[i][j-1];
                if (i == 1) {
                    dp[i][j] = b+x;
                } else if (j == 1) {
                    dp[i][j] = a+x;
                }else {
                    dp[i][j]  = Math.min(a,b)+x;
                }
            }
        }
        out.println(dp[n][n]);
        out.flush();
    }
}
