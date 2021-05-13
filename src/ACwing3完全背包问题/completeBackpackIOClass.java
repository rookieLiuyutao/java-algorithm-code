package ACwing3完全背包问题;

import java.util.Scanner;

/**
 * @see 完全背包问题 https://www.acwing.com/problem/content/3/
 */

public class completeBackpackIOClass {
    static int N = 1010;
    static int n, bagVolume;
    static int[] volume = new int[N];
    static int[] worth = new int[N];
    static int[][] dp = new int[N][N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        bagVolume = sc.nextInt();
        //一定要注意，输入输出版的背包问题，2个数组都是从第二个数开始填入的
        for (int i = 1; i <= n; i++) {
            volume[i] = sc.nextInt();
            worth[i] = sc.nextInt();
        }

        for(int i = 1; i <= n; i++)
            for(int j = 0; j <= bagVolume; j++)
                for (int k = 0;k*volume[i]<=j;k++)
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-k*volume[i]]+worth[i]);
        System.out.println(dp[n][bagVolume]);

    }

}
