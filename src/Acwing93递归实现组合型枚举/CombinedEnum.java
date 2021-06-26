package Acwing93递归实现组合型枚举;

import java.io.*;
/**
 * @see 递归 https://www.acwing.com/problem/content/description/95/
 */
public class CombinedEnum {

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

    static final int N = 30;
    static int n, m;
    static int[] ans = new int[N];

    static void dfs(int u, int start) {
        if (u > m) {
            for (int i = 1; i <= m; i++) {
                out.print(ans[i] + " ");
            }
            out.println();
        } else {
            for (int i = start; i <= n; i++) {

                ans[u] = i;
                dfs(u + 1, i + 1);
                ans[u] = 0;

            }
        }


    }

    public static void main(String[] args) throws Exception {
        n = nextInt();
        m = nextInt();
        dfs(1, 1);
        out.flush();

    }


}
