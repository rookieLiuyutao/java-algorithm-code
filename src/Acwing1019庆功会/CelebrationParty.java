package Acwing1019庆功会;

import java.util.Scanner;

/**
 * http://ybt.ssoier.cn:8088/problem_show.php?pid=1269
 */
public class CelebrationParty {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt(),m = sc.nextInt();
        int []dp = new int[m+1];
        while (n-- > 0) {
            int v = sc.nextInt(),w = sc.nextInt(),s = sc.nextInt();
            for (int j = m;j>=0;j--){
                for(int k = 0; k *v<=j&&k<=s; k++) {
                  dp[j] = Math.max(dp[j ],dp[j-k*v]+k*w );
                }
            }
        }
        System.out.println(dp[m]);
    }

}
