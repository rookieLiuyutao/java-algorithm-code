package Acwing1275最大数;

import java.io.*;

/**
 * https://www.luogu.com.cn/problem/P1198
 */
public class MaximumNumber {
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
    static final int N = 200010;
    static class Node{
        int l,r,v;

        public Node(int l, int r) {
            this.l = l;
            this.r = r;
        }

        public Node(int l, int r, int v) {
            this.l = l;
            this.r = r;
            this.v = v;
        }
    }

}
