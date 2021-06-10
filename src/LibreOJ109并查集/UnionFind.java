package LibreOJ109并查集;

import java.io.*;

/**
 * @see 并查集 https://loj.ac/p/109
 */
public class UnionFind {

    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static int nextInt() throws Exception {
        in.nextToken();
        return (int) in.nval;
    }

    static String next() throws Exception {
        in.nextToken();
        return in.sval;
    }

    static int n, m, idx=0, edge = n*2;
    static int[] p;


    static int find(int x){
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    public static void main(String[] args)throws Exception {
        n = nextInt();
        m = nextInt();
        p = new int[0x1F1E33 << 2];
        long res = 0;

        for(int i = 1; i <=n; i++) {
          p[i] = i;
        }
        while (m-- > 0) {
            int op = nextInt();
            int a = nextInt();
            int b = nextInt();
            if (op == 0) {
                p[find(a)] = p[find(b)];
            }else {
                if (find(a)==find(b)){
                    res <<= 1;
                    res |= 1;
                    res%=998244353;
                }else {
                    res <<= 1;
                    res%=998244353;
                }
            }


        }
        out.println(res%998244353);
        out.flush();
        out.close();
    }

}
