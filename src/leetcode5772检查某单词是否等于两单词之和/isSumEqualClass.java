package leetcode5772检查某单词是否等于两单词之和;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class isSumEqualClass {
    Map<Character,Character> map = new HashMap<>();

    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        map.put('a','0');
        map.put('b','1');
        map.put('c','2');
        map.put('d','3');
        map.put('e','4');
        map.put('f','5');
        map.put('g','6');
        map.put('h','7');
        map.put('i','8');
        map.put('j','9');

        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        StringBuffer sb3 = new StringBuffer();
        for(int i = 0; i <firstWord.length(); i++) {
          sb1.append(map.get(firstWord.charAt(i)));
        }
        for(int i = 0; i <secondWord.length(); i++) {
            sb2.append(map.get(secondWord.charAt(i)));
        }
        for(int i = 0; i <targetWord.length(); i++) {
            sb3.append(map.get(targetWord.charAt(i)));
        }
     int x = Integer.parseInt(sb1.toString())+Integer.parseInt(sb2.toString());

        if (x==Integer.parseInt(sb3.toString())){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "acb";
        String s2 = "cba";
        String s3 = "cbd";
        System.out.println(new isSumEqualClass().isSumEqual(s1,s2,s3));
    }
}
