package leetcode212单词搜索II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SearchWordsII {
    List<String> res = new ArrayList<>();
    HashSet<String> set = new HashSet<>();
    int n, m;
    int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
    boolean[][] st = new boolean[n][m];

    /**
     *
     * @param x 起点横坐标
     * @param y 起点纵坐标
     * @param sb 以当前起点开头的单词
     * @param bord 字符矩阵
     */
    void dfs(int x, int y, StringBuilder sb,char[][]bord) {
        if (sb.length() > 10) {
            return;
        }
        if (set.contains(sb.toString())) {
            res.add(sb.toString());
            set.remove(sb.toString());
        }
        for (int i = 0; i < 4; i++) {
            int a = x + dx[i], b = y + dy[i];
            if (a < 0 || a >= n || b < 0 || b >= m||st[a][b]) {
                continue;
            }
            sb.append(bord[a][b]);
            st[a][b] = true;
            dfs(a,b,sb,bord);
            st[a][b] = false;
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        n = board.length;
        m = board[0].length;
        set.addAll(Arrays.asList(words));
        //枚举起点
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //防止搜到起点
                StringBuilder sb = new StringBuilder();
                st[i][j] = true;
                dfs(i, j, sb.append(board[i][j]),board);
                st[i][j] = false;
            }
        }

        return res;
    }

}
