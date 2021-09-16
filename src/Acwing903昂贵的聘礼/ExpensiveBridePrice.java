package Acwing903昂贵的聘礼;

import java.io.*;
import java.util.Arrays;

/**
 * https://www.acwing.com/problem/content/905/
 */
public class ExpensiveBridePrice {
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

    static final int N = 105, INF = 0x3f3f3f3f;
    static int[][] g = new int[N][N];
    static int[] dis = new int[N], level = new int[N];
    static boolean[] st = new boolean[N];
    static int n;

    static int djs(int low, int high) {
        Arrays.fill(dis, INF);
        Arrays.fill(st, false);
        dis[0] = 0;
        for (int i = 1; i <= n; i++) {
            int t = -1;
            for (int j = 0; j <= n; j++) {
                if (!st[j] && (t == -1 || dis[j] < dis[t])) {
                    t = j;
                }
            }
            if (t == n) {
                break;
            }
            st[t] = true;
            for (int j = 0; j <= n; j++) {
                if (level[j] <= high && level[j] >= low) {
                    dis[j] = Math.min(dis[j], dis[t] + g[t][j]);
                }
            }
        }
        return dis[1];
    }

    public static void main(String[] args) throws Exception {
        int limit = nextInt();
        n = nextInt();
        for (int []x:g){
            Arrays.fill(x,INF);
        }
        for(int i = 0; i <=n; i++) {
          g[i][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            int price = nextInt();
            level[i] = nextInt();
            int cnt = nextInt();
            g[0][i] = Math.min(price,g[0][i]);
            for (int j = 1; j <= cnt; j++) {
                int b = nextInt(), c = nextInt();
                g[b][i] = Math.min(g[b][i], c);
            }
        }
        int res = INF;
        for(int i = level[1]-limit; i <=level[1]; i++) {
            res = Math.max(res,djs(i,i+limit));
        }
        System.out.println(res);
        System.out.println(Arrays.toString(dis));
        for(int i = 0; i <=n; i++) {
            for(int j = 0; j <=n; j++) {
                System.out.print(g[i][j]+' ');
            }
            System.out.println();
        }
    }
}
