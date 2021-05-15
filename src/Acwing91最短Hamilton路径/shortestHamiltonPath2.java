package Acwing91最短Hamilton路径;

import java.util.Arrays;
import java.util.Scanner;

public class shortestHamiltonPath2 {
    static int N = 20, n, res, sum;
    //weight是有N个点的无向图的邻接矩阵
    static int[][] weight = new int[N][N];
    static int[] path = new int[N];
    static boolean[] isPass = new boolean[N];

    /**
     * @param u 当前点的标号
     * @param count 用来计数的变量，判断一共走过的几个点
     */
    static void dfs(int u, int count) {
        if (count == n-1 && path[count] == n - 1) {
            System.out.println(Arrays.toString(path));
            res = Math.min(res, sum);
            return;
        }else if (path[count]!=n-1){
            isPass[u] = true;
            for(int i = 0; i <n; i++) {
              if (!isPass[i]){
                  sum+=weight[u][i];
                  path[count+1] = i;
                  dfs(i,count+1);
                  sum-=weight[u][i];
              }
            }
        }
        isPass[u] = false;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        res = Integer.MAX_VALUE / 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                weight[i][j] = sc.nextInt();
            }
        }
        dfs(0, 0);
        System.out.println(res);
    }


}
