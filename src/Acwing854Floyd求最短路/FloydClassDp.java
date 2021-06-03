package Acwing854Floyd求最短路;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class FloydClassDp {
    static final int N = 210,INF = 9999;
    static int n,m,k;
    static int[][] adjacencyMatrix = new int[N][N];
    static int[][] dp  = new int[N][N];
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
//            adjacencyMatrix[a][b] = adjacencyMatrix[b][a];
        }
        //        打印邻接矩阵
        for(int i = 1; i <=n; i++) {
            for(int j = 1; j <=n; j++) {
                System.out.printf("%7d",adjacencyMatrix[i][j]);
            }
            System.out.println();
        }
        System.out.println("------------------------------------");
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
        for(int i = 1; i <=n; i++) {
            for(int j = 1; j <=n; j++) {
                System.out.printf("%7d",adjacencyMatrix[i][j]);
            }
            System.out.println();
        }

    }

}
