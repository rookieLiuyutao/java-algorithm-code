package Acwing3662最大上升子序列和;

import java.io.*;

/**
 * @see 动态规划 https://www.acwing.com/solution/content/8699/
 */
public class maximumIncreasingSubsequenceSumClass2 {

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
    static int n;
    static int[]arr,dp;
    public static void main(String[] args) throws Exception {
        n = nextInt();
        arr = new int[n+1];
        dp = new int[n+1];
        for(int i = 1; i <= n; i ++) {
            arr[i] = nextInt();
            dp[i] = arr[i];
        }
        for(int i = 2; i <= n; i ++) {
            for(int j = 1; j < i; j ++) {
                if(arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
        }

        int res = -1;
        for(int i = 1; i <= n; i ++) {
            res = Math.max(res, dp[i]);
        }
        out.println(res);
        out.flush();

    }

}
