package AcWing243一个简单的整数问题2;

import java.io.*;

/**
 * @see 数状数组 修改一个区间的数 查询一个区间的前缀和
 * https://www.acwing.com/problem/content/244/
 */
public class Main {
    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static int nextInt() throws Exception {
        in.nextToken();
        return (int) in.nval;
    }
    static long nextLong() throws Exception {
        in.nextToken();
        return (long) in.nval;
    }

    static String next() throws Exception {
        in.nextToken();
        return in.sval;
    }

    static long[] arr, tr1, tr2;
    static int n, m;

    static void add(long[] tr, int x, long d) {
        for (int i = x; i <= n; i += -i & i) {
            tr[i] += d;
        }

    }

    static long query(long[] tr, int x) {
        long sum = 0;
        for (int i = x; i > 0; i -= i & -i) {
            sum += tr[i];
        }
        return sum;

    }

    static long pSum(int x){
        return query(tr1,x)*(x+1)-query(tr2,x);
    }

    public static void main(String[] args) throws Exception {
        n = nextInt();
        m = nextInt();
        arr = new long[n+1];
        tr1 = new long[n+1];
        tr2 = new long[n+1];
        for(int i = 1; i <=n; i++) {
          arr[i] = nextInt();
          long b = arr[i]-arr[i-1];
          add(tr1,i,b);
          add(tr2,i,  b *i);

        }
        while (m-->0){
            char c = next().charAt(0);
            if (c == 'C') {
                int l = nextInt(),r = nextInt(),d = nextInt();
                add(tr1,l,d);
                add(tr1,r+1,-d);

                add(tr2,l, (long) l *d);
                add(tr2,r+1, (long) (r + 1) *-d);
            }
            if (c == 'Q') {
                int l = nextInt(),r = nextInt();
                out.println(pSum(r)-pSum(l-1));

            }

        }
        out.flush();
    }

}
