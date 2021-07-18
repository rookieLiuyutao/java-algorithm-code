package leetcode5815扣分后的最大得分;

import java.util.Arrays;

public class Main {

    public long maxPoints(int[][] points) {
        int n = points.length;
        int m = points[0].length;
        int [][]dp = new int[n+1][m+1];
        int start = Arrays.stream(points[0]).max().getAsInt();

        for(int i = 1; i <=n; i++) {
            int max = start;
            for(int j = 1; j <=m; j++) {


            }
        }
        return dp[n][m];
    }

}
