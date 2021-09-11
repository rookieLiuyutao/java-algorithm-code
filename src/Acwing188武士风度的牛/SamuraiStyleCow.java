package Acwing188武士风度的牛;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/190/
 */
public class SamuraiStyleCow {
    static Scanner sc = new Scanner(System.in);

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m;
    static char[][] g;
    static int[][] dist;

    static int bfs(int sx, int sy, int ex, int ey) {
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
        for (int[] x : dist) {
            Arrays.fill(x, -1);
        }
        ArrayDeque<Point> q = new ArrayDeque<>();
        q.add(new Point(sx, sy));
        dist[sx][sy] = 0;
        while (!q.isEmpty()) {
            Point t = q.poll();
            for (int i = 0; i < 8; i++) {
                int a = t.x + dx[i], b = t.y + dy[i];
                if (a < 0 || a >= n || b < 0 || b >= m || g[a][b] == '*') {
                    continue;
                }
               if (dist[a][b]!=-1){
                   continue;
               }
                dist[a][b] = dist[t.x][t.y] + 1;
                q.add(new Point(a, b));

            }
        }
        return dist[ex][ey];
    }

    public static void main(String[] args) throws Exception {
        m = sc.nextInt();
        n = sc.nextInt();
        g = new char[n + 1][m + 1];
        dist = new int[n + 1][m + 1];
        int sx = 0, sy = 0, ex = 0, ey = 0;
        for (int i = 0; i < n; i++) {
            String x = sc.next();
            for (int j = 0; j < m; j++) {
                g[i][j] = x.charAt(j);
                if (g[i][j] == 'K') {
                    sx = i;
                    sy = j;
                } else if (g[i][j] == 'H') {
                    ex = i;
                    ey = j;
                }
            }
        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(g[i][j]);
//            }
//            System.out.println();
//        }
        System.out.println(bfs(sx, sy, ex, ey));
    }

}
