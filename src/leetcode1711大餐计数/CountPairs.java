package leetcode1711大餐计数;

import java.util.HashMap;
import java.util.Map;

/**
 * @see
 */
public class CountPairs {

    public int countPairs(int[] deliciousness) {
        int mod = (int) 1e9 + 7;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : deliciousness) {
            for (int i = 1; i < 1 << 22; i <<= 1) {
                if (map.containsKey(i - x)) {
                    res += map.get(i - x);
                    if (res >= mod) {
                        res -= mod;
                    }
                }
            }
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 3, 3, 3, 7};
        System.out.println(new CountPairs().countPairs(arr));
    }

}
