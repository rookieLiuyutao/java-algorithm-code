package Acwing827双链表;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/829/
 * 数组模拟双链表
 */
public class DoubleLinkedList {

    static Scanner sc = new Scanner(System.in);
    static final int N = 100010;
    static int[] e = new int[N], ne = new int[N], pr = new int[N];
    static int idx;

    /**
     * 0号点表示head，1号点表示tail
     * 所以idx从2开始
     */
    static void init() {
        ne[0] = 1;
        pr[1] = 0;
        idx = 2;
    }

    /**
     * 在k号点的前或后插入一个点
     * 在前插入，add(pr[k],val)
     * 在后插入，add(k,val)
     *
     * @param k   k号点的前或后
     * @param val 要插入新点的值
     */
    static void add(int k, int val) {
        e[idx] = val;
        ne[idx] = ne[k];
        pr[idx] = k;
        pr[ne[k]] = idx;
        ne[k] = idx++;
    }

    /**
     * 删除k号点
     *
     * @param k 要删除的点的序号
     */
    static void remove(int k) {
        pr[ne[k]] = pr[k];
        ne[pr[k]] = ne[k];
    }

    public static void main(String[] args) {
        init();
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String[] ss = sc.nextLine().split(" ");
            int k, x;
            String op = ss[0];
            switch (op) {
                default:
                    break;
                case "L":
                    x = Integer.parseInt(ss[1]);
                    add(0, x);
                    break;
                case "R":
                    x = Integer.parseInt(ss[1]);
                    add(pr[1],x );
                    break;
                case "D":
                    k = Integer.parseInt(ss[1]);
                    remove(k+1);
                    break;
                case "IL":
                    k = Integer.parseInt(ss[1]);
                    x = Integer.parseInt(ss[2]);
                    add(pr[k+1],x );
                    break;
                case "IR":
                    k = Integer.parseInt(ss[1]);
                    x = Integer.parseInt(ss[2]);
                    add(k+1,x);
                    break;
            }
        }
        for(int i = ne[0]; i !=1; i=ne[i]) {
            System.out.print(e[i]+" ");
        }

    }
}
