package Acwing152城市游戏_单调栈模板;

import java.io.*;
import java.util.Arrays;

/**
 * @see 单调栈 https://www.acwing.com/problem/content/154/
 */
public class cityGameClass {
    static int n,m;
    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter  out = new PrintWriter(new OutputStreamWriter(System.out));
    static int nextInt() throws Exception{
        in.nextToken();
        return (int)in.nval;
    }
    static String nextLine()throws Exception{
        in.nextToken();
        return in.sval;
    }
    static int work(int[] height){
        int[] widthArr = new int[n + 2];
        int[] q = new int[n + 2];
        int tt;
        long res = 0;
        tt = height[m + 1] = 0;
        for (int i = 1; i <= m + 1; i++) {
            if (height[i] > q[tt]) {
                q[++tt] = height[i];
                widthArr[tt] = 1;
            } else {
                int width = 0;
                while (height[i] < q[tt]) {
                    width += widthArr[tt];
                    res = Math.max(res, (long) width * q[tt]);
                    tt--;
                }
                q[++tt] = height[i];
                widthArr[tt] = width + 1;
            }
        }
        return (int) res;
    }
    public static void main(String[] args) throws Exception {
         n = nextInt();
         m = nextInt();
        char[][] land = new char[n+1][m+1];
        int [][] height = new int[n+2][m+2];
        for(int i = 1; i <=n; i++) {
          for(int j = 1; j <=m; j++) {
            land[i][j] = nextLine().charAt(0);
            char c= land[i][j];
            if (c=='F'){
                height[i][j] = height[i-1][j]+1;
            }else {
                height[i][j]= 0;
            }
          }
        }
//        for (char[] x:land){
//            System.out.println(Arrays.toString(x));
//        }
        int res = 0;
        for(int i = 1; i <=n; i++) {
            res = Math.max(res,work(height[i]));
        }
        System.out.println(res*3);
    }

}
