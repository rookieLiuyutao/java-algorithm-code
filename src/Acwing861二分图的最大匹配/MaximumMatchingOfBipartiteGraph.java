package Acwing861二分图的最大匹配;

import java.io.*;
import java.util.Arrays;

/**
 * https://www.acwing.com/problem/content/863/
 */
public class MaximumMatchingOfBipartiteGraph {

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

    static final int N = 20010, M = 200010;
    static int[] h = new int[N], e = new int[M], ne = new int[M], w = new int[N], match = new int[N];
    static boolean[] st = new boolean[N];
    static int n1, n2, m, idx;

    static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    static boolean find(int x) {
        for (int i = h[x]; i != -1; i = ne[i]) {
            int j = e[i];
            if (!st[j]) {
                st[j] = true;
                if (match[j] == 0 || find(match[j])) {
                    match[j] = x;
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        n1 = nextInt();
        n2 = nextInt();
        m = nextInt();
        Arrays.fill(h, -1);
        while (m-- > 0) {
            int a = nextInt(), b = nextInt();
            add(a, b);
        }
        int res = 0;
        for (int i = 1; i <= n1; i++) {
            Arrays.fill(st, false);
            if (find(i)) {
                res++;
            }
        }
        System.out.println(res);
    }
}
