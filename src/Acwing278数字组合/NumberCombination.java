package Acwing278数字组合;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/280/
 */
public class NumberCombination {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int []dp = new int[m+1];
        dp[0] = 1;
        for(int i = 1; i <=n; i++) {
          int v = sc.nextInt();
          for (int j = m;j>=0;j--){
              dp[j]+=dp[j-v];
          }
        }
        System.out.println(dp[m]);
    }


}
