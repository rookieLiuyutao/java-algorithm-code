package Acwing482合唱队形;

import java.io.*;

/**
 * @see 线性dp 最长上升子序列
 * https://www.acwing.com/problem/content/description/484/
 */

public class ChorusFormation {
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
        int res = 1;
        for (int i = 0; i < n; i++) {
            h[i] = nextInt();
            dpl[i] = 1;
            dpr[i] = 1;
            for (int j = 0; j < i; j++) {
                if (h[i] > h[j]) {
                    dpl[i] = Math.max(dpl[i], dpl[j] + 1);
                }
                //如果max取了dpl[j] + 1，说明往上走的序列更长，队伍还在往上走；
                //如果max取了dpr[j] + 1，说明往下走的序列更长，队伍还在往下走；
                //同时扩展时，结果较大的一个就是最终结果
                if (h[i] < h[j]) {
                    dpr[i] = Math.max(dpr[i], Math.max(dpr[j] + 1, dpl[j] + 1));
                }
            }
            res = Math.max(res, Math.max(dpr[i], dpl[i]));
        }


        out.println(n-res);
        out.flush();
    }
}
