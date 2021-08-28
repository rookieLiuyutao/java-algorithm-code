package Acwing851spfa求最短路;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * https://www.acwing.com/problem/content/853/
 */
public class SpfaFindTheShortestPath {

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
    static final int N = 100010,INF = 0x3f3f3f3f;
    static int []e = new int[N],ne = new int[N],h = new int[N],w = new int[N],dis = new int[N];
    static int n,m,idx;
    static boolean []st = new boolean[N];
    static ArrayDeque<Integer>q = new ArrayDeque<>();
    static void add(int a,int b,int c){
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    static void spfa(){
        Arrays.fill(dis,INF);
        dis[1] = 0;
        q.add(1);
        st[1] = true;
        while (!q.isEmpty()){
            int t = q.poll();
            for (int i = h[t];i!=-1;i = ne[i]){
                int j = e[i];
                if (dis[j]>dis[t]+w[i]){
                    dis[j] = dis[t]+w[i];
                    if (!st[j]){
                        q.add(j);
                        st[j] = true;
                    }
                }
            }
        }
        if (dis[n]==INF){
            System.out.println("impossible");
        }else{
            System.out.println(dis[n]);
        }
    }

    public static void main(String[] args)throws Exception {
        n = nextInt();
        m = nextInt();
        Arrays.fill(h,-1);
        while (m-- > 0) {
            int a = nextInt(),b = nextInt(),c = nextInt();
            add(a,b,c);
        }
        spfa();
    }

}
