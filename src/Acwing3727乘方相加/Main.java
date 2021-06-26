package Acwing3727乘方相加;

import java.io.*;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @see https://www.acwing.com/problem/content/3730/
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

    static final long N = (long) 10e16;


    public static void main(String[] args)throws Exception {
        int t = nextInt();
        while (t-->0) {
            int n = nextInt();
            int k = nextInt();
             long[] arr = new long[n];
            for(int i = 0; i <n; i++) {
                int res = 0;
              int x = nextInt();
                while (x > 0) {
                    res+=x%k;
//                    if ()
//                    x/=k;

                }
            }



        }

    }


}
