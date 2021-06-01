package Acwing849朴素版Dijkstra求最短路_最短路模板;

import java.io.*;

public class Dijkstra2 {
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

        for(int i = 1; i <=n; i++) {
            for(int j = 1; j <=n; j++) {
                adjacencyMatrix[i][j] = nextInt();
            }
        }


        int t = dijkstra();
        for(int i = 0; i <=n; i++) {
            for(int j = 0; j <=n; j++) {
                System.out.print(adjacencyMatrix[i][j]+ " ");
            }
            System.out.println();
        }

        System.out.println(t);
//        System.out.println(Arrays.toString(dist));

    }
}

