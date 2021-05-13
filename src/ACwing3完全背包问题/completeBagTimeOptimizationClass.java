package ACwing3完全背包问题;

/**
 * @see 完全背包问题 https://www.acwing.com/problem/content/3/
 */
import java.util.Scanner;

public class completeBagTimeOptimizationClass {
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
        /**
         * 时间优化的原理：
         * 把枚举数量的一层循环去掉，等价于：
         * dp[i][j]= max(dp[i - 1][j], dp[i - 1][j - v] + w, dp[i - 1][j - 2 * v] + 2 * w, dp[i - 1][j - 3 * v] + 3 * w);
         * 而，列举后发现：
         * dp[i][j - v] = max(dp[i - 1][j - v], dp[i - 1][j - 2 * v] + w, dp[i - 1][j - 3 * v] + 2 * w, .....);
         * 发现dp[i][j - v]+ w 与 dp[i][j]= max(dp[i - 1][j],...) 中的...完全相等，因此用dp[i][j - v]+w代换...后得 ：
         * dp[i][j] = max(dp[i - 1][j], dp[i][j - v] +w)；
         */
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < bagVolume; j++) {
                dp[i][j] = dp[i-1][j];
                if (j>=volume[i]){
                    dp[i][j] = Math.max(dp[i][j],dp[i][j-volume[i]]+worth[i]);
                }
            }
        }
        System.out.println(dp[n][bagVolume]);
    }

}
