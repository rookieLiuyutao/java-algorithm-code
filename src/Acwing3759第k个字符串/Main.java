package Acwing3759第k个字符串;

import java.io.*;

/**
 * https://www.acwing.com/problem/content/3762/
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

    public static void main(String[] args)throws Exception {

//        System.out.println(sum[]);
        int T = nextInt();
        while (T-->0){
            int n = nextInt();
            int k = nextInt();
            char[]ans = new char[n];

            for(int i = n-1; i >0; i--) {
              if (k>n-i){
                  k-=n-i;
              }else {
                  for(int j = 0; j <n; j++) {
                      ans[j] = 'a';
                  }
                  ans[i-1] = ans[n-k] = 'b';
                  for(int j = 0; j <n; j++) {
                      System.out.print(ans[j]);
                  }
                  System.out.println();
                  break;
              }
            }

        }

    }

}
