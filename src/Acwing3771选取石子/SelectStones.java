package Acwing3771选取石子;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.acwing.com/problem/content/3774/
 */
public class SelectStones {
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

    static Map<Integer, Long> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        int n = nextInt();
        for (int i = 1; i <= n; i++) {
            int x = nextInt();
            if (!map.containsKey(x-i)) {
                map.put(x - i, (long) x);
            }else {
                map.put(x - i, map.get(x - i) + x);

            }

        }
        long res = 0;
        for (int x : map.keySet()) {
            res = Math.max(res, map.get(x));
        }
        System.out.println(res);
    }


}
