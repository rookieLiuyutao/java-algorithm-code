package ccf201412_2Z字形扫描;

import java.io.*;

public class ZigzagScan {

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

    static int n;
    static int[][] g = new int[510][510];

    public static void main(String[] args)throws Exception {
        n = nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                g[i][j] = nextInt();
            }
        }
        for(int i = 2; i <=n*2; i++) {
            if (i%2==0) {
                for(int j = i-1; j >0; j--) {
                  if (j <= n && i - j >= 1 && i - j <= n){
                      out.print(g[j][i-j]+" ");
                  }
                }
            }else {
                for(int j = 1; j <i; j++) {
                    if (j <= n && i - j <= n){
                        out.print(g[j][i-j]+" ");
                    }
                }
            }
        }
        out.flush();
    }

}
