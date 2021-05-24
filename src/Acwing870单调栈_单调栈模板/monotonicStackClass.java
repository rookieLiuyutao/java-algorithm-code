package Acwing870单调栈_单调栈模板;

import java.util.Scanner;

/**
 * @see 单调栈 https://www.luogu.com.cn/problem/P5788
 */
public class monotonicStackClass {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] stk = new int[n+1];
        int[] arr = new int[n+1] ;
        int[]   res = new int[n+1];
        int tt = 0;
        for(int i = 1; i <=n; i++) {
          arr[i] = sc.nextInt();
        }

        for(int i = n; i >=1; i--) {
          while (tt>0&&arr[stk[tt]]<=arr[i]){
              tt--;
          }
            res[i] = stk[tt];
          stk[++tt] = i;
        }
        for(int i = 1; i <=n; i++) {
            System.out.print(res[i]+" ");
        }
    }

}
