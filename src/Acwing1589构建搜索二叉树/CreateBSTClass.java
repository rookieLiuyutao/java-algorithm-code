package Acwing1589构建搜索二叉树;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @see Acwing1589构建搜索二叉树 https://www.acwing.com/problem/content/1591/
 */
public class CreateBSTClass {
    static int N = 110;

    static int[] leftIndex = new int[N];
    static int[] rightIndex = new int[N];
    static int[] weight = new int[N];
    static int[] queue = new int[N];
    static int[] value = new int[N];
    static int k;

    /**
     * BST的中序遍历序列是单调递增的，dfs作用是中序把输入的值填入BST
     * @param curVal
     */
    static void dfs(int curVal) {
        if (curVal == -1) {
            return;
        }
        dfs(leftIndex[curVal]);
        //如果想做到每调用一次函数k指针都++,k就必须是共工变量
        //如果k是函数传参，递归调用的时候并没有出函数，k的值会来回循环，不会顺利++
        weight[curVal] = value[k++];
        dfs(rightIndex[curVal]);
    }

    /**
     * 用层序遍历输出BST
     */
    static void bfs() {
        int begin = 0, end = 0;
        while (begin <= end) {
            int t = queue[begin++];
            System.out.print(weight[t]+" ");
            if (leftIndex[t] != -1) queue[++end] = leftIndex[t];
            if (rightIndex[t] != -1) queue[++end] = rightIndex[t];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            leftIndex[i] = sc.nextInt();
            rightIndex[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            value[i] = sc.nextInt();
        }
        //对value数组的[0,n)的数排序
        Arrays.sort(value,0,n);
         k = 0;
        dfs(0);
        bfs();
    }
}
