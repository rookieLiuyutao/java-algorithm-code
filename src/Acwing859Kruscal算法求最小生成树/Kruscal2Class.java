package Acwing859Kruscal算法求最小生成树;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Kruscal2Class {

    static class Edge {
        int a, b, w;

        public Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }
    }

    static final int N = 100010;
    static int n, m;
    static int[] p;
    static int[][] ad;
    static KruscalClass.Edge[] edges;

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

    /**
     * 并查集find模板
     * @param x 当前连通块的点
     * @return
     */
    static int find(int x) {
        if (p[x]!=x){
            p[x] = find(p[x]);
        }
        return p[x];
    }

    static int kruskal() {
        Arrays.sort(edges, Comparator.comparingInt(a -> a.w));
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }
        int res = 0, count = 0;
        for (int i = 0; i < m; i++) {
            int a = edges[i].a, b = edges[i].b, w = edges[i].w;
            a = find(a);
            b = find(b);
            w = find(w);
            if (a != b) {
                p[a] = b;
                res += w;
                count++;
            }
        }
        //判断是否连通
        return count < n - 1 ? -1 : res;

    }

    public static void main(String[] args) throws Exception {
        n = nextInt();
        m = nextInt();
        edges = new KruscalClass.Edge[m];
        p = new int[n + 1];
        ad = new int[n+1][n+1];
        for (int i = 0; i < m; i++) {
            int a = nextInt();
            int b = nextInt();
            int c = nextInt();
            edges[i] = new KruscalClass.Edge(a, b, c);
        }
        int ans = kruskal();
        if (ans==-1){
            System.out.println("impossible");
        }else {
            System.out.println(ans);
        }
    }


}
