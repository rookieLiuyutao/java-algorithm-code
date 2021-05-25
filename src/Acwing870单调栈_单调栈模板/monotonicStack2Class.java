package Acwing870单调栈_单调栈模板;
/**
 * @see 单调栈 https://www.acwing.com/solution/content/2248/
 */

import java.util.Scanner;

public class monotonicStack2Class {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] stk = new int[n + 1];
        int tt = -1;


        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            while (tt != -1 && stk[tt] > x) {
                tt--;
            }
            if (tt == -1) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(stk[tt] + " ");
            }
            stk[++tt] = x;
        }

    }


}
