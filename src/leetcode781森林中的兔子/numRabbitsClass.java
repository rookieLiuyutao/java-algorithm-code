package leetcode781森林中的兔子;

import java.util.*;

/**
 * @see 贪心 哈希表计数 https://leetcode-cn.com/problems/rabbits-in-forest/solution/gong-shui-san-xie-noxiang-xin-ke-xue-xi-v17p5/
 */
public class numRabbitsClass {
    /**
     * 贪心解法
     *
     * @param num
     * @return
     */
    public static int numRabbits1(int[] num) {
        Arrays.sort(num);
        int res = 0;
        for (int i = 0; i < num.length; i++) {
            int count = num[i];
            int k = count;
            res += count + 1;
            while (k-- > 0 && i + 1 < num.length && num[i] == num[i + 1]) {
                i++;
            }
        }

        return res;
    }

    /**
     * 哈希表解法
     * @param answers
     * @return
     */
    public static int numRabbits2(int[] answers) {
        HashMap<Integer, Integer> count = new HashMap<>();
//-------------------用哈希表统计一维数组中的元素个数----------------------
        for (int y : answers) {
            count.put(y, count.getOrDefault(y, 0) + 1);
        }
//-------------------------------------------------------------------

//---------------------------遍历哈希表----------------------------------
        int ans=0;
        for (Map.Entry<Integer,Integer> entry: count.entrySet()) {
            int y = entry.getKey();
            int x = entry.getValue();
            ans+=(x+y)/(y+1)*(y+1);
        }
//-----------------------------------------------------------------------
        return ans;



    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 3, 3, 3, 1, 1, 1, 1};
        System.out.println(numRabbits1(arr));
    }
}
