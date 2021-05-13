package leetcode1723完成所有工作的时间;

/**
 * @see 状态压缩dp  https://leetcode-cn.com/problems/find-minimum-time-to-finish-all-jobs/
 */
public class minimumTimeRequiredClass {
    /**
     * 集合：f[i][j]表示给前 i个人分配工作，工作的分配情况为 j时，完成所有工作的最短时间。
     * 集合划分：给第i个工人分配某个工作；给第i个工人不分配此工作，最长时间就为上个人的最小完成时间
     * 属性：min
     * 注意这里的 j 是一个二进制整数，表示了工作的分配情况。实际上我们也可以将 j看作一个集合，包含了已经被分配的工作。
     * 状态压缩dp是用二进制 去“打包”
     *
     * @param jobs 每个任务要花费的时间
     * @param k    任务要分配给k个工人
     * @return
     */
    public static int minimumTimeRequired(int[] jobs, int k) {
        int n = jobs.length;
        //1<<n表示2的n次方
        int range = 1 << n;
        //用sum数组统计一个工人的所有任务分配方式的每个时间
        int[] sum = new int[range];
        for (int i = 1; i < (range); i++) {
            //numberOfTrailingZeros是返回二进制数中尾部(低位)0的个数
            int x = Integer.numberOfTrailingZeros(i), y = i - (1 << x);
            sum[i] = sum[y] + jobs[x];

        }
//        System.out.println(Arrays.toString(sum));
        int[][] dp = new int[k][range];
        for (int i = 0; i < (range); i++) {
            dp[0][i] = sum[i];
        }

        //dp过程
        for (int i = 1; i < k; i++) {
            for (int j = 0; j < (range); j++) {
                int minN = Integer.MAX_VALUE;
                for (int x = j; x != 0; x = (x - 1) & j) {
                    minN = Math.min(minN, Math.max(dp[i - 1][j - x], sum[x]));
                }
                dp[i][j] = minN;
            }
        }
//        for(int i = 0; i <k; i++) {
//            for(int j = 1; j <range; j++) {
//                System.out.printf("%13d",dp[i][j]);
//            }
//            System.out.println();
//        }
        return dp[k - 1][range - 1];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 8};
        minimumTimeRequired(arr, 2);
    }

}
