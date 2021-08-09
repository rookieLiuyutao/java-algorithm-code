package Acwing885求组合数I;

import java.io.*;
import java.util.Scanner;

public class FindTheNumberOfCombinations {

    static final int N = 10005,MOD = (int)1e9+7;
    static int [][]c = new int[N][N];
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


    public static void main(String[] args)throws Exception {
        for(int i = 1; i <=N; i++) {
            for(int j = 0; j <=N; j++) {
                if (j == 0) {
                    c[i][j] = 1;
                }else {
                    c[i][j] = (c[i-1][j]+c[i-1][j-1])%MOD;
                }
            }
        }
        int n = nextInt();
        while (n-- > 0) {
            int a = nextInt(),b = nextInt();
            out.println(c[a][b]);
        }
        out.flush();
    }

}
