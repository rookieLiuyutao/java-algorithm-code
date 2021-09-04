package Acwing3825逃离大森林;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/3828/
 */
public class EscapeFromTheBigForest {
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Scanner sc = new Scanner(System.in);
    static final int INF = Integer.MAX_VALUE / 2;
    static char[][] g;
    static int n, m;
    static int[][] dis;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    static int bfs(Point start, Point end) {
        for (int i = 0; i < n; i++) {
            Arrays.fill(dis[i], INF);
        }
        ArrayDeque<Point> q = new ArrayDeque<>();
        q.add(end);
        dis[end.x][end.y] = 0;
        while (!q.isEmpty()) {
            Point t = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = t.x + dx[i], y = t.y + dy[i];
                if (x >= 0 && x < n && y >= 0 && y < m && g[x][y] != 'T') {
                    if (dis[x][y] > dis[t.x][t.y] + 1) {
                        dis[x][y] = dis[t.x][t.y]+1;
                        q.add(new Point(x, y));
                    }
                }

            }
        }
        return dis[start.x][start.y];
    }

    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();
        int sx = 0, sy = 0, ex = 0, ey = 0;
        g = new char[n][m];
        dis = new int[n][m];

        for (int i = 0; i < n; i++) {
            String x = sc.next();
            for (int j = 0; j < m; j++) {
                g[i][j] = x.charAt(j);
                if (g[i][j] == 'S') {
                     sx = i;
                     sy = j;
                }
                if (g[i][j] == 'E') {
                    ex = i;
                    ey = j;
                }

            }
        }

        Point end = new Point(ex, ey);
        Point start = new Point(sx, sy);
        int ans = bfs(start, end);
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] >= '0' && g[i][j] <= '9' && dis[i][j] <= ans) {
                    res += g[i][j]-'0';
                }
            }
        }
        System.out.println(res);
    }

}
