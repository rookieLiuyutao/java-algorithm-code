package AcWing1101献给阿尔吉侬的花束;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @see bfs 广搜 https://www.acwing.com/problem/content/1103/
 */
public class BouquetForAlgernon {

    static Scanner sc = new Scanner(System.in);
    static int n, m;
    static char[][] g;
    static int[][] dist;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static Deque<Point> deque = new ArrayDeque<>();

    static class Point {
        int x, y;

        public Point() {
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean check(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return true;
        }
        return g[x][y] == '#';
    }

    static int bfs(Point start, Point end) {
        deque.add(start);
        dist[start.x][start.y] = 0;

        while (!deque.isEmpty()) {
            Point tt = deque.pollFirst();

            for (int i = 0; i < 4; i++) {

                int a = tt.x + dx[i], b = tt.y + dy[i];
                if (check(a, b)) {
                    continue;
                }
                if (dist[a][b] == -1) {
                    dist[a][b] = dist[tt.x][tt.y] + 1;
                    deque.add(new Point(a, b));
                }

            }

        }
        return dist[end.x][end.y];


    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
             n = sc.nextInt();
             m = sc.nextInt();

            g = new char[n][m];
            dist = new int[n][m];

            Point start = new Point();
            Point end = new Point();

            for (int i = 0; i < n; i++) {
                String temp = sc.next();
                for (int j = 0; j < m; j++) {
                    g[i][j] = temp.charAt(j);
                    if (g[i][j] == 'S') {
                        start = new Point(i, j);
                    } else if (g[i][j] == 'E') {
                        end = new Point(i, j);
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    dist[i][j] = -1;
                }
            }
//            System.out.println("qidian:("+start.x+","+start.y+")");
//            System.out.println("zhongdian:("+end.x+","+end.y+")");
            int res = bfs(start, end);

//            for(int i = 0; i <n; i++) {
//                for(int j = 0; j <m; j++) {
//                    System.out.print(dist[i][j]+" ");
//                }
//                System.out.println();
//            }


            if (res == -1) {
                System.out.println("oop!");
            } else {
                System.out.println(res);
            }


        }

    }


}
