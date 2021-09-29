package ccf201512_4送货;

import java.io.*;

/**
 * https://www.acwing.com/problem/content/3228/
 */
public class SendGooods {
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

    static final int N = 10010, M = 100010;
    static int[] h = new int[N], e = new int[N], ne = new int[2 * M], din = new int[N], dout = new int[N], p = new int[N];
    static boolean[] used = new boolean[M];
    static int n, m, idx;

    static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
        dout[a]++;
        din[b]++;
    }

    static int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    static int oula(int u) {
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];

        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        n = nextInt();
        m = nextInt();
        while (m-- > 0) {
            int a = nextInt(), b = nextInt();
            add(a, b);
            add(b, a);
        }
    }
}
