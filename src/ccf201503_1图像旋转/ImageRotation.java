package ccf201503_1图像旋转;

import java.util.Scanner;

public class ImageRotation {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int t = Math.max(m,n);
        int [][]g = new int[t][t];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                g[i][j] = sc.nextInt();
            }
        }
        for (int i = m-1; i >=0; i--) {
            for (int j = 0; j <n; j++) {
                System.out.print(g[j][i] + " ");
            }
            System.out.println();
        }

    }


}
