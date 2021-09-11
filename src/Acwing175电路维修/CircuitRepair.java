package Acwing175电路维修;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/177/
 */
public class CircuitRepair {
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static final int N = 510;
    static Scanner sc = new Scanner(System.in);
    static char[][] g = new char[N][N];
    static boolean[][] st = new boolean[N][N];
    static int[][] dist = new int[N][N];
    static int n, m;

    static int bfs() {
        ArrayDeque<Point> q = new ArrayDeque<>();
        int[] dx = {-1, -1, 1, 1}, dy = {-1, 1, 1, -1}, ix = {-1, -1, 0, 0}, iy = {-1, 0, 0, -1};
        char[] cs = {'\\','/','\\','/'};
        for (int[] x : dist) {
            Arrays.fill(x, 0x3f);
        }
        for (boolean []x:st){
            Arrays.fill(x,false);
        }
        dist[0][0] = 0;
        q.addLast(new Point(0, 0));

        while (!q.isEmpty()) {
            Point t = q.pollFirst();
            if (t.x == n && t.y == m) {
                return dist[t.x][t.y];
            }
            if (st[t.x][t.y]) {
                continue;
            }
            st[t.x][t.y] = true;
            for (int i = 0; i < 4; i++) {
                int a = t.x + dx[i], b = t.y + dy[i];
                if (a < 0 || a > n || b < 0 || b > m) {
                    continue;
                }
                int ga = t.x + ix[i], gb = t.y + iy[i];
                int w = g[ga][gb] != cs[i] ? 1 : 0;
                int d = dist[t.x][t.y] + w;
                if (d < dist[a][b]) {
                    dist[a][b] = d;
                    if (w == 0) {
                        q.addFirst(new Point(a, b));
                    } else {
                        q.addLast(new Point(a, b));
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            m = sc.nextInt();
            for (int i = 0; i < n; i++) {
                g[i] = sc.next().toCharArray();
            }
            if (((n + m) & 1) != 0) {
                System.out.println("NO SOLUTION");
            } else {
                System.out.println(bfs());
            }
        }
    }
}
