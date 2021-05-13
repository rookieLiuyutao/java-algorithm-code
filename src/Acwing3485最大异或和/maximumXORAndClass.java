package Acwing3485最大异或和;

import java.util.Scanner;

/**
 * @see trie树 前缀和 https://www.acwing.com/problem/content/3488/
 */
public class maximumXORAndClass {
    static int N = 100010;
    static int n, m, idx = 0;
    static int[] qSum = new int[N];
    static int[][] son = new int[N * 31][2];
    static int[] count = new int[N*31];

    /**
     * 本题心得：
     * trie树的数组模拟，在实现insert时，在插入后面(以第二个数为例)的数时，对于不一样的部分，存在第son.length+1行
     * 前缀和的应用；对于传统io，sum数组像一般的数组一样多开了几位，构建sum时，要从第二位开始读入
     * @param x
     * @param model 模式选择，1表示插入，-1表示删除
     */
    static void insert(int x, int model) {
        int p = 0;
        for (int i = 30; i >= 0; i--) {
            int u = x >> i & 1;
            if (son[p][u] == 0) {
                son[p][u] = ++idx;
            }
            p = son[p][u];
            count[p] += model;
        }

    }

    static int query(int x) {
        int res = 0, p = 0;
        for (int i = 30; i >= 0; i--) {
            int u = x >> i & 1;
            if (count[son[p][1 - u]] != 0) {
                res += (1 << i);
                p = son[p][1 - u];
            } else {
                p = son[p][u];
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            int x = sc.nextInt();
            qSum[i] = qSum[i - 1] ^ x;

        }
        int res = 0;
        insert(qSum[0], 1);
        for (int i = 1; i <= n; i++) {
            if (i > m) {
                //相当于
                insert(qSum[i - 1 - m], -1);
            }
            res = Math.max(res, query(qSum[i]));
            insert(qSum[i], 1);

        }
        System.out.println(res);
    }


}
