package Acwing3795计算abc;

import java.io.*;
import java.util.Arrays;

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
    static Long nextLong() throws Exception{
        in.nextToken();
        return (long)in.nval;
    }

    public static void main(String[] args)throws Exception {
        int []a = new int[4];

        for(int i = 0; i <4; i++) {
          int x = nextInt();
          a[i] = x;
        }
        int m = 3;
        Arrays.sort(a);
        while (m-- > 0) {
            out.print(a[3]-a[m]+ " ");
        }
        out.flush();
    }
}
