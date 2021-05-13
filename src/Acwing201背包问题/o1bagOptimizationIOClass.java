package Acwing201背包问题;
/**
 * @see Acwing 01背包问题 https://www.acwing.com/problem/content/2/
 */

import java.util.Scanner;

public class o1bagOptimizationIOClass {
    /**
     * n 为物品的数量
     * bagVolume 为背包的体积
     * volume[] 存储每个物品的体积
     *  worth[] 存储每个物品的价值
     */
    static int N = 1010;
    static int n, bagVolume;
    static int[] volume = new int[N];
    static int[] worth = new int[N];
    static int[] dp = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        bagVolume = sc.nextInt();
        //一定要注意，输入输出版的背包问题，2个数组都是从第二个数开始填入的
        for (int i = 1; i <= n; i++) {
            volume[i] = sc.nextInt();
            worth[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            //dp[i][j] = dp[i-1][j];优化过后为恒等式，直接去掉
            for (int j = bagVolume; j >= volume[i]; j--) {
                //if语句合并入for循环内
                //dp[i][j] = Math.max(dp[i][j],dp[i-1][j-volume[i]]+worth[i]);
                //优化掉一维后为dp[j] = Math.max(dp[j],dp[j-volume[i]]+worth[i]);
                //因为dp[j] 必须比 dp[j-volume[i]] 要后计算出，所以采用倒序遍历
                dp[j] = Math.max(dp[j], dp[j - volume[i]] + worth[i]);
            }
        }
        System.out.println(dp[bagVolume]);
    }
}
