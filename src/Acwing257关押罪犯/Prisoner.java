package Acwing257关押罪犯;

import java.io.*;
import java.util.Arrays;

/**
 * https://www.acwing.com/problem/content/259/
 */
public class Prisoner {
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
    static int[] h = new int[N], e = new int[M], ne = new int[M], w = new int[M], color = new int[N];
    static int n, m, idx;

    static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    static boolean dfs(int u, int c, int mid) {
        color[u] = c;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (w[i] <= mid) {
                continue;
            }
            if (color[j] != 0) {
                if (color[j] == color[u]) {
                    return false;
                }
            } else if (!dfs(j, 3 - c, mid)) {
                return false;
            }
        }
        return true;
    }

    static boolean check(int mid) {
        Arrays.fill(color, 0);
        for (int i = 1; i <= n; i++) {
            if (color[i] == 0) {
                if (!dfs(i, 1, mid)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        n = nextInt();
        m = nextInt();
        Arrays.fill(h, -1);
        while (m-- > 0) {
            int a = nextInt(), b = nextInt(), c = nextInt();
            add(a, b, c);
            add(b, a, c);
        }
        int l = 0, r = (int) 10e9;
        while (l < r) {
            int mid = l + r >> 1;
            if (check(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(r);
    }

}
