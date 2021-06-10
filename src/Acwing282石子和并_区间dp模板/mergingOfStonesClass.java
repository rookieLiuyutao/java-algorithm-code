package Acwing282石子和并_区间dp模板;

import java.io.*;

/**
 * @see 动态规划 区间dp https://www.acwing.com/problem/content/284/
 */
public class mergingOfStonesClass {
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

    static final int N = 310;
    static int n ;
    static int [] sum;
    static int [][]dp;

    public static void main(String[] args)throws Exception {
        n = nextInt();

        sum = new int[n+1];
        dp = new int[n+1][n+1];
        //求前缀和数组的原地方式
        for(int i = 1; i <=n; i++) {
          sum[i] = nextInt();
            sum[i]+=sum[i-1];
        }


        for(int len = 2; len <=n; len++) {
          for(int l = 1; l +len-1<=n; l++) {
            int r = l+len-1;
                dp[l][r] = Integer.MAX_VALUE/2;
            for(int k = l; k <r; k++) {
                dp[l][r] = Math.min(dp[l][r],dp[l][k]+dp[k+1][r]+sum[r]-sum[l-1]);
            }
          }
        }
        out.println(dp[1][n]);
        out.flush();
        out.close();

    }

}
