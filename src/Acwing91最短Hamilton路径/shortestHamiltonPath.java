package Acwing91最短Hamilton路径;

import java.util.Scanner;

/**
 * @see 状态压缩dp 旅行商问题 https://www.acwing.com/problem/content/93/
 * <p>
 * Hamilton路径的定义是从 0 到 n-1 不重不漏地经过每个点恰好一次
 * <p>
 * 优化时考虑：
 * 1.哪些点被用过
 * 2.当前在哪个点
 * <p>
 * 集合：从0走到j，走过的点是i的集合的所有路径
 * 属性：min
 * 集合的划分：0走到j之前有一点k(0->k->j),以k为终点的最短距离
 * 用n位二进制数来表示i的点集：1表示经过了这个点，0表示未经过这个点
 * dp[i][j]=min(dp[i][j],dp[i-(1<<j)][k]+w[k][j])
 */
public class shortestHamiltonPath {
    static int N = 20, M = 1 << N;
    static int[][] dp = new int[M][N];
    //weight是有N个点的无向图的邻接矩阵
    static int[][] weight = new int[N][N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int range = 1 << n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                weight[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = Integer.MAX_VALUE / 2;
            }
        }
        //起点是0
        dp[1][0] = 0;
        for (int i = 0; i < range; i++) {
            for (int j = 0; j < n; j++) {
                //i >> j & 1,判断i的二进制的第j位
                if ((i >> j & 1) != 0) {
                    for (int k = 0; k < n; k++) {
                        if ((i>>k&1)!=0){
                            dp[i][j] = Math.min(dp[i][j], dp[i - (1 << j)][k] + weight[j][k]);
                        }
                    }
                }
            }
        }
        System.out.println(dp[(1 << n) - 1][n - 1]);
    }
}
