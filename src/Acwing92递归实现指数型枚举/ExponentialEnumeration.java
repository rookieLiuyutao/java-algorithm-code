package Acwing92递归实现指数型枚举;

import java.io.*;

/**
 * @see 递归 https://www.acwing.com/problem/content/94/
 */
public class ExponentialEnumeration {
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

    static final int N = 17;
    static int n;
    static boolean[] st = new boolean[N];

    static void dfs(int u) {
        if (u > n) {
            for (int i = 1; i <= n; i++) {
                if (st[i]) {
                    out.print(i + " ");
                }
            }
            out.println();
            return;
        }
        st[u] = true;
        dfs(u + 1);

        st[u] = false;
        dfs(u + 1);
    }

    public static void main(String[] args) throws Exception {
        n = nextInt();
        dfs(1);
        out.flush();
    }

}
