package Acwing899编辑距离;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/description/901/
 */
public class EditDistance {
    static Scanner sc = new Scanner(System.in);
    static int n,m;

    static int dec(String a,String b){
        int la = a.length();
        int lb = b.length();
         int [][]dp = new int[la+1][lb+1];
         for(int i = 1; i <=la; i++) {
           dp[i][0] = i;
         }
         for(int i = 1; i <=lb; i++) {
           dp[0][i] = i;
         }
         for(int i = 1; i <=la; i++) {
             for(int j = 1; j <=lb; j++) {
                 int x = a.charAt(i-1)!=b.charAt(j-1)? 1:0;
                 dp[i][j] = Math.min(dp[i-1][j-1]+x,Math.min(dp[i-1][j],dp[i][j-1])+1);
             }
         }
        return dp[la][lb];
    }


    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();
        String[]sts = new String[n];
        String []ss;
        for(int i = 0; i <n; i++) {
          sts[i] = sc.next();
        }
        while (m-->0) {
            String x = sc.next();
            int q = sc.nextInt();
            int res = 0;
            System.out.println(x);
            for(int i = 0; i <n; i++) {
                int ans = dec(sts[i],x);
              if (dec(sts[i],x)<=q){
                  res++;
              }
            }
            System.out.println(res);
        }
        System.out.println(Arrays.toString(sts));
    }


}
