package Acwing1275最大数;

import java.io.*;

/**
 * https://www.luogu.com.cn/problem/P1198
 */
public class MaximumNumber {
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
    static final int N = 200010;
    static class Node{
        int l,r,v;

        public Node(int l, int r) {
            this.l = l;
            this.r = r;
        }

        public Node(int l, int r, int v) {
            this.l = l;
            this.r = r;
            this.v = v;
        }
    }
    static Node[]tr = new Node[4*N];

    /**
     * 由子节点更新父节点的值
     * @param u
     */
    static void pushUp(int u){
        tr[u].v = Math.max(tr[u << 1].v, tr[u << 1 | 1].v);
    }

    /**
     * 在[l,r]上建立一颗线段树
     * @param u
     * @param l
     * @param r
     */
    static void build(int u,int l,int r){
        tr[u] = new Node(l,r);
        if (l == r) {
            return;
        }else {
            int mid = l+r>>1;
            build(u<<1,l,mid);
            build(u<<1|1,mid+1,r);
            pushUp(u);
        }
    }

    /**
     * 查询某区间[l,r]的值
     * @param u
     * @param l
     * @param r
     * @return
     */
    static int query(int u,int l,int r){
        if (tr[u].l>=l&&tr[u].r<=r){
            return tr[u].v;
        }else {
            int mid = tr[u].l+tr[u].r>>1;
            int res = 0;
            if (l<=mid){
                res = query(u<<1,l,r);
            }
            if (r > mid) {
                 res = Math.max(res, query(u << 1 | 1, l, r));
            }
            return res;
        }
    }

    /**
     * 更新单个节点的值
     * @param u
     * @param x
     * @param v
     */
    static void update(int u,int x,int v){
        //若为叶子节点
        if (tr[u].l == x && tr[u].r == x) {
            tr[u].v = v;
        }else {
            int mid = tr[u].l+tr[u].r>>1;
            if (x <= mid) {
                update(u<<1,x,v);
            }else {
                update(u<<1|1,x,v);
            }
            pushUp(u);
        }

    }

    public static void main(String[] args)throws Exception {
        int m = nextInt(),d = nextInt();
        int n = 0,last = 0;
        build(1,1,m);
        while (m-- > 0) {
            String op = next();
            int x = nextInt();
            if ("Q".equals(op)){
                last = query(1,n-x+1,n);
                out.println(last);
            }else {
                update(1,n+1,(last+x)%d);
                n++;
            }
        }
        out.flush();
    }
}
