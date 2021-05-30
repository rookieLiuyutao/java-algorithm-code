package Acwing870单调栈_单调栈模板;


import java.util.Scanner;

/**
 * @see 单调栈 https://www.luogu.com.cn/problem/P5788
 * 求一个数右侧离它最近，且比它大的数，如果没有返回-1
 *
 */

public class monotonicStack5Class {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        int[] res = new int[n + 1];
        int[] stk = new int[n + 1];
        int tt =0;
        for(int i = 1; i <=n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = n;i>0;i--){
            while (tt !=-1&&arr[i]>stk[tt]){
                tt--;
            }
            res[i] = tt==-1?-1:stk[tt];
            stk[++tt] = arr[i];
        }
        for(int i = 1; i <=n; i++) {
            System.out.print(res[i]+" ");
        }




    }



}
