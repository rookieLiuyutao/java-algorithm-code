package leetcode909蛇梯棋;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class SnakesAndLadders2 {

    int n;
    int[] nums;
    public int snakesAndLadders(int[][] board) {
        n = board.length;
        if (board[0][0] != -1) return -1;
        nums = new int[n * n + 1];
        boolean isRight = true;
        for (int i = n - 1, idx = 1; i >= 0; i--) {
            for (int j = (isRight ? 0 : n - 1); isRight ? j < n : j >= 0; j += isRight ? 1 : -1) {
                nums[idx++] = board[i][j];
            }
            isRight = !isRight;
        }
        int ans = bfs();
        return ans;
    }
    int bfs() {
        Deque<Integer> d = new ArrayDeque<>();
        Map<Integer, Integer> m = new HashMap<>();
        d.addLast(1);
        m.put(1, 0);
        while (!d.isEmpty()) {
            int poll = d.pollFirst();
            int step = m.get(poll);
            if (poll == n * n) return step;
            for (int i = 1; i <= 6; i++) {
                int np = poll + i;
                if (np <= 0 || np > n * n) continue;
                if (nums[np] != -1) np = nums[np];
                if (m.containsKey(np)) continue;
                m.put(np, step + 1);
                d.addLast(np);
            }
        }
        return -1;
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
        System.out.println(new SnakesAndLadders2().snakesAndLadders(board2));

    }


}
