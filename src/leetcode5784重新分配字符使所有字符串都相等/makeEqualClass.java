package leetcode5784重新分配字符使所有字符串都相等;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @see
 */
public class makeEqualClass {

    public boolean makeEqual(String[] words) {
        int m = words.length;

        HashMap<Character,Integer> map = new HashMap<>();
        char[] s = Arrays.toString(words).toCharArray();
        for (char c : s) {
            if (c!=','&&c!=' '&&c!='['&&c!=']'){
                map.put(c, map.getOrDefault(c, 0) + 1);

            }
        }
        for (int x: map.values()){
//------------解题关键步骤-----------------------
            if (x % m != 0) {
                return false;
            }
//---------------------------------------------
        }
        return true;
    }

}
