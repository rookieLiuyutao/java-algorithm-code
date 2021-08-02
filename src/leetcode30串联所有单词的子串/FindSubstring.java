package leetcode30串联所有单词的子串;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/
 * 哈希表 滑动窗口 枚举优化
 */
public class FindSubstring {

    public List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = s.length(), m = words.length, wordLength = words[0].length();
        //边界判断，如果单词数组为空，则返回空
        if (m == 0) {
            return res;
        }
        HashMap<String, Integer> total = new HashMap<>();
        for (String x : words) {
            total.put(x, total.getOrDefault(x, 0) + 1);
        }
        for (int i = 0; i < wordLength; i++) {
            HashMap<String, Integer> window = new HashMap<>();
            int count = 0;
            for (int j = i; j + wordLength <= n; j += wordLength) {
                if (j >= i + m * wordLength) {
                    String word = s.substring(j - m * wordLength, j - (m - 1) * wordLength);
                    window.put(word, window.getOrDefault(word, 0) - 1);
                    if (total.containsKey(word)&&window.get(word) < total.get(word)) {
                        count--;
                    }
                }
                String word = s.substring(j, j + wordLength);
                window.put(word, window.getOrDefault(word, 0) + 1);

                if (total.containsKey(word)&&window.get(word) <= total.get(word)) {
                    count++;
                }


                if (count == m) {
                    res.add(j - (m - 1) * wordLength);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        System.out.println(new FindSubstring().findSubstring(s, words));
    }
}
