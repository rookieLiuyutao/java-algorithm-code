package AcWing893集合_Nim游戏;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

public class NimGame {

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

    static int[] s, f;
    static int n, m;

    static int sg(int x) {
        if (f[x] != -1) {
            return f[x];
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            int sum = s[i];
            if (x > sum) {
                set.add(sg(x - sum));
            }
        }
        for (int i = 0; ; i++) {
            if (!set.contains(i)) {
                return f[x] = i;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        m = nextInt();
        s = new int[m + 1];
        for (int i = 0; i < m; i++) {
            s[i] = nextInt();
        }
        n = nextInt();
        f = new int[10010];
        Arrays.fill(f, -1);
        int res = 0;
        for (int i = 0; i < n; i++) {
            int x = nextInt();
            res ^= sg(x);
        }
        if (res == 0) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }

    }

}
