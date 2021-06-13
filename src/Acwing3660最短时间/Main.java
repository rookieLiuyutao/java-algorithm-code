package Acwing3660最短时间;

import java.io.*;

/**
 * @see https://www.acwing.com/problem/content/3663/
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

    static int n,m,r,c,t;


    public static void main(String[] args)throws Exception {
        t = nextInt();
        while (t-- > 0) {
            n = nextInt();
            m = nextInt();
            r = nextInt();
            c = nextInt();

            int res = Math.max(Math.abs(n-r),r-1)+Math.max(Math.abs(m-c),c-1);
            out.println(res);


        }
        out.flush();
    }
}
