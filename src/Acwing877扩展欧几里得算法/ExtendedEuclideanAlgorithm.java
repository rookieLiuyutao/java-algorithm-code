package Acwing877扩展欧几里得算法;

import java.io.*;

/**
 * https://www.acwing.com/problem/content/879/
 */
public class ExtendedEuclideanAlgorithm {

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
    static int x,y;

    static int exgcd(int a,int b){
        if (b == 0) {
            x = 1;
            y = 0;
            return a;
        }
        int d = exgcd(b,a%b);
        int t = x;
        x = y;
        y = t-a/b*y;
        return d;
    }

    public static void main(String[] args)throws Exception {
        int n = nextInt();
        while (n-- > 0) {
            int a = nextInt(),b = nextInt();
            int d = exgcd(a,b);
            out.println(x+" "+y);
        }
        out.flush();
    }
}
