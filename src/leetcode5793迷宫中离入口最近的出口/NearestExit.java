package leetcode5793迷宫中离入口最近的出口;
/**
 * https://leetcode-cn.com/problems/nearest-exit-from-entrance-in-maze/
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class NearestExit {
    class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int n, m;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public int nearestExit(char[][] maze, int[] entrance) {
        n = maze.length;
        m = maze[0].length;
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = Integer.MAX_VALUE/2;
            }
        }
        Deque<Point> deque = new ArrayDeque<>();
        deque.add(new Point(entrance[0], entrance[1]));
        dist[entrance[0]][entrance[1]] = 0;
        while (!deque.isEmpty()) {
            Point tt = deque.pollFirst();
            for (int i = 0; i < 4; i++) {
                int a = tt.x + dx[i], b = tt.y + dy[i];
                if (a >= 0 && a < n && b >= 0 && b < m && maze[a][b] == '.' && dist[a][b] > dist[tt.x][tt.y] + 1) {
                    dist[a][b] = dist[tt.x][tt.y] + 1;
                    if (a == 0 || a == n - 1 || b == 0 || b == m - 1) {
                        return dist[a][b];
                    }
                    deque.add(new Point(a, b));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        char[][] maze = {{'+', '+', '.', '+'}, {'.', '.', '.', '+'}, {'+', '+', '+', '.'}};
        char[][] maze2 = {{'+', '+', '+'}, {'.', '.', '.'}, {'+', '+', '+'}};
        char[][] maze3 = {{'.', '+', '.'}, {'+', '.', '+'}, {'.', '+', '.'}};
        char[][] maze4 = {{'.'}, {'.'}, {'+'}};
        int[] entrance = {0, 0};
        System.out.println(new NearestExit().nearestExit(maze, entrance));
    }
}
