package Acwing836合并集合;

import java.io.*;

/**
 * @see 并查集 https://www.acwing.com/problem/content/description/838/
 */
public class UnionFind {

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

    static int n, m;
    static int[] p;

    static int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];

    }

    public static void main(String[] args) throws Exception {
        n = nextInt();
        m = nextInt();
        p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }
        while (m-- > 0) {
            char c = next().charAt(0);
            int a = nextInt();
            int b = nextInt();

            //合并两个集合
            if (c == 'M') {
                p[find(a)] = find(b);
            } else {
                if (find(a) == find(b)) {
                    out.println("Yes");
                } else {
                    out.println("No");
                }
            }

        }
        out.flush();
        out.close();
    }

}
