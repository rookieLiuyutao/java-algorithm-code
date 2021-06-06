package Acwing854Floyd求最短路;

import java.io.*;

/**
 * @see 图论 多源最短路 Floyd求最短路 https://www.acwing.com/solution/content/20441/
 */
//测试数据：
//5 10 3
//1 2 2
//5 3 3
//4 1 8
//2 4 3
//4 5 7
//5 2 3
//3 4 1
//1 2 9
//3 2 3
//
//1 2 8
//
//2 5
//
//2 4
//
//3 5
public class FloydClass {
        /*解题思路，动态规划的思想
    假设节点序号是从1到n。
    假设f[0][i][j]是一个n*n的矩阵，第i行第j列代表从i到j的权值，如果i到j有边，那么其值就为ci,j（边ij的权值）。
    如果没有边，那么其值就为无穷大。

    f[k][i][j]代表（k的取值范围是从1到n），在考虑了从1到k的节点作为中间经过的节点时，从i到j的最短路径的长度。

    比如，f[1][i][j]就代表了，在考虑了1节点作为中间经过的节点时，从i到j的最短路径的长度。
    分析可知，f[1][i][j]的值无非就是两种情况，而现在需要分析的路径也无非两种情况，i=>j，i=>1=>j：
    【1】f[0][i][j]：i=>j这种路径的长度，小于，i=>1=>j这种路径的长度
    【2】f[0][i][1]+f[0][1][j]：i=>1=>j这种路径的长度，小于，i=>j这种路径的长度
    形式化说明如下：
    f[k][i][j]可以从两种情况转移而来：
    【1】从f[k−1][i][j]转移而来，表示i到j的最短路径不经过k这个节点
    【2】从f[k−1][i][k]+f[k−1][k][j]转移而来，表示i到j的最短路径经过k这个节点

    总结就是：f[k][i][j]=min(f[k−1][i][j],f[k−1][i][k]+f[k−1][k][j])
    从总结上来看，发现f[k]只可能与f[k−1]有关。
    */

    static final int N = 210,INF = 9999;
    static int n,m,k;
    static int[][] adjacencyMatrix = new int[N][N];
    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static int nextInt() throws Exception{
        in.nextToken();
        return (int)in.nval;
    }
    static String next()throws Exception{
        in.nextToken();
        return in.sval;
    }

    static void floyd(){
        for(int k = 1; k <=n; k++) {
          for(int i = 1; i <=n; i++) {
              for(int j = 1; j <=n; j++) {
                  adjacencyMatrix[i][j] = Math.min(adjacencyMatrix[i][j],adjacencyMatrix[i][k]+adjacencyMatrix[k][j]);
              }
          }
        }
    }

    public static void main(String[] args) throws Exception {
        n = nextInt();
        m = nextInt();
        k = nextInt();
        for(int i = 1; i <=n; i++) {
            for(int j = 1; j <=n; j++) {
                if (i == j) {
                    adjacencyMatrix[i][j] = 0;
                }else {
                    adjacencyMatrix[i][j] = INF;
                }
            }
        }
        while (m-- > 0) {
            int a = nextInt();
            int b = nextInt();
            int c =nextInt();
            adjacencyMatrix[a][b] = Math.min(adjacencyMatrix[a][b],c);
            adjacencyMatrix[b][a] = adjacencyMatrix[a][b];
//--------------------无向图----------------------------------
//            adjacencyMatrix[a][b] = adjacencyMatrix[b][a];
//-----------------------------------------------------------
        }
        //        打印邻接矩阵
//        for(int i = 1; i <=n; i++) {
//            for(int j = 1; j <=n; j++) {
//                System.out.printf("%7d",adjacencyMatrix[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println("------------------------------------");
        floyd();
        while (k-- > 0) {
            int x = nextInt(),y = nextInt();
            if (adjacencyMatrix[x][y]>INF/2){
                System.out.println("impossible");
            }else {
                System.out.println(adjacencyMatrix[x][y]);
            }
        }
//        打印邻接矩阵
//        for(int i = 1; i <=n; i++) {
//            for(int j = 1; j <=n; j++) {
//                System.out.printf("%7d",adjacencyMatrix[i][j]);
//            }
//            System.out.println();
//        }

    }

}
