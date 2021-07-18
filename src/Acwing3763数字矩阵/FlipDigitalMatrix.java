package Acwing3763数字矩阵;

import java.io.*;

/**
 * https://www.acwing.com/problem/content/3766/
 */
public class FlipDigitalMatrix {
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

    public static void main(String[] args) throws Exception {
        int t = nextInt();
        while (t-- > 0) {
            int n = nextInt();
            int m = nextInt();
            int count = 0, sum = 0, minV = 2000;
            for (int i = 0; i < n * m; i++) {
                int x = nextInt();
                if (x < 0) {
                    count++;
                }
                sum += Math.abs(x);
                minV = Math.min(minV, Math.abs(x));
            }
            if (count % 2 == 0) {
                out.println(sum);
            } else {
                out.println(sum - 2 * minV);
            }
        }
        out.flush();
    }

}
