package AcWing3565完美矩阵;

import java.util.*;

/**
 * @see 哈希集合 https://www.acwing.com/problem/content/3568/
 */
public class perfectMatrixClass {

    static final int N = 105;
    static int n, m;
    static int[][] matrix = new int[N][N];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        while (count-- > 0) {
            long res = 0;
            n = in.nextInt();
            m = in.nextInt();
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    int[] a = new int[4];
                    a[0] = matrix[i][j];
                    a[1] = matrix[i][m - j + 1];
                    a[2] = matrix[n - i + 1][j];
                    a[3] = matrix[n - i + 1][m - j + 1];
                    Arrays.sort(a);
                    for (int k = 0; k < 4; k++) {
                        res += Math.abs(a[k] - a[1]);
                    }
                }
            }
            System.out.println(res/4);
            for(int i = 1; i <=n; i++) {
                for(int j =1; j <=m; j++) {
                    System.out.print(matrix[n][m]+" ");
                }
                System.out.println();
            }

        }
    }



}
