package Acwing860染色法判定二分图;

import java.io.*;
import java.util.Arrays;

/**
 * https://www.acwing.com/problem/content/description/862/
 */
public class DyeingMethodToDetermineTheBipartiteGraph {

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
    static final int N = 100010;
    static int []h = new int[N],e = new int[N],ne = new int[N],color = new int[N];
    static int m,n,idx;
    static void add(int a,int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }



    static boolean dfs(int u,int c){
        color[u] = c;
        for (int i = h[u];i!=-1;i = ne[i]){
            int j = e[i];
            if (color[j] == 0) {
                if (!dfs(j,3-c)){
                    return false;
                }
            }else if (color[j]==c){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args)throws Exception {
        n = nextInt();m = nextInt();
        Arrays.fill(h,-1);
        while (m-- > 0) {
            int a = nextInt(),b = nextInt();
            add(a,b);add(b,a);
        }
        boolean flag = true;
        for(int i = 1; i <=n; i++) {
            if (color[i] == 0) {
                if (!dfs(i,1)){
                    flag = false;
                    break;
                }
            }
        }
        if (flag){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
    }

}
