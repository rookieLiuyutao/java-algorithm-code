package Acwing1021货币系统;

import java.util.Scanner;

/**
 * http://ybt.ssoier.cn:8088/problem_show.php?pid=1273
 */
public class CurrencySystem {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt(),m = sc.nextInt();
        int []dp = new int[m+1];
        dp[0] = 1;
        for(int i = 0; i <n; i++) {
          int v = sc.nextInt();
          for(int j = m; j >=v; j--) {
            dp[j] += dp[j-v];
          }
        }
        System.out.println(dp[m]);
    }

}
