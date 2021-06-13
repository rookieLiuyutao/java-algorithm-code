package Acwing3662最大上升子序列和;

import java.io.*;
import java.util.Arrays;

/**
 * @see https://www.acwing.com/problem/content/description/3665/
 */
public class maximumIncreasingSubsequenceSumClass {
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
    static int[]arr,sum,dp;

    public static void main(String[] args) throws Exception {
        n = nextInt();
        arr = new int[n+1];
        sum = new int[n+1];
        dp = new int[n+1];
        for(int i = 1; i <=n; i++) {
            arr[i] = nextInt();
            sum[i] = sum[i-1]+arr[i];
        }

        int res = 1;
        for(int i = 1; i <=n; i++) {

            for(int j = 0; j <i; j++) {
                if (sum[i]>sum[j]&&arr[i]>arr[j]){
                    dp[i] = Math.max(dp[i],dp[j]+arr[i] );
                }
            }
            res = Math.max(res,dp[i]);
        }
        //         out.println(Arrays.toString(sum));
        // out.println(Arrays.toString(dp));

        out.println(res);

        out.flush();
    }


}
