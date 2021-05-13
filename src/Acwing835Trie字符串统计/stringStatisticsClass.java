package Acwing835Trie字符串统计;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 使用「二维数组」的好处是写起来飞快，但是需要根据数据结构范围估算我们的「二维数组」应该开多少行。
 * 坏处是使用的空间通常是「TrieNodeTrieNode」方式的数倍，而且由于通常对行的估算会很大，导致使用的二维数组开得很大，
 * 如果这时候每次创建 TrieTrie 对象时都去创建数组的话，会比较慢，而且当样例多的时候甚至会触发 GC（因为 OJ 每测试一个样例会创建一个 TrieTrie 对象）。
 * 因此还有一个小技巧是将使用到的数组转为静态，然后使用 SetSet 记录那些行被使用了，在初始化 TrieTrie 时执行清理工作 & 重置逻辑。
 * 这样的做法能够使评测时间降低一半，运气好的话可以得到一个与「TrieNodeTrieNode」方式差不多的时间
 */
public class stringStatisticsClass {
    /**
     * 二维数组版
     */

        int N = 100009;
        static int[][] trie;
        static int[] count;//存储以当前节点结尾的单词个数
        static int index;//表示当前节点的下标，index为0时，表示根节点，也是空节点



        public static void insert(String s) {
            int p = 0;//指向节点下标的指针
            for (int i = 0; i < s.length(); i++) {

                int u = s.charAt(i) - 'a';//用u来存储在存26个字母数组中的位置
                //如果当前节点不存在，就创建节点
                if (trie[p][u] == 0) {
                    trie[p][u] = ++index;
                }
                p = trie[p][u];
            }
            count[p]++;
        }

        public boolean search(String s) {
            int p = 0;
            for (int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                if (trie[p][u] == 0) return false;
                p = trie[p][u];
            }
            return count[p] != 0;
        }

        /**
         * boolean startsWith(String prefix)
         * 如果之前已经插入的字符串word 的前缀之一为 prefix ，返回 true ；
         * 否则，返回 false
         */
        public boolean startsWith(String s) {
            int p = 0;
            for (int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                if (trie[p][u] == 0) return false;
                p = trie[p][u];
            }
            return true;
        }





    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        for (int i = 0; i < N; i++) {
            String word = sc.nextLine();
            insert(word);
        }
        for (int i = 0; i < M; i++) {
            String s1 = sc.nextLine();
//            System.out.println(trieNode.countNode(s1));
        }
    }
}
