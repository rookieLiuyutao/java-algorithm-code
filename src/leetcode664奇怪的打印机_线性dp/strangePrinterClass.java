package leetcode664奇怪的打印机_线性dp;

import java.util.Arrays;

/**
 * @see 线性动态规划 https://leetcode-cn.com/problems/strange-printer/
 */
public class strangePrinterClass {

    public int strangePrinter(String s) {
        int n = s.length();
        //集合：以left为左端点，right为右端点的字符串需要的最小打印次数
        //左右端点相等时，等于不打印右(左)端点时的次数
        //左右端点不相等时，在子区间里找一个和左端点相等的最小点；记这个点为k
        //k左侧，和右侧两个区间；又成为了规模更小的“子问题”
        //总最小次数为——左区间的最小次数+右区间最小次数
        int[][] dp = new int[n + 1][n + 1];

        for (int len = 1; len <= n; len++) {

            for (int left = 0; left + len - 1 < n; left++) {
                int right = left + len - 1;
                dp[left][right] = dp[left + 1][right]+1;
                for (int k = left + 1; k <= right; k++) {
                    if (s.charAt(left) == s.charAt(k)) {
                        dp[left][right] = Math.min(dp[left][right], dp[left][k - 1] + dp[k + 1][right]);
                    }
                }
            }
        }
        for (int [] i:dp){
            System.out.println(Arrays.toString(i));
        }
        return dp[0][n-1];

    }

    public static void main(String[] args) {
        String s = "assaasa";
        System.out.println(new strangePrinterClass().strangePrinter(s));
    }


}
