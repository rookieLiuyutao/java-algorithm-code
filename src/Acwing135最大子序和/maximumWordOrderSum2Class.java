package Acwing135最大子序和;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @see 前缀和 单调队列 https://www.acwing.com/problem/content/description/137/
 * 用数组模拟双端队列
 */

public class maximumWordOrderSum2Class {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] sum = new int[n + 1];
        int []q = new int[n+1];

        for (int i = 1; i <= n; i++) {
            int x = sc.nextInt();
            sum[i] += sum[i - 1] + x;
        }

        int res = Integer.MIN_VALUE;

//---------------------暴力方法-------------------------
//        for(int i = 1; i <=n; i++) {
//            for(int len = 1; len <=m; len++) {
//                if (i-len>=0){
//                    res = Math.max(res,sum[i]-sum[i-len]);
//                }
//            }
//        }
//--------------------------------------------------------------
        int hh = 0,tt=0;
        for(int i = 1; i <=n; i++) {
          if (i-q[tt]>m){
              hh++;
          }
            res = Math.max(res,sum[i]-sum[q[hh]]);

            while (hh<=tt&&sum[i]<=sum[q[tt]]){
              tt--;
          }
          q[++tt] = i;

        }
        System.out.println(res);
    }

}
