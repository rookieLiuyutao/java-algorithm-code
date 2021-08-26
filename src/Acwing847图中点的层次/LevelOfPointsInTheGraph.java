package Acwing847图中点的层次;

import java.io.*;
import java.util.Arrays;

/**
 * https://www.acwing.com/problem/content/849/
 */
public class LevelOfPointsInTheGraph {

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

    static final int N = 150010;
    static int[] e = new int[N], ne = new int[N], h = new int[N], dis = new int[N], q = new int[N];
    static int idx, n, m;

    static int bfs() {
        int hh = 0, tt = 0;
        q[0] = 1;
        Arrays.fill(dis, -1);
        dis[1] = 0;
        while (hh <= tt) {
            int t = q[hh++];
            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                if (dis[j] == -1) {
                    dis[j] = dis[t] + 1;
                    q[++tt] = j;
                }
            }
        }
        return dis[n];
    }

    static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public static void main(String[] args) throws Exception {
        n = nextInt();
        m = nextInt();
        Arrays.fill(h,-1);
        while (m-- > 0) {
            int a = nextInt();
            int b = nextInt();
            add(a, b);
        }
        System.out.println(bfs());
    }


}
