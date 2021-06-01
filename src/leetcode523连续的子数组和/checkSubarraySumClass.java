package leetcode523连续的子数组和;

import java.util.HashMap;

/**
 * @see 前缀和 https://leetcode-cn.com/problems/continuous-subarray-sum/
 */
public class checkSubarraySumClass {

    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        //想要找到整除的，必须把余数为0的加进去，否则有两个这样的子数组才会返回true
        map.put(0,-1);
        int remainder = 0;
//        当sum[i]-sum[j]为true时，sum[i]和sum[j]一定也都可以被k整除。因此只需要计算每个下标对应的前缀和除以 k 的余数即可，使用哈希表存储每个余数第一次出现的下标。


        for(int i = 0; i <n; i++) {
            //t表示当前子数组和的余数
            remainder = (remainder+nums[i])%k;
            if (map.containsKey(remainder)){
                int index = map.get(remainder);
                if (i - index >= 2) {
                    return true;
                }
            }else {
                map.put(remainder,i);
            }
        }
        return false;
    }

}
