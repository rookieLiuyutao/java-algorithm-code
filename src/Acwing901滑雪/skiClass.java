package Acwing901滑雪;
/**
 * @see 记忆化搜索 https://www.luogu.com.cn/problem/P1434 https://www.acwing.com/problem/content/903/
 */
import java.util.Scanner;

public class skiClass {

        static int line,row;
        static int N  = 310;
        static int[][] dp = new int[N][N];
        static int[][]  height = new int[N][N];
        static int[] directionX = {0, 0, 1, -1};
        static int[] directionY = {1, -1, 0, 0};

        public static int dfs(int x, int y) {
            //------记忆化--------
            if (dp[x][y] != 0) return dp[x][y];
            //-------------------
            dp[x][y] = 1;
            //分别枚举上，下，左，右4个路径
            for (int i = 0; i < 4; i++) {
                int a = directionX[i] + x;
                int b = directionY[i] + y;
                if (a >= 1 && a <= line && b >= 1 && b <= row && height[a][b] < height[x][y]) {
                    dp[x][y] = Math.max(dp[x][y], dfs(a, b) + 1);
                }
            }
            return dp[x][y];
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            line = sc.nextInt();
            row = sc.nextInt();
            for (int i = 1; i <= line; i++) {
                for (int j = 1; j <= row; j++) {
                    height[i][j] = sc.nextInt();
                }
            }

            //-------------------

            //初始化dp数组的所有值为-1
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                dp[i][j] = -1;
//            }
//        }
            int res = 0;
            //
            for (int i = 1; i < line + 1; i++) {
                for (int j = 1; j < row + 1; j++) {
                    res = Math.max(res, dfs(i, j));
                }
            }
            System.out.println(res);
        }
}


