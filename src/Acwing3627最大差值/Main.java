package Acwing3627最大差值;

import java.io.*;
import java.util.Arrays;

/**
 * @see 模拟 https://www.acwing.com/problem/content/3630/
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
        int x = nextInt();
        while (x-- > 0) {
            int n = nextInt();
            int k = nextInt();
            int[] arr = new int[n];
            long res = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            Arrays.sort(arr);
            int i = n-1;
            while (k-- >= 0) {
                res+=arr[i];
                i--;
            }
            out.println(res);
        }
        out.flush();

    }
}
