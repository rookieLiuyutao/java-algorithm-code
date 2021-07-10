package ACwing3758距离零点的时刻;

import java.io.*;

/**
 * https://www.acwing.com/problem/content/3761/
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

    public static void main(String[] args) throws Exception {
        int T = nextInt();
        while (T-->0) {
            int hour = nextInt();
            int minute = nextInt();
            int temp = 60-minute;
            int hh = 24-hour;
            System.out.println(temp+hh*60);
        }
        out.flush();
    }

}
