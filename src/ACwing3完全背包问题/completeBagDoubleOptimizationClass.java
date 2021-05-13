package ACwing3完全背包问题;

import java.util.Scanner;

public class completeBagDoubleOptimizationClass {
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
        /**
         * 空间优化：
         * 按照对01背包问题优化的思路，在时间优化版本的基础上，进行空间优化
         * 仔细观察 完全背包问题的最终优化版，和01背包问题非常相似
         * 唯一的不同就是内层循环的遍历顺序
         * 实际上01背包从大到小就是使用上一行的状态更新。完全背包是使用当前行的状态更新，因为当前物品有无限个
         * 如果01背包不倒着来，就相当于本来只能用1次的物品可以多次使用了
         */
        for (int i = 1; i < n; i++) {
            for (int j = volume[i]; j < bagVolume; j++) {
                dp[j] = Math.max(dp[j], dp[j - volume[i]] + worth[i]);
            }
        }
        System.out.println(dp[bagVolume]);
    }


}
