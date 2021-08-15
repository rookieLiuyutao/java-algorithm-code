package leetcode5843作为子字符串出现在单词中的字符串数目;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class NumOfStrings {

    public int numOfStrings(String[] patterns, String word) {
        HashMap<String,Integer>map = new HashMap<>();
        for (String pattern : patterns) {
            map.put(pattern, map.getOrDefault(pattern,0)+1);
        }
        int res = 0;
        for(int i = 1; i <=word.length(); i++) {
            for(int j = 0; j <i; j++) {
                String t = word.substring(j,i);
                if (map.containsKey(t)&&map.get(t)>0){
                    map.put(t,0);
                    res+=map.get(t);
                }
            }
        }
        return res;
    }

}
