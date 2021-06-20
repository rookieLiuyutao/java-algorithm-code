package Acwing3695扩充序列;

import java.io.*;

/**
 * @see  https://www.acwing.com/problem/content/3698/
 */
public class Main {
        static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        static PrintWriter  out = new PrintWriter(new OutputStreamWriter(System.out));
        static int nextInt() throws Exception{
            in.nextToken();
            return (int)in.nval;
        }
        static String next()throws Exception{
            in.nextToken();
            return in.sval;
        }

    static int n,k;


    public static void main(String[] args)throws Exception {
         n = nextInt();
         k  = nextInt();
        int count = 0;
        if ((k-1)%2 == 0){
            out.println(1);
        }else {


        }

        out.flush();
        out.close();
    }

}
