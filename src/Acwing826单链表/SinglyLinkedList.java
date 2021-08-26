package Acwing826单链表;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/828/
 */
public class SinglyLinkedList {

    static Scanner sc = new Scanner(System.in);
    static int N = 100010;
    static int[] e = new int[N], ne = new int[N];
    static int idx, head = -1;

    /**
     * 在k号点后插入一个值为x的新点
     *
     * @param x 要插入点的值
     * @param k 要插在k号点后
     */
    static void add(int x, int k) {
        e[idx] = x;
        ne[idx] = ne[k];
        ne[k] = idx++;
    }

    /**
     * 在头节点后插入一个新节点
     *
     * @param x 新节点的值
     */
    static void addAfterHead(int x) {
        e[idx] = x;
        ne[idx] = head;
        head = idx++;
    }

    /**
     * 删除k号节点
     *
     * @param k 点的编号
     */
    static void remove(int k) {
        ne[k] = ne[ne[k]];
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String[] ss = sc.nextLine().split(" ");
            int n = ss.length;
            char c = ss[0].charAt(0);
            int k, x;
            if (n == 2) {
                if (c == 'H') {
                    x = Integer.parseInt(ss[1]);
                    addAfterHead(x);
                } else {
                    k = Integer.parseInt(ss[1]);
                    if(k==0) {
                        head=ne[head];
                    }else {
                        remove(k-1);
                    }
                }
            } else {
                k = Integer.parseInt(ss[1]);
                x = Integer.parseInt(ss[2]);
                add(x, k-1);
            }
        }
        for (int i = head; i !=-1; i = ne[i]) {
            System.out.print(e[i] + " ");
        }
    }

}
