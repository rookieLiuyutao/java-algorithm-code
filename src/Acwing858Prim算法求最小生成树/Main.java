package Acwing858Prim算法求最小生成树;

import java.io.*;
import java.util.Arrays;

/**
 * @see 图论 最小生成树 Prim https://www.acwing.com/solution/content/38312/ https://www.luogu.com.cn/problem/P3366
 */
public class Main {
    static final int N = 5010, INF = 9999;
    static int[][] ad;
    static int[] dist;
    static int n, m;
    static boolean[] st;

    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    static int nextInt() throws Exception {
        in.nextToken();
        return (int) in.nval;
    }

    static String next() throws Exception {
        in.nextToken();
        return in.sval;
    }

    static int prim() {
        Arrays.fill(dist, INF);
        int res = 0;
        for (int i = 0; i < n; i++) {
            int t = -1;
            for (int j = 1; j <= n; j++) {
                if (!st[j] && (t == -1 || dist[j] < dist[t])) {
                    t = j;
                }
            }
            if (i > 0 && dist[t] == INF) {
                return INF;
            }
            if (i > 0) {
                res += dist[t];
            }
            for (int j = 1; j <= n; j++) {
                dist[j] = Math.min(dist[j], ad[t][j]);
            }
            st[t] = true;

        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        n = nextInt();
        m = nextInt();
        dist = new int[n+1];
        ad = new int[n+1][n+1];
        st = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    ad[i][j] = 0;
                } else {
                    ad[i][j] = INF;
                }
            }
        }

        while (m-- > 0) {
            int a = nextInt();
            int b = nextInt();
            int c = nextInt();
            ad[a][b] = Math.min(ad[a][b], c);
//----------------有向图---------------
//            ad[b][a]= ad[a][b];
//-------------------------------------------------
        }
        int ans = prim();
        if (ans == INF) {
            //表示不可达
            System.out.println("orz");
        } else {
            System.out.println(ans);
        }


    }


}