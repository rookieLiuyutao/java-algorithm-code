package AcWing1282搜索关键词;

import java.io.*;

public class SearchKeyword {
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

    static final int N = 1000010;
    static int[][] tire = new int[N][26];
    static int[] ne = new int[N], cnt = new int[N], q = new int[N];
    static int idx, n;

    static void insert(String str) {
        int p = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int t = c - 'a';
            if (tire[p][t] == 0) {
                tire[p][t] = ++idx;
            }
            p = tire[p][t];
        }
        cnt[p]++;
    }

    static void build() {
        int tt = -1, hh = 0;
        for (int i = 0; i < 26; i++) {
            if (tire[0][i] > 0) {
                q[++tt] = tire[0][i];
            }
        }
        while (hh <= tt) {
            int t = q[hh++];
            for (int i = 0; i < 26; i++) {
                int p = tire[t][i];
                if (p == 0) {
                    tire[t][i] = tire[ne[t]][i];
                } else {
                    ne[p] = tire[ne[t]][i];
                    q[++tt] = p;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int n = nextInt();
        while (n-- > 0) {
            String s = next();
            insert(s);
        }
        String text = next();
        build();
        int res = 0;
        for (int i = 0, j = 0; i < text.length(); i++) {
            int t = text.charAt(i) - 'a';
            while (j != 0 && tire[j][t] == 0) {
                j = ne[j];
            }
            if (tire[j][t] != 0) {
                j = tire[j][t];
            }
            int p = j;
            while (p != 0) {
                res+=cnt[p];
                cnt[p] = 0;
                p = ne[p];
            }
        }
        System.out.println(res);
    }

}
