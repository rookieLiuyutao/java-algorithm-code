package Acwing850Dijkstra求最短路II;

import java.io.*;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://www.acwing.com/problem/content/852/
 */
public class DijkstraSeekingTheShortestPathII {

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
    static PriorityQueue<AbstractMap.SimpleEntry<Integer, Integer>> heap = new PriorityQueue<>(Comparator.comparingInt(AbstractMap.SimpleEntry::getKey));

    static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    static int dijkstra() {
        Arrays.fill(dis, INF);
        dis[1] = 0;
        heap.add(new AbstractMap.SimpleEntry<>(0, 1));
        while (!heap.isEmpty()) {
            AbstractMap.SimpleEntry<Integer, Integer> t = heap.poll();
            if (st[t.getValue()]) {
                continue;
            }
            for (int i = h[t.getValue()]; i != -1; i = ne[i]) {
                int j = e[i];
                if (dis[j] > t.getKey() + w[i]) {
                    dis[j] = t.getKey() + w[i];
                    heap.add(new AbstractMap.SimpleEntry<>(dis[j], j));
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
