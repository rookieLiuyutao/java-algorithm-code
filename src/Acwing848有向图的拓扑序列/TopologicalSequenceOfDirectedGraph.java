package Acwing848有向图的拓扑序列;

import java.io.*;
import java.util.Arrays;

/**
 * https://www.acwing.com/problem/content/850/
 */
public class TopologicalSequenceOfDirectedGraph {

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

    static final int N = 100010;
    static int n, m, idx;
    static int[] e = new int[N], ne = new int[N], h = new int[N], q = new int[N], d = new int[N];//表示某点的入度

    static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    static boolean topSort() {
        int hh = 0, tt = -1;
        for (int i = 1; i <= n; i++) {
            if (d[i] == 0) {
                q[++tt] = i;
            }
        }
        while (hh <= tt) {
            int t = q[hh++];
            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                d[j]--;
                if (d[j] == 0) {
                    q[++tt] = j;
                }
            }
        }
        return tt == n - 1;
    }

    public static void main(String[] args) throws Exception {
        n = nextInt();
        m = nextInt();
        Arrays.fill(h, -1);
        while (m-- > 0) {
            int a = nextInt(), b = nextInt();
            add(a, b);
            d[b]++;
        }
        if (topSort()) {
            for (int i = 0; i < n; i++) {
                System.out.print(q[i]+" ");
            }
        } else {
            System.out.println(-1);
        }
    }

}
