package leetcode740删除数并获得点数;


import java.util.Arrays;

public class deleteAndEarnOptimizationClass {
    /**
     * 集合:删除的数是第i个数
     * 属性：获得点数的最大值
     * 集合划分：是否删除第i个数
     * 要想实现以上状态转移，先要给数组去重，并统计每个数出现的次数
     * 滚动数组优化版
     * @param arr
     * @return
     */
    public static int deleteAndEarn(int[] arr) {

        int manVal = Arrays.stream(arr).max().getAsInt();
//        int[] dp = new int[manVal+1];
        int[] count = new int[manVal+1];
        //这里把“先要给数组去重，并统计每个数出现的次数”这个思路优化为“统计每个数的总价值”的数组
        for (int num : arr) {
            count[num]+= num;
        }

//        在朴素版的基础上，我们发现，dp[i]的值值和dp[i-1]和dp[i-2]有关
//        所以我们没有必要开dp数组，只需要用2个值存下dp[i-1]和dp[i-2]
//        并不断更新这两个值即可
//        这种思想叫滚动数组
        int beforeBehind = count[0], behind = Math.max(count[0],count[1]);
        for(int i = 2; i <manVal+1; i++) {
          int temp = behind;
          behind = Math.max(beforeBehind+count[i],behind);
          beforeBehind = temp;
        }
        return behind;
    }

    public static void main(String[] args) {
        int[]arr = {2,2,3,4};
        System.out.println(deleteAndEarn(arr));
    }
}
