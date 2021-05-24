package leetcode664奇怪的打印机_线性dp;

import java.util.Arrays;

public class strangePrinter3Class {
    public int strangePrinter(String s) {
        int n = s.length();
        //集合：以left为左端点，right为右端点的字符串需要的最小打印次数
        //左右端点相等时，等于不打印右(左)端点时的次数
        //左右端点不相等时，在子区间里找一个和左端点相等的最小点；记这个点为k
        //k左侧，和右侧两个区间；又成为了规模更小的“子问题”
        //总最小次数为——左区间的最小次数+右区间最小次数
        int[][] dp = new int[n+1][n+1];
        s = " "+s;
        for (int i = n;i>0;i--){
            dp[i][i] = 1;
            for(int j = i+1; j <=n; j++) {
                if (s.charAt(i) ==s.charAt(j)){
                    dp[i][j] = dp[i][j-1];
                }else {
                    int minNum = Integer.MAX_VALUE;
                    for(int k = i; k <j; k++) {
                        minNum = Math.min(minNum,dp[i][k-1]+dp[k+1][j]);
                    }
                }
            }
        }
        for (int [] i:dp){
            System.out.println(Arrays.toString(i));
        }

        return dp[0][n];
    }

    public static void main(String[] args) {
        String s = "assaasa";
        System.out.println(new strangePrinter3Class().strangePrinter(s));
    }
}
