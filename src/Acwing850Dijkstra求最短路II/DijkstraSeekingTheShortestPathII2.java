package Acwing850Dijkstra求最短路II;

import java.io.*;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://www.acwing.com/problem/content/852/
 */
public class DijkstraSeekingTheShortestPathII2 {

    static class Point{
        int index,value;
        public Point(int index, int value) {
            this.index = index;
            this.value = value;
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

    static final int N = 150010, INF = Integer.MAX_VALUE;
    static int[] h = new int[N], e = new int[N], ne = new int[N], dis = new int[N], w = new int[N];
    static boolean[] st = new boolean[N];
    static int n, m, idx;
    static PriorityQueue<Point> heap = new PriorityQueue<>(Comparator.comparingInt(o->o.value));

    static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    static int dijkstra() {
        Arrays.fill(dis, INF);
        dis[1] = 0;
        heap.add(new Point(1,0));
        while (!heap.isEmpty()) {
            Point t = heap.poll();
            if (st[t.index]) {
                continue;
            }
            for (int i = h[t.index]; i != -1; i = ne[i]) {
                int j = e[i];
                if (dis[j] > t.value + w[i]) {
                    dis[j] = t.value + w[i];
                    heap.add(new Point(j,dis[j]));
                }
            }

        }
        return dis[n] == INF ? -1 : dis[n];
    }

    public static void main(String[] args) throws Exception {
        n = nextInt();
        m = nextInt();
        Arrays.fill(h, -1);
        while (m-- > 0) {
            int a = nextInt(), b = nextInt(), c = nextInt();
            add(a, b, c);
        }
        System.out.println(dijkstra());

    }
}
