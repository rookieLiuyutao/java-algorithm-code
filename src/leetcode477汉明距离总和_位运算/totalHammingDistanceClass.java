package leetcode477汉明距离总和_位运算;

/**
 * @see 位运算 https://leetcode-cn.com/problems/total-hamming-distance/
 */
public class totalHammingDistanceClass {
    public int totalHammingDistance(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 30 ;i>0;i--){
            int temp = 0;
            for(int j = 0; j <n; j++) {
              temp+= nums[j]>>i&1;
            }
            temp*=n-temp;
            res+=temp;
        }
        return res;
    }


}
