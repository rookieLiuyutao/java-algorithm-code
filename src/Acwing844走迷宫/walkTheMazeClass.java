package Acwing844走迷宫;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class walkTheMazeClass {
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
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static final int N = 110;
    //maze存放迷宫的地图，distance表示地图上每个点到起点的距离
    static int[][] maze = new int[N][N], distance = new int[N][N];
    static int m, n;
    static Deque<Point> queue = new ArrayDeque<>();

    static int bfs() {
        distance[0][0] = 0;
        queue.add(new Point(0, 0));
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        while (!queue.isEmpty()) {
            Point tt = queue.pollFirst();
            for (int i = 0; i < 4; i++) {
                int a = dx[i] + tt.x;
                int b = dy[i] + tt.y;
                if (a >= 0 && a < n && b >= 0 && b < m && distance[a][b] == -1 && maze[a][b] == 0) {
                    queue.add(new Point(a, b));
                    distance[a][b] = distance[tt.x][tt.y] + 1;
                }
            }
        }
        return distance[n - 1][m - 1];
    }

    public static void main(String[] args)throws Exception {
        n = nextInt();
        m = nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maze[i][j] = nextInt();
            }
        }
        for (int i = 0; i < 105; i++) {
            Arrays.fill(distance[i], -1);
        }

        System.out.println(bfs());

    }


}
