package Acwing854Floyd求最短路;

import java.util.Scanner;

public class FloydClassAnswer {
    static int N = 210;
    static int n, m, q;
    static int[][] d = new int[N][N];
    static int INF = (int)1e9;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); m = sc.nextInt(); q = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) d[i][j] = 0;
                else d[i][j] = INF;
            }
        }

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), w = sc.nextInt();
            d[a][b] = Math.min(d[a][b], w);
        }

        Floyd();

        while (q-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt();
            if (d[a][b] > INF / 2) System.out.println("impossible");
            else System.out.println(d[a][b]);
        }
    }

    private static void Floyd() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }
    }
}



