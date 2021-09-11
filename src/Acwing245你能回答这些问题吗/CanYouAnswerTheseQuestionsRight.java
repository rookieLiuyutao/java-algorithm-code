package Acwing245你能回答这些问题吗;

import java.io.*;
import java.util.Scanner;

public class CanYouAnswerTheseQuestionsRight {
    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    static int nextInt() throws Exception{
        in.nextToken();
        return (int)in.nval;
    }
    static String next()throws Exception{
        in.nextToken();
        return in.sval;
    }
    static final int N = 500010;
    static int[] w = new int[N];

    static class Tree {
        int l, r;
        int sum, lm, rm, tm;

        public Tree(int l, int r, int sum, int lm, int rm, int tm) {
            this.l = l;
            this.r = r;
            this.sum = sum;
            this.lm = lm;
            this.rm = rm;
            this.tm = tm;
        }

        public Tree() {
        }
    }

    static Tree[] tr = new Tree[4 * N];

    static void build(int u, int l, int r) {
        if (l == r) {
            tr[u] = new Tree(l,r,w[l],w[l],w[l],w[l]);
            return;
        }
        tr[u].l = l;
        tr[u].r = r;
        int mid = l + r >> 1;
        build(u << 1, l, mid);
        build(u << 1 | 1, mid + 1, r);
        push(u);
    }

    static void push(int u) {
        pushUp(tr[u], tr[u << 1], tr[u << 1 | 1]);
    }

    static void pushUp(Tree u, Tree lSon, Tree rSon) {
        u.sum = lSon.sum + rSon.sum;
        u.lm = Math.max(lSon.lm, lSon.sum + rSon.lm);
        u.rm = Math.max(rSon.rm, rSon.sum + lSon.rm);
        u.tm = Math.max(Math.max(lSon.tm, rSon.tm), lSon.rm + rSon.lm);
    }

    static void modify(int u, int x, int y) {
        if (tr[u].l == x && tr[u].r == x) {
            tr[u] = new Tree(x,x,y,y,y,y);
            return;
        }
        int mid = tr[u].l + tr[u].r >> 1;
        if (x <= mid) {
            modify(u << 1, x, y);
        } else {
            modify(u << 1 | 1, x, y);
        }
        push(u);
    }

    static Tree query(int u, int l, int r) {
        if (tr[u].l >= l && tr[u].r <= r) {
            return tr[u];
        }
        int mid = tr[u].l + tr[u].r >> 1;
        if (r <= mid) {
            return query(u << 1, l, r);
        } else if (l > mid) {
            return query(u << 1 | 1, l, r);
        } else {
            Tree a = query(u << 1, l, r);
            Tree b = query(u << 1 | 1, l, r);
            Tree c = new Tree();
            pushUp(c, a, b);
            return c;
        }

    }


    public static void main(String[] args)throws Exception {
        int n = nextInt();
        int m = nextInt();
        for (int i = 1; i <= n; i++) {
            w[i] = nextInt();
        }
        for (int i = 0; i < tr.length; i++) {
            tr[i] = new Tree();
        }
        build(1, 1, n);
        for (int i = 0; i < m; i++) {
            int k = nextInt(),x = nextInt(),y = nextInt();
            if (k == 2) {
                modify(1, x, y);
            } else if (k == 1) {
                if (x > y) {
                    int a = x;
                    x = y;
                    y = a;
                }
                out.println(query(1, x, y).tm);
            }
        }
        out.flush();
    }
}
