package Acwing1117单词接龙;

import java.util.Scanner;

/**
 * https://www.luogu.com.cn/problem/P1019
 */
public class WordSolitaire {

    static Scanner sc = new Scanner(System.in);
    static final int N = 22;
    static int[][] g = new int[N][N];//存储两个单词间的最大重和长度
    static int[] used = new int[N];
    static String[] words = new String[N];
    static int ans, n;

    /**
     *
     * @param last 以哪个单词开头
     * @param wd 开头的单词
     */
    static void dfs(int last, String wd) {
        ans = Math.max(wd.length(), ans);
        used[last]++;
        for (int i = 0; i < n; i++) {
            if (g[last][i] > 0 && used[i] < 2) {
                dfs(i, wd + words[i].substring(g[last][i]));
            }
        }
        used[last]--;
    }

    public static void main(String[] args) {
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }
        char start = sc.next().charAt(0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String a = words[i], b = words[j];
                //相邻两部分不能存在包含关系。所以k从1开始
                for (int k = 1; k < Math.min(a.length(), b.length()); k++) {
                    if (a.substring(a.length() - k).equals(b.substring(0, k))) {
                        g[i][j] = k;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            char c = words[i].charAt(0);
            if (c == start) {
                dfs(i, words[i]);
            }
        }
        System.out.println(ans);

    }

}
