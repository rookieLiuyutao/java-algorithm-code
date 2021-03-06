package Acwing1014登山;

import java.io.*;

/**
 * @see 线性dp 最长上升子序列模型 维护一个先上升后下降的子序列
 * http://ybt.ssoier.cn:8088/problem_show.php?pid=1283
 */
public class Mountaineer {
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

    static int[] h, dpl, dpr;
    static int n;

    public static void main(String[] args) throws Exception {
        n = nextInt();
        dpl = new int[n];
        dpr = new int[n];
        h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = nextInt();
        }

        for (int i = 0; i < n; i++) {
            dpl[i] = 1;
            for (int j = 0; j < i; j++) {
                if (h[i] > h[j]) {
                    dpl[i] = Math.max(dpl[i], dpl[j] + 1);
                }
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            dpr[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (h[i] > h[j]) {
                    dpr[i] = Math.max(dpr[i], dpr[j] + 1);

                }
            }
        }
        int res = 1;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dpr[i] + dpl[i] - 1);
        }
        out.println(res);
        out.flush();
    }


}
