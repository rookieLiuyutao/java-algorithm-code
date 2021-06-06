package Acwing846树的重心_图邻接表模板;

import java.io.*;
import java.util.Arrays;

/**
 * @see 图论 邻接表 加边函数 数组模拟
 * https://www.acwing.com/solution/content/33874/
 * https://www.acwing.com/solution/content/4917/
 * https://www.luogu.com.cn/problem/P4582
 */
public class centerOfGravityOfTheTreeClass {

    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static int nextInt() throws Exception {
        in.nextToken();
        return (int) in.nval;
    }

    static String next() throws Exception {
        in.nextToken();
        return in.sval;
    }

    static final int N = 100010, M = N * 2;
    static int[] head = new int[N];//存邻接表的链表头
    static int[] e = new int[M];//存所有节点的值
    static int[] ne = new int[M];//存每个节点的next值
    static int idx;//单链表的指针
    static boolean[] st = new boolean[N];//记录节点是否被访问过

    /**
     * 向邻接表加边的函数
     * @param a 点a
     * @param b 点b
     */
    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = head[a];
        head[a] = idx++;
    }

    void dfs(int u){
        st[u] = true;
        
        for(int i = 0; i !=1; i = ne[i]) {
          int j = e[i];
          if (!st[j]){
              dfs(j);
          }

        }


    }

    public static void main(String[] args) {
        Arrays.fill(head, -1);


    }
}
