package Acwing896最长上升子序列II;

import java.io.*;

/**
 * https://www.acwing.com/problem/content/description/898/
 */
public class LengthOfLISII {
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
    static final int N = 100010;
    static int []s = new int[N],a = new int[N];

    public static void main(String[] args)throws Exception {
        int n = nextInt();

        int res = 0;
        for(int i = 0; i <n; i++) {
          int l = 0,r = res;
          while (l<r){
              int mid = l+r+1;
              if (s[mid]<a[i]){
                  l = mid;
              }else {
                  r = mid-1;
              }
          }
          s[l+1] = a[i];
          res = Math.max(res,s[l+1]);
        }
        System.out.println(res);
    }

}
