package Acwing95费解的开关;

import java.io.*;

/**
 * @see 递推 https://www.acwing.com/activity/content/19/
 */
public class InexplicableSwitch {
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

    static final int N = 6;
    static char[][]g = new char[N][N],temp = new char[N][N];


}
