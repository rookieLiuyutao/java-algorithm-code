package leetcode692前k个高频单词;

import java.util.*;

/**
 * @see 优先队列 https://leetcode-cn.com/problems/top-k-frequent-words/solution/gong-shui-san-xie-xiang-jie-shi-yong-ha-8dxt2/
 */
public class topKFrequent2Class {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        for (String i : words) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(entry.getKey());
        }
        list.sort((word1, word2) -> map.get(word2) - map.get(word1));


        return list.subList(0, k);
    }

}
