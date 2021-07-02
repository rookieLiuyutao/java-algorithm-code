package AcWing1113红与黑;

import java.util.Scanner;

/**
 * @see dfs 深搜 https://www.acwing.com/problem/content/1115/
 */
public class DfsFoolFIll {

    static Scanner sc = new Scanner(System.in);

    static int n, m;

    static char[][] g;
    static boolean[][] st;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    static int dfs(int x, int y) {
        int res = 1;
        st[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int a = x + dx[i];
            int b = y + dy[i];
            if (a < 0 || a >= n || b < 0 || b >= m) {
                continue;
            }
            if (g[a][b] != '.') {
                continue;
            }
            if (st[a][b]) {
                continue;
            }
            res += dfs(a, b);
        }
        return res;
    }

    public static void main(String[] args) throws Exception {

        while (sc.hasNext()) {
            m = sc.nextInt();
            n = sc.nextInt();
            if (n == 0 && m == 0) {
                break;
            }
            g = new char[n][m];
            st = new boolean[n][m];
            int x = -1, y = -1;
            for (int i = 0; i < n; i++) {
                String s = sc.next();
                for (int j = 0; j < m; j++) {
                    g[i][j] = s.charAt(j);
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (g[i][j] == '@') {
                        x = i;
                        y = j;
                    }
                }
            }
            System.out.println(dfs(x, y));

        }
    }


}
