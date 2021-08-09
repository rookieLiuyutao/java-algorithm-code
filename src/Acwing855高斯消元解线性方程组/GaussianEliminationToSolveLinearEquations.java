package Acwing855高斯消元解线性方程组;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/885/
 */
public class GaussianEliminationToSolveLinearEquations {

    static Scanner sc = new Scanner(System.in);

    static double[][] a = new double[110][110];
    static final double EAP = 1e-6;

    static int gauss(int n) {
//----------将系数矩阵化为上三角形行列式-------------
        //c表示当前遍历的列号，r表示当前遍历的行号
        int r = 0;
        for (int c = 0; c < n; c++) {
            //寻找该列某行最大值的指针
            int t = r;
            //遍历每一行，找到第c列数最大的一行，记录行号
            for (int i = r; i < n; i++) {
                if (Math.abs(a[i][c]) > Math.abs(a[t][c])) {
                    t = i;
                }
            }
            //如果第c列数最大的一行，数为0，则这一行不用处理
            if (Math.abs(a[t][c])<EAP) {
                continue;
            }
            //把第c列数最大的一行换至待处理行的第一行
            for (int i = c; i <= n; i++) {
                double temp = a[t][i];
                a[t][i] = a[r][i];
                a[r][i] = temp;
            }
            //该行的每个数都除该行第一个数，即将该行第c个数变为1
            for (int i = n; i >= c; i--) {
                a[r][i] /= a[r][c];
            }
            //将其他行第c列都变为0
            for (int i = r + 1; i < n; i++) {
                if (Math.abs(a[i][c]) >EAP) {
                    for (int j = n; j >= c; j--) {
                        a[i][j] -= a[r][j] * a[i][c];
                    }
                }
            }

            r++;
        }
//------------------------------------------------------

        //如果有一行系数为全0，则不是唯一解
        if (r < n) {
            for (int i = r; i < n; i++) {
                if (Math.abs(a[i][n]) >EAP) {
                    return 2;
                }
            }
            return 1;
        }
        //根据系数矩阵算出解
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j <= n; j++) {
                a[i][n] -= a[i][j] * a[j][n];
            }
        }
        //--------------------------------------
//          |     1                 b1
//        i |     0     1 a[i][j]  a[i][n]
//          |     0     0     1    a[j][n]
//          |
//          |
        return 0;
    }

    public static void main(String[] args) throws Exception {
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            //注意要把b读进去
            for (int j = 0; j < n+1; j++) {
                a[i][j] = sc.nextDouble();
            }
        }
        int x = gauss(n);
        if (x == 1) {
            System.out.println("Infinite group solutions");
        } else if (x == 2) {
            System.out.println("No solution");
        } else {
            for (int i = 0; i < n; i++) {
                System.out.printf("%.2f\n" ,a[i][n]);
            }
        }
    }
}
