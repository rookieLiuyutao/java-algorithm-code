package Acwing860染色法判定二分图;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * https://www.acwing.com/problem/content/description/862/
 */
public class DyeingMethodToDetermineTheBipartiteGraph2 {

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
    static final int N = 100010,M = 2*N;
    static int []h = new int[N],e = new int[M],ne = new int[M],color = new int[N];
    static int m,n,idx;
    static void add(int a,int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
    static ArrayDeque<Integer>q = new ArrayDeque<>();


    static boolean bfs(){
        for(int u = 1; u <=n; u++) {
            if (color[u] == 0) {
                color[u] = 1;
                q.add(u);
                while (!q.isEmpty()){
                    int t = q.poll();
                    for(int i = h[t]; i!=-1; i = ne[i]) {
                      int j = e[i];
                        if (color[j] == 0) {
                            color[j]=3-color[t];
                            q.add(j);
                        }else if (color[j]==color[t]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args)throws Exception {
        n = nextInt();
        m = nextInt();
        Arrays.fill(h,-1);
        while (m-- > 0) {
            int a = nextInt(),b = nextInt();
            add(a,b);add(b,a);
        }
        if (bfs()){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
    }

}
