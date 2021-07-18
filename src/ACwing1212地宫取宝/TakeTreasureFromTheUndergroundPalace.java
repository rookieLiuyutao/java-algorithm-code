package ACwing1212地宫取宝;

import java.io.*;

/**
 * 动态规划 dp
 *https://www.acwing.com/problem/content/description/1214/
 */
public class TakeTreasureFromTheUndergroundPalace {

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
    static final int N = 55;
    static final long MOD = (long) 10e9+7;
    static int [][]dp  = new int[N][N];
    static int [][]val = new int[N][N];

    public static void main(String[] args)throws Exception {
        int n = nextInt(),m = nextInt(),k = nextInt();
        for(int i = 1; i <=n; i++) {
            for(int j = 1; j <=m; j++) {
                val[i][j] = nextInt();
            }
        }

    }

}
