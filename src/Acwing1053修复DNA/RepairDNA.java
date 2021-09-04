package Acwing1053修复DNA;

import java.util.Arrays;
import java.util.Scanner;

public class RepairDNA {
    static Scanner sc = new Scanner(System.in);
    static final int N = 1010;
    static int idx;
    static int[] ne = new int[N], q = new int[N], get_num = new int[128];
    static int[][] tr = new int[N][N], dp = new int[N][N];
    static boolean[] st = new boolean[N];

    static void insert(String str) {
        int p = 0;
        int len = str.length();
        for (int i = 0; i < len; i++) {
            int t = get_num[str.charAt(i)];
            if (tr[p][t] == 0) {
                tr[p][t] = ++idx;
            }
            p = tr[p][t];
        }
        st[p] = true;
    }

    static void build() {
        int hh = 0, tt = -1;
        for (int i = 0; i < 4; i++) {
            if (tr[0][i] != 0) {
                q[++tt] = tr[0][i];
            }
        }
        while (hh <= tt) {
            int t = q[hh++];
            for (int i = 0; i < 4; i++) {
                int p = tr[t][i];
                if (p == 0) {
                    tr[t][i] = tr[ne[t]][i];
                } else {
                    ne[p] = tr[ne[t]][i];
                    q[++tt] = p;
                    st[p] |= st[ne[p]];
                }
            }
        }
    }

    public static void main(String[] args) {
        get_num['A'] = 0;
        get_num['T'] = 1;
        get_num['G'] = 2;
        get_num['C'] = 3;
        int T = 1;
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            for (int[] ints : tr) {
                Arrays.fill(ints, 0);
            }
            Arrays.fill(ne, 0);
            Arrays.fill(st, false);
            idx = 0;
            for (int i = 0; i < n; i++) {
                String str = sc.next();
                insert(str);
            }
            String text = sc.next();
            build();
            for (int[] f : dp) {
                Arrays.fill(f, 0x3f3f);
            }
            dp[0][0] = 0;
            int m = text.length();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j <= idx; j++) {
                    for (int k = 0; k < 4; k++) {
                        if (i + 1 < m) {
                            int flag = get_num[text.charAt(i + 1)] != k ? 1 : 0;
                            int p = tr[j][k];
                            if (!st[p]) {
                                dp[i + 1][p] = Math.min(dp[i + 1][p], dp[i][j] + flag);
                            }
                        }

                    }
                }
            }
            int res = 0x3f3f;
            for (int i = 0; i <= idx; i++) {
                res = Math.min(res, dp[m][i]);
            }
            if (res == 0x3f3f) {
                res = -1;
            }
            System.out.printf("Case %d: %d\n", T++, res);
        }
    }


}
