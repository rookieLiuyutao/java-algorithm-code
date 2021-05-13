package leetcode1723完成所有工作的时间;

/**
 * @see 递归剪枝 https://leetcode-cn.com/problems/find-minimum-time-to-finish-all-jobs/solution/gong-shui-san-xie-yi-ti-shuang-jie-jian-4epdd/
 */
public class minimumTimeRequired2Class {
    static int[] sJobs;
    static int n, sK;
    static int res = Integer.MAX_VALUE;

    public static int minimumTimeRequired(int[] jobs, int k) {
        sJobs = jobs;
        n = jobs.length;
        sK = k;
        int[] sum = new int[k];
        dfs(0, 0, sum, 0);
        return res;
    }

    /**
     * @param u    当前处理的job
     * @param used 当前分配给多少个工人
     * @param sum  工人的分配情况
     * @param max  当前的最大工作时间
     */
    static void dfs(int u, int used, int[] sum, int max) {
        if (max > res) return;
        //递归到数组最后一位，递归结束
        if (u == n) {
            res = max;
            return;
        }
        //优先分配给空闲工人
        if (used < sK) {
            sum[used] = sJobs[u];
            dfs(u + 1, used + 1, sum, Math.max(sum[used], max));
            sum[used] = 0;

        }
        for (int i = 0; i < used; i++) {
            sum[i] += sJobs[u];
            dfs(u + 1, used, sum, Math.max(sum[i], max));
            sum[i] -= sJobs[u];
        }

    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 8};
        System.out.println(minimumTimeRequired(arr, 2));
    }
}
