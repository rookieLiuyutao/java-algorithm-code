package Acwing3956截断数组;

import java.io.*;

/**
 * https://www.acwing.com/problem/content/3959/
 */
public class CutDownArry {

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
        int n = nextInt();
        int[] sum = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            sum[i] = nextInt();
            sum[i] = sum[i - 1];
        }

        long res = 0;
        if (sum[n] % 3 != 0) {
            System.out.println(res);
            return;
        }
        for (int i = 3,j = 0; i <= n; i++) {
            if (sum[i - 2] == sum[n] / 3) {
                j++;
            }
            if (sum[n]-sum[i-1]==sum[n]/3){
                res = j;
            }
        }
        System.out.println(res);
    }

}
