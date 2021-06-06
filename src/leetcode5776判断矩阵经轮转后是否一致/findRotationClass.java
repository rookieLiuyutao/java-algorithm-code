package leetcode5776判断矩阵经轮转后是否一致;

/**
 * @see x
 */
public class findRotationClass {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        int m = mat[0].length;
        int count = 0;
        if (m == 1 && n == 1) {
            return mat[0][0] == target[0][0];
        }
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                if (mat[i][j] == target[i][m - 1 - j]) {
                    if (mat[i][m - 1 - j] == target[n - 1 - i][m - 1 - j] && mat[n - 1 - i][m - 1 - j] == target[n - 1 - i][j] && mat[n - 1 - i][j] == target[i][j]) {
                        count++;
                    }
                }
                if (mat[i][j] == target[n - 1 - i][m - 1 - j]) {
                    if (mat[i][m - 1 - j] == target[n - 1 - i][j] && mat[n - 1 - i][m - 1 - j] == target[i][j] && mat[n - 1 - i][j] == target[i][m - 1 - j]) {
                        count++;
                    }
                }
                if (mat[i][j] == target[n - 1 - i][j]) {
                    if (mat[i][m - 1 - j] == target[i][j] && mat[i][m - 1 - j] == target[n - 1 - i][j] && mat[n - 1 - i][j] == target[n - 1 - i][m - 1 - j]) {
                        count++;
                    }
                }
                if (mat[i][j] == target[i][j]) {
                    if (mat[i][m - 1 - j] == target[i][m - 1 - j] && mat[i][m - 1 - j] == target[i][m - 1 - j] && mat[n - 1 - i][j] == target[n - 1 - i][j]) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
        return count >= (n / 2) * (m / 2);
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 0},{0,1}};
        int[][] t = {{1, 0},{0,1}};
        System.out.println(new findRotationClass().findRotation(mat, t));
    }
}
