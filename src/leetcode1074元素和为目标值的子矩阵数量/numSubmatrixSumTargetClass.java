package leetcode1074元素和为目标值的子矩阵数量;

/**
 * @see 二维前缀和 https://leetcode-cn.com/problems/number-of-submatrices-that-sum-to-target/
 */
public class numSubmatrixSumTargetClass {
    public int getSum(int[][]s,int x1,int y1,int x2,int y2){
        return s[x2][y2]-s[x1-1][y2]-s[x2][y1-1]+s[x1-1][y1-1];
    }
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][]s = new int[n+1][m+1];

        for(int i = 1; i <=n; i++) {
            for(int j = 1; j <=m; j++) {
                s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + matrix[i-1][j-1];
            }
        }
        int res = 0;
        for(int x2 = 1; x2 <=n; x2++) {
            for(int y2 = 1; y2 <=m; y2++) {
                for(int x1 = 1; x1 <=x2; x1++) {
                    for(int y1 = 1; y1 <=y2; y1++) {
                        int x = getSum(s,x1,y1,x2,y2);
                        if (x == target) {
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }
}
