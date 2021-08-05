package Acwing875快速幂;

import java.io.*;

/**
 * https://www.acwing.com/problem/content/description/877/
 */
public class FastPower {

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
    static int qmi(int a, int b, int p) {
        int res = 1 % p;
        while (b != 0) {
            if ((b & 1) == 1) {
                res = (int) (res * (long) a % p);
            }
            a = (int) (a * (long) a % p);
            b>>=1;
        }
        return res;
    }

    public static void main(String[] args)throws Exception {
        int n = nextInt();
        while (n-- > 0) {
            int a = nextInt(),b = nextInt(),p = nextInt();
            out.println(qmi(a,b,p));
        }
        out.flush();
    }

}
