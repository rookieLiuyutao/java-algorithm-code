package Acwing853有边数限制的最短路;

import java.io.*;
import java.util.Arrays;

/**
 * https://www.acwing.com/problem/content/855/
 */
public class ShortestPathWithLimitOnTheNumberOfSides {

    static class Edge {
        int a, b, c;

        public Edge(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

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

    static final int N = 510, M = 10010, INF = 0x3f3f3f;
    static int n, m, k;
    static int[] dis, backup;
    static Edge[] e;

    static void bellManFord() {
        Arrays.fill(dis, INF);
        dis[1] = 0;
        for (int i = 0; i < k; i++) {
            backup = Arrays.copyOf(dis, n + 1);
            for (int j = 0; j < m; j++) {
                int a = e[j].a, b = e[j].b, c = e[j].c;
                dis[b] = Math.min(dis[b], backup[a] + c);
            }
        }
        if (dis[n] > INF / 2) {
            System.out.println("impossible");
        } else {
            System.out.println(dis[n]);
        }
    }

    public static void main(String[] args) throws Exception {
        n = nextInt();
        m = nextInt();
        k = nextInt();
        e = new Edge[m + 1];
        dis = new int[n + 1];
        backup = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int a = nextInt(), b = nextInt(), c = nextInt();
            e[i] = new Edge(a, b, c);
        }
        bellManFord();


    }
}
