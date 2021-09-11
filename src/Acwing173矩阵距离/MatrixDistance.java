package Acwing173矩阵距离;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/175/
 * 多源bfs
 */
public class MatrixDistance {
    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    static int nextInt() throws Exception{
        in.nextToken();
        return (int)in.nval;
    }
    static String next()throws Exception{
        in.nextToken();
        return in.sval;
    }
    static Scanner sc = new Scanner(System.in);

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] dist;
    static char[][] g;
    static int n, m;

    static void bfs() {
        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
        for (int[] x : dist) {
            Arrays.fill(x, -1);
        }
        ArrayDeque<Point> q = new ArrayDeque<>();
        //多源bfs就是把多个起点全放进初始队列
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == '1') {
                    q.add(new Point(i, j));
                    dist[i][j] = 0;
                }
            }
        }
        while (!q.isEmpty()) {
            Point t = q.poll();
            for (int i = 0; i < 4; i++) {
                int a = t.x + dx[i], b = t.y + dy[i];
                if (a < 0 || a >= n || b < 0 || b >= m || dist[a][b] != -1) {
                    continue;
                }
                dist[a][b] = dist[t.x][t.y] + 1;
                q.add(new Point(a, b));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        n = sc.nextInt();
        m = sc.nextInt();
        g = new char[n][m];
        dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            g[i] = sc.next().toCharArray();
        }
        for(int i = 0; i <n; i++) {
            for(int j = 0; j <m; j++) {
                out.print(g[i][j]);
            }
            out.println();
        }
        bfs();
        for(int i = 0; i <n; i++) {
            for(int j = 0; j <m; j++) {
                out.print(dist[i][j]+" ");
            }
            out.println();
        }
        out.flush();
    }

}
