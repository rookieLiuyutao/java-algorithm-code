package leetcode137只出现一次的数字;

import java.util.*;

/**
 * @see 哈希表 https://leetcode-cn.com/problems/single-number-ii/submissions/
 */
public class singleNumber2Class {

    public static int singleNumber2(int[] nums) {
        int res = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
//--------------------------------------------------
        //用哈希表统计数组中元素的个数
        for (int num : nums) {
            int count = 1;
            if (map.containsKey(num)) {
                count += map.get(num);
                map.put(num, count);
            }
            map.put(num, count);
        }
//------------------------------------------------------
        for (int i: map.keySet()) {
            if (map.get(i)==1){
                return res =i;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {2,2,3,2};
        System.out.println(singleNumber2(arr));
    }


}
