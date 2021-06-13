package Axwing3661重置数列;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @see https://www.acwing.com/problem/content/3664/
 */
public class Main {
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
    static int t,n,k;
    static int []arr;
    public static void main(String[] args) throws Exception {
        t = nextInt();
        while (t-- > 0) {
            n = nextInt();
            k = nextInt();
            arr = new int[n+1];
            for(int i = 0; i <=n; i++) {
                arr[i] = nextInt();
            }
            int res = n;
            for(int i = 1; i <=100; i++) {
                int count = 0;
                for(int j = 0; j <n; j++) {
                    if (arr[j] != i) {
                        count++;
                        j+=k-1;
                    }
                }
                res = Math.min(res,count);
            }
            out.println(res);
        }
        out.flush();
    }

}
