package leetcode403青蛙过河;

/**
 * @see 路径问题 https://leetcode-cn.com/problems/frog-jump/
 *
 */
public class canCrossClass {
    /**
     * @param stones
     * @return
     */
    public static boolean canCross(int[] stones) {
        int n = stones.length;
        boolean[][] dp = new boolean[2010][2010];
        //题目规定：开始时， 青蛙默认已站在第一块石子上，并可以假定它第一步只能跳跃一个单位（即只能从单元格 1 跳至单元格 2 ）。
        //切stones[0]一定为0，所以stones[1]必须为1
        if (stones[1] != 1) return false;
        dp[1][1] = true;

//---------------------------------------------------
        //集合：已经跳到了i位置，是从j位置跳过来的，上一次跳跃的距离是k
        //属性：能否跳到当前位置
        //集合划分：题目已经给出的三种跳跃状态
//--------------------------------------------------------------

        //为什么从i=2开始遍历？：因为数组的前两个数已经确定必须是0和1
        //为什么不遍历i=n？；因为i=n表示已经跳到了最后，状态就一定是true了
        for (int i = 2; i < n; i++) {
            //遍历i之前的所有石子(所以没有等号)
            for (int j = 1; j < i; j++) {
                //k为跳跃单独距离
                int k = stones[i] - stones[j];
                //上一次的点必须存在，才能接着往下跳，因为最多跳a+1，所以是从k或者k-1或者k+1跳过来的.要保证最远的那个点存在，才有机会发生状态转移
                if (k <= j + 1) {
                    dp[i][k] = dp[j][k] || dp[j][k - 1] || dp[j][k + 1];
                }
            }
        }



        //在所有跳到最后一步的方案中，只要找到一个为true的就说明能跳过去
        //方案数级为最后一行true的个数
        for (int i = 1; i < n; i++) {
            if (dp[n - 1][i]) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {3,4,5,6,9};
        System.out.println(canCross(arr));

    }

}
