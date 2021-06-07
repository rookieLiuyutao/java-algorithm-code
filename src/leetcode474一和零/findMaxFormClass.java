package leetcode474一和零;

/**
 * @see 动态规划 线性dp https://leetcode-cn.com/problems/ones-and-zeroes/
 */
public class findMaxFormClass {

    public int findMaxForm(String[] strs, int m, int n) {
        //预处理出strs中每个元素的0和1的数量
        int len  = strs.length;
        int[][] zoCount = new int[len][2];
        for(int i = 0; i <len; i++) {
          String s = strs[i];
          int zero = 0,one = 0;
          for (char c : s.toCharArray()){
              if (c == '0' ) {
                  zero++;
              }else {
                  one++;
              }
          }
          zoCount[i] = new int[]{zero,one};
        }

        int [][] dp  = new int[m+1][n+1];
        for(int k = 0; k <len; k++) {
          int zero = zoCount[k][0],one = zoCount[k][1];
          for (int i = m;i>=zero;i--){
              for (int j = n;j>=one;j--){
                  dp[i][j] = Math.min(dp[i][j],dp[i-zero][j-one]+1);
              }
          }
        }
        return dp[m][n];
    }

}
