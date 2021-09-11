package Acwing1076迷宫问题;

import java.io.*;
import java.util.*;

/**
 * http://ybt.ssoier.cn:8088/problem_show.php?pid=1255
 */
public class MazeProblem {
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

    static class Point {
        int x, y;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static final int N = 1010;
    static Point[][] pr = new Point[N][N];
    static int n;
    static int[][] g = new int[N][N];
    static HashSet<Point> list = new HashSet<>();

    static void bfs(int sx, int sy) {
        ArrayDeque<Point> q = new ArrayDeque<>();
        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
        q.add(new Point(sx, sy));
        for (Point[] x : pr) {
            Arrays.fill(x, new Point(-1, -1));
        }
        pr[sx][sy] = new Point(0, 0);
        while (!q.isEmpty()) {
            Point t = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = t.x + dx[i], y = t.y + dy[i];
                if (x < 0 || x >= n || y < 0 || y >= n ) {
                    continue;
                }
                if (g[x][y] == 1) {
                    continue;
                }
                if (pr[x][y].x != -1) {
                    continue;
                }
                q.add(new Point(x, y));
                pr[x][y] = t;
                list.add(t);
            }
        }
    }

    public static void main(String[] args) throws Exception {
         n = nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = nextInt();
            }
        }
        bfs(n - 1, n - 1);
        Point end = new Point(0, 0);
//        for(int i = 0; i <5; i++) {
//            for(int j = 0; j <5; j++) {
//                System.out.print("("+pr[i][j].x+","+pr[i][j].y+")  ");
//            }
//            System.out.println();
//        }
        while (true) {
            System.out.println(end.x + " " + end.y);
            if (end.x == n - 1 && end.y == n - 1) {
                break;
            }
            end = pr[end.x][end.y];
        }
//        for (Point p:list){
//            System.out.print("("+p.x+","+p.y+")");
//        }
    }
}
