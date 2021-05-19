package leetcode1738找出第K大的异或坐标值;

import java.util.*;

/**
 * @see 二维前缀和 https://leetcode-cn.com/problems/find-kth-largest-xor-coordinate-value/
 */
public class kthLargestValueClass {


    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[1].length;
        ArrayList<Integer> list = new ArrayList<>();
        int[][] matrixSum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                matrixSum[i][j] = matrixSum[i - 1][j] ^ matrixSum[i][j - 1] ^ matrixSum[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                list.add(matrixSum[i][j]);
            }
        }
//        for (int i = 0; i <= m; i++) {
//            for (int j = 0; j <= n; j++) {
//                System.out.print(matrixSum[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println(list);
        return Collections.min(list);
    }

    public static void main(String[] args) {
        int[][] arr = {{5, 2},
                {1, 6},
        };
        System.out.println(new kthLargestValueClass().kthLargestValue(arr, 1));
    }
}
