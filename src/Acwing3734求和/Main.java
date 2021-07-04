package Acwing3734求和;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @see https://www.acwing.com/problem/content/3737/
 */
public class Main {
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
    static long l,r;
    static final int INF = (int )10e9;

    static ArrayList<Long> list = new ArrayList<>();
    static void dfs(int u,long x){
        list.add(x);
        if (u==10){
            return;
        }
        dfs(u+1,10*x+4);
        dfs(u+1,10*x+7);
    }


    public static void main(String[] args)throws Exception {
        l = nextInt();
        r = nextInt();
        dfs(0,0);
        Collections.sort(list);
        long res = 0;
        int n = list.size();
        for(int i = 1; i <n; i++) {
          long a = list.get(i-1)+1,b = list.get(i);
          res+=list.get(i)+Math.max(0,(Math.min(r,b)-Math.max(l,a)+1));
        }
        out.println(res);
        out.flush();
    }

}
