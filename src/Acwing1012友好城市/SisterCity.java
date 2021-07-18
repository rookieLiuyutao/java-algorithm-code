package Acwing1012友好城市;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
/**
 * @see 线性dp 最长上升子序列
 * https://www.luogu.com.cn/problem/P2782
 */
public class SisterCity {
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

    static int [][] city;
    static int []dp;
    static int n;

    public static void main(String[] args)throws Exception {
        n  = nextInt();
        city = new int[n][2];
        dp  = new int[n];
        int res = 1;
        for(int i = 0; i <n; i++) {
          city[i][0] = nextInt();
          city[i][1] = nextInt();
        }
        Arrays.sort(city, Comparator.comparingInt(o->o[0]));
        for (int []i:city){
            System.out.println(Arrays.toString(i));
        }
        for(int i = 0; i <n; i++) {
          dp[i] = 1;
          for(int j = 0; j <i; j++) {
            if (city[i][1]>city[j][1]){
                dp[i] = Math.max(dp[i],dp[j]+1);
            }
          }
          res = Math.max(res,dp[i]);

            System.out.println(Arrays.toString(dp));
        }
        out.println(res);
        out.flush();
    }


}
