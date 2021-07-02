package leetcode909蛇梯棋;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @see 广搜 https://leetcode-cn.com/problems/snakes-and-ladders/
 */
public class SnakesAndLadders {

    class Point {
        int x, y, num;

        public Point() {
        }

        public Point(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }


    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] arr = new int[n * n + 1];
        int[] dist = new int[n * n + 1];
        Arrays.fill(dist, 1000);
        for (int i = n - 1, s = 0, k = 1; i >= 0; i--, s++) {
            if (s % 2 == 0) {
                for (int j = 0; j < n; j++, k++) {
                    arr[k] = board[i][j];
                }
            } else {
                for (int j = n - 1; j >= 0; j--, k++) {
                    arr[k] = board[i][j];
                }
            }
        }
        System.out.println(Arrays.toString(arr));

        Deque<Integer> deque = new ArrayDeque<>();
        int start = 1;
        deque.add(start);
        dist[start] = 0;
        while (!deque.isEmpty()) {
            int tt = deque.pollFirst();
            if (arr[tt] == n * n) {
                return dist[n * n];
            }
            for (int i = tt + 1; i < tt + 6 && i <= n * n; i++) {
                if (arr[i] == -1) {
                    if (dist[i] > dist[tt] + 1) {
                        dist[i] = dist[tt] + 1;
                        deque.add(i);
                    }

                } else {
                    int jump = arr[i];
                    if (dist[jump] > dist[tt]) {
                        dist[jump] = dist[tt] + 1;
                        deque.add(jump);
                    }
                }

            }
        }
//        System.out.println(Arrays.toString(dist));
        return dist[n * n] == 1000 ? -1 : dist[n * n];
    }

    public static void main(String[] args) {
        int[][] board = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}
        };
        int[][] board2 = {
                {-1, 1, 2, -1},
                {2, 13, 15, -1},
                {-1, 10, -1, -1},
                {-1, 6, 2, 8}
        };
        System.out.println(new SnakesAndLadders().snakesAndLadders(board2));

    }

}
