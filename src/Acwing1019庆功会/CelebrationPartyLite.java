package Acwing1019庆功会;

import java.util.Scanner;

/**
 * http://ybt.ssoier.cn:8088/problem_show.php?pid=1269
 */
public class CelebrationPartyLite {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt(),m = sc.nextInt();
        int []dp = new int[m+1];
        while (n-- > 0) {
            int v = sc.nextInt(),w = sc.nextInt(),s = sc.nextInt();
            for(int i = 1; i <=s; i++) {
              for (int j = m;j>=v;j--){
                  dp[j] = Math.max(dp[j],dp[j-v]+w );
              }
            }
        }
        System.out.println(dp[m]);
    }

}
