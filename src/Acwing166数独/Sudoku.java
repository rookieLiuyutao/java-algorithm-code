package Acwing166数独;


import java.io.*;

public class Sudoku {
    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static int nextInt() throws Exception {
        in.nextToken();
        return (int) in.nval;
    }

    static String next() throws Exception {
        in.nextToken();
        return in.sval;
    }

    static final int N = 9, M = 1 << N;
    static char[] g;
    static int[] row = new int[N], col = new int[N], ones = new int[M], map = new int[M];
    static int[][] cell = new int[3][3];
    static void draw(int x,int y,boolean isSet){

    }

    public static void main(String[] args) throws Exception {
        //预处理log2n
        for (int i = 0; i < N; i++) {
            map[1 << i] = i;
        }
        //预处理每个数有多少个1
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ones[i] += i >> j & 1;
            }
        }
        while (true) {
            String str = next();
            if ("end".equals(str)) {
                break;
            }
            g = str.toCharArray();
            for (int i = 0; i < N; i++) {
                row[i] = col[i] = (1 << N) - 1;
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    cell[i][j] = (1 << N) - 1;
                }
            }

        }
    }


}
