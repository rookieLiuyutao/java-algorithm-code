package Acwing1024装箱问题;

import java.util.Scanner;

/**
 * http://ybt.ssoier.cn:8088/problem_show.php?pid=1295
 */
public class PackingProblem {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int m = sc.nextInt(),n = sc.nextInt();
        int []dp = new int[m+1];
        for(int i = 1; i <=n; i++) {
          int v = sc.nextInt();
          for(int j = m; j >=v; j--) {
            dp[j]  = Math.max(dp[j],dp[j-v]+v );
          }
        }
        System.out.println(m-dp[m]);
    }


}
