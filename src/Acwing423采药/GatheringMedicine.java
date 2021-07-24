package Acwing423采药;

import java.util.Scanner;

/**
 *https://www.acwing.com/problem/content/425/
 */
public class GatheringMedicine {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt(), m = sc.nextInt();
        int []dp  = new int[t+1];
        for(int i = 1; i <=m; i++) {
          int v = sc.nextInt(),w = sc.nextInt();
          for (int j = t;j>=v;j--){
              dp[j] =  Math.max(dp[j],dp[j-v]+w );
          }
        }
        System.out.println(dp[t]);
    }

}
