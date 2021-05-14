package leetcode13罗马数字转整数;

import java.util.HashMap;
import java.util.Map;

/**
 * @see 贪心 https://leetcode-cn.com/problems/roman-to-integer/
 */
public class romanToIntClass {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        int res = 0;
        int m = s.length();
        char[] sb = s.toCharArray();
        for (int i = 1; i < m; i++) {
            if (map.get(sb[i - 1]) < map.get(sb[i])) {
                res -= map.get(sb[i - 1]);
            } else {
                res += map.get(sb[i - 1]);
            }
        }
        res += map.get(sb[m - 1]);
        return res;
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(new romanToIntClass().romanToInt(s));
    }


}
