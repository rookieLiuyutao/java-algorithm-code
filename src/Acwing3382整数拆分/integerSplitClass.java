package Acwing3382整数拆分;

import java.util.Scanner;

/**
 * @see 整数拆分 https://www.acwing.com/problem/content/3385/
 * 1≤N≤10^6
 */
public class integerSplitClass {
    static int n;
    static int N = 1000010,MOD = (int) 1e9;
    static int[] dp = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp[0]  = 1;
        for(int i = 1; i <= n; i*=2) {
            for(int j = i; j <= n; j++) {
                    dp[j] = (dp[j] + dp[j - i]) % MOD;
            }

        }
        System.out.println(dp[n]);
    }



}
