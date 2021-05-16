package Acwing142前缀统计;
/**
 * @see 前缀统计 https://www.acwing.com/problem/content/144/
 */

import java.util.Scanner;

public  class TireCountClass {

        static int N = 100009;
        static int[][] trie = new int[N][26];
        static int[] count=  new int[N];//存储以当前节点结尾的单词个数
        static int index = 0;//表示当前节点的下标，index为0时，表示根节点，也是空节点

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

        public static boolean search(String s) {
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

        /**
         * boolean startsWith(String prefix)
         * 如果之前已经插入的字符串word 的前缀之一为 prefix ，返回 true ；
         * 否则，返回 false
         */
        public static boolean startsWith(String s) {
            int p = 0;
            for (int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                if (trie[p][u] == 0) return false;
                p = trie[p][u];
            }
            return true;
        }
        public static int countLetter(String s){
            int p = 0;
            int res = 0;

            for (int i = 0; i < s.length(); i++) {
                int u = s.charAt(i)-'a';
                p = trie[p][u];
                if (p==0) {
                    return res;
                }
                res += count[p];
            }
            return res;
        }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            insert(sc.next());

        }
        System.out.println();
        for (int i = 0; i < M; i++) {
            System.out.println(countLetter(sc.next()));
        }
    }
}
