package Acwing340通信线路;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * https://www.acwing.com/problem/content/342/
 */
public class CollectedRoad {

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

    static int N = 1010, M = 10010, INF = 0x3f3f3f3f;
    static int[] h = new int[N], ne = new int[M], e = new int[M], dis = new int[N], w = new int[N];
    static boolean[] st = new boolean[N];
    static int n, m, k, idx;

    static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    static boolean djs(int x) {
        Arrays.fill(dis, INF);
        Arrays.fill(st,false);
        ArrayDeque<Integer> q = new ArrayDeque<>();
        dis[1] = 0;
        q.add(1);
        while (!q.isEmpty()) {
            int t = q.poll();
            if (st[t]){
                continue;
            }
            for(int i = h[t]; i !=-1; i = ne[i]) {
                int j = e[i];
                int cost = w[i]>x?1:0;
                if (dis[j]>dis[t]+cost){
                    dis[j] = dis[t]+cost;
                    if (x==1){
                        q.addLast(j);
                    }else{
                        q.addFirst(j);
                    }
                }
            }
        }
        return dis[n]<=k;
    }

    public static void main(String[] args) throws Exception {
        n = nextInt();
        m = nextInt();
        k = nextInt();
        Arrays.fill(h, -1);
        while (m-- > 0) {
            int a = nextInt(), b = nextInt(), c = nextInt();
            add(a, b, c);
            add(b, a, c);
        }
        int l = 0, r = INF;
        while (l < r) {
            int mid = l + r >> 1;
            if (djs(mid)) {
                r = mid;
            } else {
                l = mid - 1;
            }
        }
        if (l >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(dis[n]);
        }
    }

}
