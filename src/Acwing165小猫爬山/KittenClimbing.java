package Acwing165小猫爬山;

import java.io.*;
import java.util.Arrays;

public class KittenClimbing {
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
    static final int N = 20;
    static int[] a = new int[N], sum = new int[N];
    static int n, res = 18, w;

    static void dfs(int u, int cnt) {
        if (cnt >= res) {
            return;
        }
        if (u >= n) {
            res = cnt;
            return;
        }
        for (int i = cnt - 1; i >= 0; i--) {
            if (sum[i] + a[u] <= w) {
                sum[i] += a[u];
                dfs(u + 1, cnt);
                sum[i] -= a[u];
            }
        }
        sum[cnt] = a[u];
        dfs(u + 1, cnt + 1);
        sum[cnt] = 0;
    }

    public static void main(String[] args)throws Exception {
        n = nextInt();
        w = nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }
        Arrays.sort(a, 0, n);
        dfs(0, 0);
        out.println(res);
        out.flush();
    }
}
