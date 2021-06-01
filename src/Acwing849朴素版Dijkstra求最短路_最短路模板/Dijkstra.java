package Acwing849朴素版Dijkstra求最短路_最短路模板;

import java.io.*;
import java.util.Arrays;

/**
 * @see Dijkstra https://www.acwing.com/problem/content/851/
 */
public class Dijkstra {
    //N是点的最大值
    static final int N = 510;
    //n代表图中的点数，m代表图中的边数
    static int n,m;
    static int [][] adjacencyMatrix = new int[N][N];
    //存储源点到每个点的最短距离
    static int [] dist = new int[N];
    //st状态机用来表示当前点的最短路是否已经确定
    static boolean[] st = new boolean[N];

    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    static int nextInt() throws Exception{
        in.nextToken();
        return (int)in.nval;
    }
    static String next()throws Exception{
        in.nextToken();
        return in.sval;
    }

    /**
     * Dijkstra 算法核心函数
     * @return
     */
    static int dijkstra(){
        //初始化
        for(int i = 0; i <=n; i++) {
          dist[i] = 0x3f3f;
        }
        dist[1] = 0;
        for(int i = 0; i <n; i++) {
          int t = -1;
          for(int j = 1; j <=n; j++) {
            if (!st[j]&&(t==-1||dist[t]>dist[j])){
                t=j;
            }
          }
          st[t] = true;
          for(int j = 1; j <=n; j++) {
            dist[j] = Math.min(dist[j],dist[t]+adjacencyMatrix[t][j]);
          }
        }
        return dist[n]==0x3f3f? -1:dist[n];
    }

    public static void main(String[] args) throws Exception {

        n = nextInt();
        m = nextInt();

        //初始化邻接矩阵
//        for (int i = 1; i <= n; i++) {
//            Arrays.fill(adjacencyMatrix[i], 0x3f3f);
//        }
        for(int i = 1; i <=n; i++) {
            for(int j = 1; j <=n; j++) {
                if (i == j) {
                    adjacencyMatrix[i][j] = 0;
                }else {
                    adjacencyMatrix[i][j] = 0x3f3f;
                }
            }
        }

        //因为两个点之间可能有多条边，选择其中的最短边存入邻接矩阵
        while (m-->0){
            int a = nextInt();
            int b = nextInt();
            int c = nextInt();
            adjacencyMatrix[a][b] = Math.min(adjacencyMatrix[a][b],c);
            //如果是无向图，其特点为对称，就要加上下面这一句
//            adjacencyMatrix[b][a] = adjacencyMatrix[a][b];
        }

        int t = dijkstra();
        for(int i = 1; i <=n; i++) {
            for(int j = 1; j <=n; j++) {
                System.out.printf("%7d",adjacencyMatrix[i][j]);
            }
            System.out.println();
        }

        System.out.println(t);
        for(int i = 0; i <=n; i++) {
            System.out.print(dist[i]+" ");
        }

    }
}
