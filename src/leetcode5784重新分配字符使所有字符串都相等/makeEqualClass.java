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
//        for(int i = 1; i <m; i++) {
//          if
//        }
        HashMap<Character,Integer> map = new HashMap<>();
        char[] s = Arrays.toString(words).toCharArray();
        int n = s.length;
        for (char c : s) {
            if (c!=','&&c!=' '&&c!='['&&c!=']'){
                map.put(c, map.getOrDefault(c, 0) + 1);

            }
        }
        ArrayList<Integer> list = new ArrayList<>(map.values());
        int count = 0,f = list.get(0);
        for (int x: map.values()){
            if (x == f) {
                count++;
            }

        }
        System.out.println(s);
        System.out.println(map.keySet());
        System.out.println(list);
        System.out.println(count);

        return count==list.size();
    }

}
