package Acwing886求组合数II;

import java.io.*;

/**
 * https://www.acwing.com/problem/content/888/
 */
public class FindTheNumberOfCombinationsII {

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

    static final int MOD = (int) 1e9 + 7, N = 100010;
    static int[] f = new int[N], inf = new int[N];

    static int qmi(int a, int b) {
        int res = 1 % MOD;
        while (b != 0) {
            if ((b & 1) == 1) {
                res = (int) (res * (long) a % MOD);
            }
            a = (int) (a * (long) a % MOD);
            b>>=1;
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        f[0] = inf[0] = 1;
        for (int i = 1; i < N; i++) {
            f[i] = Math.toIntExact((long) f[i - 1] * i % MOD);
            inf[i] = Math.toIntExact((long) inf[i - 1] * qmi(i, MOD - 2) % MOD);
        }
        int n = nextInt();
        while (n-- > 0) {
            int a = nextInt(), b = nextInt();
            System.out.println((long) f[a] * inf[b] % MOD * inf[a - b] % MOD);
            System.out.println(qmi(2,10));
        }
    }

}
