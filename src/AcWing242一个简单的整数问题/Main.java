package AcWing242一个简单的整数问题;

import java.io.*;

/**
 * @see 数状数组 修改一个区间的数 查询一个数 https://www.acwing.com/problem/content/248/
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

    static int [] arr,tr;
    static int n,m;

    /**
     * 相当于建树+修改
     * @param x
     * @param d
     */
    static void add(int x,int d){
        for (int i = x;i<n;i+=i&-i){
            tr[i]+=d;
        }
    }

    static int query(int x){
        int sum = 0;
        for (int i = x;i>0;i-=i&-i){
            sum+=tr[i];
        }
        return sum;
    }

    public static void main(String[] args)throws Exception {
        n = nextInt();
        m = nextInt();
        arr = new int[n+1];
        tr = new int[n+1];
        
        for(int i = 1; i <=n; i++) {
          arr[i] = nextInt();
          add(i,arr[i]-arr[i-1]);
        }
        while (m-- > 0) {
            char c = next().charAt(0);
            if (c=='C'){
                int l = nextInt();
                int r = nextInt();
                int d = nextInt();
                add(l,d);
                add(r+1,-d);
            }
            if (c == 'Q'){
                out.println(query(nextInt()));
            }
        }
        out.flush();
    }

}
