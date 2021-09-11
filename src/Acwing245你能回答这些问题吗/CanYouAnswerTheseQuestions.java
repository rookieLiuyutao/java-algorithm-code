package Acwing245你能回答这些问题吗;

import java.io.*;

/**
 * https://www.acwing.com/problem/content/246/
 */
public class CanYouAnswerTheseQuestions {

    static class Node {
        int l, r, sum, lm, rm, tm;
        public Node() {
        }

        public Node(int l, int r, int sum, int lm, int rm, int tm) {
            this.l = l;
            this.r = r;
            this.sum = sum;//区间和
            this.lm = lm;//最大前缀和
            this.rm = rm;//最大后缀和
            this.tm = tm;//连续最大子段和
        }
    }

    static final int N = 500010;
    static Node[] tr = new Node[N * 4];
    static int[] w;
    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static int nextInt() throws Exception {
        in.nextToken();
        return (int) in.nval;
    }

    static void up(Node u, Node lSon, Node rSon) {
        u.sum = lSon.sum + rSon.sum;
        u.lm = Math.max(lSon.lm, lSon.sum + rSon.lm);
        u.rm = Math.max(rSon.rm, lSon.rm + rSon.sum);
        u.tm = Math.max(Math.max(lSon.tm, rSon.tm), lSon.rm + rSon.lm);
    }

    static void pushUp(int u) {
        up(tr[u], tr[u << 1], tr[u << 1 | 1]);
    }

    static void build(int u, int l, int r) {
        //由顶开始递归建立，会先走else中的内容，由于没给tr[u]分配空间，会有空指针异常；
        //所以要先给每个节点分配空间
        tr[u] = new Node();
        if (l == r) {
            tr[u] = new Node(l,r,w[l],w[l],w[l],w[l]);
        } else {
            tr[u].l = l;
            tr[u].r = r;
            int mid = l + r >> 1;
            build(u << 1, l, mid);
            build(u << 1 | 1, mid + 1, r);
            pushUp(u);
        }
    }

    static void update(int u, int x, int v) {
        if (tr[u].l ==x&&tr[u].r== x) {
            tr[u] = new Node(x, x, v, v, v, v);
        } else {
            int mid = tr[u].l + tr[u].r >> 1;
            if (x <= mid) {
                update(u << 1, x, v);
            } else {
                update(u << 1 | 1, x, v);
            }
            pushUp(u);
        }
    }

    static Node query(int u, int l, int r) {
        if (tr[u].l >= l && tr[u].r <= r) {
            return tr[u];
        } else {
            int mid = tr[u].l + tr[u].r >> 1;
            if (r <= mid) {
                return query(u << 1, l, r);
            } else if (l > mid) {
                return query(u << 1 | 1, l, r);
            } else {
                Node lSon = query(u << 1, l, r);
                Node rSon = query(u << 1 | 1, l, r);
                //在设一个空节点时，一定要先用new为其分配空间
                Node res = new Node();
                up(res, lSon, rSon);
                return res;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int n = nextInt(), m = nextInt();
        w = new int[n + 1];
        //由于线段树是从1号点开始建的，赋值要从下标1开始；
        for (int i = 1; i <= n; i++) {
            w[i] = nextInt();
        }
        build(1, 1, n);
        while (m-- > 0) {
            int k = nextInt(), x = nextInt(), y = nextInt();
            if (k == 1) {
                if (x > y) {
                    out.println(query(1, y, x).tm);
                }else {
                    out.println(query(1, x, y).tm);
                }
            } else {
                update(1, x, y);
            }
        }
        out.flush();
    }
}
