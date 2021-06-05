package Acwing3626三元一次方程;

import java.io.*;

/**
 * @see 哈希表 https://www.acwing.com/problem/content/3629/
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
        int n = nextInt();
        while (n-->0){
            int m = nextInt();
            int count = 0;
            for(int i = 0; i <m; i++) {
                for(int j = 0; j <m; j++) {
                    for(int k = 0; k <m; k++) {
                      int x = 3*i+5*j+7*k;
                      if (x==m){
                          out.println(i+" "+j+" "+k);
                          count++;
                          break;
                      }
                    }
                    if (count==1) break;
                }
                if (count==1) break;
            }
            if (count == 0) {
                out.println(-1);
            }

        }
        out.flush();
    }


}
