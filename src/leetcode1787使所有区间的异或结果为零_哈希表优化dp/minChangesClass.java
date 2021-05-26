package leetcode1787使所有区间的异或结果为零_哈希表优化dp;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @see 区间动态规划 https://leetcode-cn.com/problems/make-the-xor-of-all-segments-equal-to-zero/solution/gong-shui-san-xie-chou-xiang-cheng-er-we-ww79/
 */
public class minChangesClass {

    public int minChanges(int[] nums, int k) {
        int n = nums.length;
        int maxVal = Integer.MAX_VALUE/2;
        int[][] dp  = new int[k][1024];
        int[] minNumPc = new int[k];
        for(int i = 0; i <k; i++) {
            Arrays.fill(dp[i],maxVal);
            minNumPc[i] = maxVal;

        }
        for (int i = 0,count = 0;i<k;i++,count=0){
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int j = i; j <n; j+=k) {
              map.put(nums[j],map.getOrDefault(nums[j],0)+1);
              count++;
            }
            if (i==0){
                for(int xor = 0; xor <1024; xor++) {
                  dp[0][xor] = Math.min(dp[0][xor],count-map.getOrDefault(xor,0));
                  minNumPc[0] = Math.min(minNumPc[0],dp[0][xor]);
                }
            }else {
                for(int xor = 0; xor <1024; xor++) {
                    dp[i][xor] = minNumPc[i-1]+count;
                    for (int cur: map.keySet()){
                        dp[i][xor] = Math.min(dp[i][xor],dp[i-1][xor^cur]+count-map.get(cur));
                    }
                    minNumPc[i] = Math.min(minNumPc[i],dp[i][xor]);
                }

            }
        }
    return dp[k-1][0];

    }
}
