package Acwing1012友好城市;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
/**
 * @see 线性dp 最长上升子序列
 * https://www.luogu.com.cn/problem/P2782
 */
public class SisterCity3 {
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
    static int []save,dp;
    static int n;

    public static void main(String[] args)throws Exception {
        n  = nextInt();
        city = new int[n][2];
        save  = new int[n];
        dp = new int[n];
        int res = 0;
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

            int l = 0,r = res;
            while (l < r) {
                int mid = l+r+1>>1;
                if (save[mid]<city[i][1]){
                    l = mid;
                }else {
                    r = mid-1;
                }
            }
            save[l+1] = city[i][1];
            dp[i] = l+1;
            res = Math.max(res,l+1);
            System.out.println(Arrays.toString(save));
            System.out.println(Arrays.toString(dp));
        }

        out.println(res);
        out.flush();
    }


}
