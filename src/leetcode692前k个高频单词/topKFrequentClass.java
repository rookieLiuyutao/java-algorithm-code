package leetcode692前k个高频单词;

import java.util.*;

/**
 * @see 哈希表 https://leetcode-cn.com/problems/top-k-frequent-words/
 */
public class topKFrequentClass {

    public List<String> topKFrequent(String[] words, int k) {
        TreeMap<String,Integer> wordCount = new TreeMap<>();
        for (String i : words) {
            wordCount.put(i, wordCount.getOrDefault(i, 0) + 1);
        }
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            list.add(entry.getKey());
        }
        list.sort((word1, word2) -> wordCount.get(word2) - wordCount.get(word1));


        return list.subList(0, k);
    }

    public static void main(String[] args) {
        String[] words = {"i", "love", "coding", "leetcode"};
        System.out.println(new topKFrequentClass().topKFrequent(words, 2));
    }

}
