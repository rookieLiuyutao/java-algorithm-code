package Acwing1015摘花生;

import java.io.*;

/**
 * 线性dp 数字三角形模型
 * https://www.acwing.com/problem/content/1017/
 */
public class PickPeanuts {
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

    static int [][]dp,w;

    public static void main(String[] args)throws Exception {
        int t = nextInt();
        while (t-- > 0) {
            int n = nextInt();
            int m = nextInt();
            dp = new int[n+2][m+2];
            w = new int[n+2][m+2];
            for(int i = 1; i <=n; i++) {
                for(int j = 1; j <=m; j++) {
                    w[i][j] = nextInt();
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1])+w[i][j];
                }
            }
            out.println(dp[n][m]);
        }
        out.flush();
    }
}
