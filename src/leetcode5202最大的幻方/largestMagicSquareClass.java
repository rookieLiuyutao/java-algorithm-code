package leetcode5202最大的幻方;

/**
 * @see
 */
public class largestMagicSquareClass {
    static int[][] rowSum, colSum;

    boolean check(int[][] grid, int x1, int y1, int x2, int y2) {
        //计算行是否相等
        int rs = rowSum[x1][y2 + 1] - rowSum[x1][y1];

        for (int i = x1 + 1; i <= x2; i++) {
            if (rs != rowSum[i][y2 + 1] - rowSum[i][y1]) {
                return false;
            }
        }
        //在每行都相等的后，如果行和列不相等，直接会不成立，如果相等，在进行列的判断
        int cs = colSum[x2 + 1][y1] - colSum[x1][y1];
        if (rs != cs) {
            return false;
        }
        //计算每列是否相等
        for (int i = y1 + 1; i <= y2; i++) {
            if (cs != colSum[x2 + 1][i] - colSum[x1][i]) {
                return false;
            }
        }
        //计算正对角线
        int s = 0;
        for (int i = x1, j = y1; i <= x2 && j <= y1; i++, j++) {
            s += grid[i][j];
        }
        if (s != cs) {
            return false;
        }
        //计算反对角线
        s = 0;
        for (int i = x2, j = y1; i >= x1 && j <= y2; i--, j++) {
            s += grid[i][j];
        }
        if (s != cs) {
            return false;
        }
        return true;
    }

    public int largestMagicSquare(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        //初始化
        rowSum = new int[n][m + 1];
        colSum = new int[n + 1][m];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= m; j++) {
                rowSum[i][j] = rowSum[i][j - 1] + grid[i][j - 1];
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                colSum[i][j] = colSum[i - 1][j] + grid[i - 1][j];
            }
        }
        int edge = Math.min(n, m);

        //枚举每个边长
        for (int k = edge; k > 1; k--) {
            //枚举每个左上角横坐标
            for (int i = 0; i + k - 1 < n; i++) {
                //枚举每个左上角纵坐标
                for (int j = 0; j + k - 1 < m; j++) {
                    if (check(grid, i, j, i + k - 1, j + k - 1)) {
                        return k;
                    }
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        int[][] grid = {{7, 1, 4, 5, 6}, {2, 5, 1, 6, 4}, {1, 5, 4, 3, 2}, {1, 2, 7, 3, 4}};

        System.out.println(new largestMagicSquareClass().largestMagicSquare(grid));
    }
}
