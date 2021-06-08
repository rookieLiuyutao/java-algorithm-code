package Acwing3636数组延伸;

import java.io.*;
import java.util.ArrayList;

/**
 * @see x https://www.acwing.com/problem/content/3639/
 */
public class Main {
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
        int T = nextInt();
        while (T-- > 0) {
            int n = nextInt();
            int x = nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            boolean dontHasJi = true;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int m = nextInt();
                list.add(m);
                sum += m;
            }
            for (int i = 0; i < list.size(); i++) {
                int m = list.get(i);
                if (dontHasJi) {
                    while (m % x == 0) {
                        m /= x;
                        sum += list.get(i);
                    }
                    if (list.get(i) % x != 0) {
                        continue;
                    }
                    if (list.get(i) % x == 0 && m != 1) {
                        dontHasJi = false;
                    }
                } else {
                    if (m % x == 0) {
                        sum += list.get(i);
                    }
                }


            }


            out.println(sum);
        }
        out.flush();
    }
}
