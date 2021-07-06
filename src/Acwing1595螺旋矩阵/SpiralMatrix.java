package Acwing1595螺旋矩阵;

import java.io.*;
import java.util.Arrays;

/**
 * @see 递归 dfs https://www.acwing.com/problem/content/1597/
 */
public class SpiralMatrix {
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

    static int []arr;
    static int n;

    public static void main(String[] args)throws Exception {
        n = nextInt();
        arr = new int[n];
        for(int i = 0; i <n; i++) {
          arr[i] = nextInt();
        }
        Arrays.sort(arr);

    }

}
