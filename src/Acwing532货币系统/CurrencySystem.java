package Acwing532货币系统;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/534/
 * 完全背包 线性空间
 */
public class CurrencySystem {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int []a = new int[n];
            for(int i = 0; i <n; i++) {
              a[i] = sc.nextInt();
            }

            Arrays.sort(a);
            int top = a[n-1];
            int res = 0;
            int []dp = new int[top+1];
            dp[0] = 1;
            for(int i = 0; i <n; i++) {
              if (dp[a[i]]!=0){
                  res++;
              }
              for(int j = a[i]; j <=top; j++) {
                dp[j] += dp[j-a[i]];
              }
            }
            System.out.println(res);
        }
    }

}
