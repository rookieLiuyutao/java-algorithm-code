package Acwing1017怪盗基德的滑翔翼;

import java.io.*;

/**
 * @see 线性dp 最长上升子序列变形 http://ybt.ssoier.cn:8088/problem_show.php?pid=1286
 */
public class KaitoKiddSHangGlider {
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

    static int[] dp, arr;
    static int n;

    public static void main(String[] args) throws Exception {
        int T = nextInt();
        while (T-- > 0) {
            n = nextInt();
            arr = new int[n];
            dp = new int[n];
            int res = 1;
            //正向求最长上升子序列
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (arr[i] > arr[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                res = Math.max(res, dp[i]);
            }

            //反向求最长上升子序列
            for (int i = n - 1; i >= 0; i--) {
                dp[i] = 1;
                for (int j = n - 1; j > i; j--) {
                    if (arr[i] > arr[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                res = Math.max(res, dp[i]);
            }
            out.println(res);
        }
        out.flush();
    }


}
