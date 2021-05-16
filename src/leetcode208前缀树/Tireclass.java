package leetcode208前缀树;
/**
 * @see trie树 https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Tireclass {
    public static class TrieNode{
        /**
         * 每个节点都包含
         * 1.end标记，标记是否有单词以当前字母结尾
         * 2.tns数组：储存26个字母的位置
         */
        boolean end;
        TrieNode[] letter = new TrieNode[26];

        TrieNode root;

        public TrieNode(){
            TrieNode root = new TrieNode();
        }

        public void insert(String s){
            //p位指向根节点的指针
            TrieNode p  = root;
            for (int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                if (p.letter[u]==null) p.letter[u] = new TrieNode();
                p = p.letter[u];

            }
            p.end = true;
        }
        public boolean search(String s){
            TrieNode p = root;
            for (int i = 0; i < s.length(); i++) {
                int u = s.charAt(i)-'a';
                if (p.letter[u]==null)return false;
                p=p.letter[u];
            }
            return p.end;
        }

        public boolean startsWith(String s){
            TrieNode p = root;
            for (int i = 0; i < s.length(); i++) {
                int u  = s.charAt(i);
                if (p.letter[u]==null){
                    return false;
                }
                p = p.letter[u];
            }
            return true;
        }


    }


    /**
     * set优化版
     */
    static class TrieSet {
        static int N = 100009; // 直接设置为十万级
        static int[][] trie = new int[N][26];
        static int[] count = new int[N];
        static int index = 0;
        static Set<Integer> set = new HashSet<>();

        public TrieSet() {
            for (int row : set) {
                Arrays.fill(trie[row], 0);
            }
            Arrays.fill(count, 0);
            index = 0;
            set.clear();
        }

        public void insert(String s) {
            int p = 0;
            for (int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                if (trie[p][u] == 0) {
                    trie[p][u] = ++index;
                }
                set.add(p);
                p = trie[p][u];
            }
            count[p]++;
        }

        public boolean search(String s) {
            int p = 0;
            for (int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                if (trie[p][u] == 0) {
                    return false;
                }
                p = trie[p][u];
            }
            return count[p] != 0;
        }

        public boolean startsWith(String s) {
            int p = 0;
            for (int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                if (trie[p][u] == 0) {
                    return false;
                }
                p = trie[p][u];
            }
            return true;
        }

    }
}
