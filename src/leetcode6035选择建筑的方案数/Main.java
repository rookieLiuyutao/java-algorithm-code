package leetcode6035选择建筑的方案数;

public class Main {
    class Solution {
        /**
         * 统计每个1左边和右边有多少个0
         * 统计每个0左边和右边有多少个1
         * @param s
         * @return
         */
        public long numberOfWays(String s) {
            int n = s.length();
            int[] sum = new int[n+1];
            for(int i = 1; i <=n; i++) {
              sum[i] = sum[i-1]+s.charAt(i-1)-'0';
            }
            long res = 0;
            for(int i = 1; i <n-1; i++) {
              if (s.charAt(i)=='1'){
                  int lcnt0 = i-sum[i];
                  int rcnt0 = n-1-i-(sum[n]-sum[i+1]);
                  res+= (long) lcnt0 * rcnt0;
              }else{
                  int lcnt1 = sum[i];
                  int rcnt1 = sum[n]-sum[i+1];
                  res+= (long) lcnt1*rcnt1;
              }
            }
            return res;
        }
    }
}
