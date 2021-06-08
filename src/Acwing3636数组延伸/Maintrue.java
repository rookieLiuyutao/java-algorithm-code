package Acwing3636数组延伸;

import java.io.*;

public class Maintrue {
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
    static int [] w = new int[100010];
    public static void main(String[] args) throws Exception {
        int T = nextInt();
        while (T -->0 )
        {
            int n = nextInt();
            int x = nextInt();
            for (int i = 0; i < n; i ++ ){
                w[i] = nextInt();
            }

            long sum = 0, psum = 0;
            int cnt = 100010;
            for (int i = 0; i < n; i ++ )
            {
                sum += w[i];
                int c = 0;
                for (int j = w[i]; j % x == 0; j /= x) {
                    c ++ ;
                }
                if (c < cnt)
                {
                    cnt = c;
                    psum = sum - w[i];
                }
            }
            out.println(sum * (cnt + 1) + psum);
        }


        out.flush();
    }


}
