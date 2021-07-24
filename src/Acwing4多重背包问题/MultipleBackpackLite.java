package Acwing4多重背包问题;

import java.util.Scanner;

public class MultipleBackpackLite {

    static Scanner sc = new Scanner(System.in);
    static int n,t,v,w,s;
    static int []dp = new int[1005];

    public static void main(String[] args) {
        n = sc.nextInt();
        t = sc.nextInt();
        while (n-- > 0) {
            v = sc.nextInt();w = sc.nextInt();s = sc.nextInt();
            for(int i = 1; i <=s; i++) {
                for(int j = t; j >=w; j--) {
                    dp[j] = Math.max(dp[j],dp[j-v]+w);
                }
            }
        }
        System.out.println(dp[t]);
    }

}
