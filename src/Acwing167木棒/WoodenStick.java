package Acwing167木棒;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

/**
 * https://www.acwing.com/problem/content/169/
 */
public class WoodenStick {

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

    static final int N = 70;
    static Integer[] w = new Integer[N];
    static boolean[] st = new boolean[N];
    static int n, sum, len = 1;

    /**
     * @param u     当前大棍的数量
     * @param l     当前棍枚举到了哪个长度
     * @param start 从哪根小棍开始
     * @return 当前枚举的大棍长度是否成立
     */
    static boolean dfs(int u, int l, int start) {
        if (u * len == sum) {
            return true;
        }
        if (l == len) {
            return dfs(u + 1, 0, 0);
        }
        for (int i = start; i < n; i++) {
            if (st[i]) {
                continue;
            }
            if (w[i] + l > len) {
                continue;
            }
            st[i] = true;
            if (dfs(u,l+w[i],i+1)){
                return true;
            }
            st[i] = false;
            if (l == 0) {
                return false;
            }
            if (l + w[i] == len) {
                return false;
            }
            int j = i;
            while (j+1<n&& w[j].equals(w[i])){
                j++;
            }
            i = j;
        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        while (true) {
            Arrays.fill(st,false);
            len = 1;
            sum = 0;
            n = nextInt();
            if (n == 0) {
                break;
            }

            for (int i = 0; i < n; i++) {
                w[i] = nextInt();
                sum += w[i];
            }
            Arrays.sort(w, 0, n, Collections.reverseOrder());
            System.out.println(Arrays.toString(w));
            while (true) {
                if (sum % len == 0) {
                    if (dfs(0, 0, 0)) {
                        out.println(len);
                        break;
                    }
                }
                len++;
            }
        }
        out.flush();
    }

}
