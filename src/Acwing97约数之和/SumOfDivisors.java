package Acwing97约数之和;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/description/99/
 */
public class SumOfDivisors {

    static final int MOD = 9901;
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
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args)throws Exception {
        int a = nextInt();
        int b = nextInt();
        for (int i = 2; i <= a / i; i++) {
            while (a % i == 0) {
                a /= i;
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }
        if (a > 1) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        long res = 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            long t = 1;
            int x = entry.getKey(), y = entry.getValue()*b;
            if (x==1){
                y-=b;
            }
            while (y-- > 0) {
                t = (t * x + 1) % MOD;
            }
            res = res * t % MOD;
        }
        out.println(res);
        out.flush();
    }

}
