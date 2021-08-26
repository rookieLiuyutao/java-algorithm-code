package Acwing827双链表;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/832/
 */
public class MonotonicStack {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        int []a = new int[n+1];
        int []stk = new int[n+1];
        int tt = 0;
        for(int i = 0; i <n; i++) {
            int x = sc.nextInt();
            while (tt>0&x>=stk[tt]){
                tt--;
            }
            if (tt>0){
                System.out.print(stk[tt]+" ");
            }else {
                System.out.print(-1+" ");
            }
            stk[++tt] = x;
        }
    }

}
