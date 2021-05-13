package leetcode74搜素二维矩阵;

/**
 * @see 矩阵单调性 https://leetcode-cn.com/problems/search-a-2d-matrix/solution/gong-shui-san-xie-yi-ti-shuang-jie-er-fe-l0pq/
 */

public class searchMatrixClass {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int cols=matrix[0].length-1;
        while (row<matrix.length&&cols>=0){
            if (target==matrix[row][cols]){
                return true;
            }else if (target>matrix[row][cols]){
                row++;
            }else {
                cols--;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 0, 1, 2, 3, 4, 5, 6 },// 0
                { 10, 12, 13, 15, 16, 17, 18 },// 1
                { 23, 24, 25, 26, 27, 28, 29 },// 2
                { 44, 45, 46, 47, 48, 49, 50 },// 3
                { 65, 66, 67, 68, 69, 70, 71 },// 4
                { 96, 97, 98, 99, 100, 111, 122 },// 5
                { 166, 176, 186, 187, 190, 195, 200 },// 6
                { 233, 243, 321, 341, 356, 370, 380 } // 7
        };
        int K = 233;
        System.out.println(new searchMatrixClass().searchMatrix(matrix, K));
    }
}
