package Acwing1184欧拉回路;

import java.io.*;
import java.util.Arrays;


/**
 * @see 图论 欧拉回路 https://loj.ac/p/10105 https://www.acwing.com/solution/content/53434/
 */
public class EulerCircuitClass {
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

    static final int N = 100010,M = 400010;
    static int[] ans , h , e , ne , dIn , dOut;
    static int type, n, m, idx, cnt;
    static boolean[] used = new boolean[M];

    static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    static void dfs(int u) {
        for (int i = h[u]; i!=-1;i = h[u]) {
            if (used[i]) { //如果边i已经被用过了 去下一条边看
                h[u]= ne[i];
                continue;
            }

            used[i] = true;

            if (type == 1) {
                used[i ^ 1] = true; //如果无向边 则把反向边也标记
            }

            int t;//点的编号  无向图时点编号=边编号/2+1 有向图时点编号=便编号+1

            if (type == 1) {
                t = i / 2 + 1;

                if ((i & 1)!=0) {
                    t = -t; //奇数边为反向边 如果 pi 为正数表示从 ve 走到 ue，否则表示从 ue 走到 ve
                }
            } else {
                t = i + 1;
            }

            int j = e[i];//边上连接的邻点
            h[u] = ne[i];
            dfs(j);// 一直走到底 把终点先压进栈 然后回溯往回走把中间及起点加进栈 最终输出结果 ans[cnt]为起点
            ans[++cnt] = t;
        }
    }


    public static void main(String[] args) throws Exception {
        type = nextInt();
        n = nextInt();
        m = nextInt();
        h = new int[n + 1];
        e = new int[m * 2 + 1];
        ne = new int[m * 2 + 1];
        ans = new int[n * 2 + 1];
        dIn = new int[n + 1];
        dOut = new int[n + 1];
        used = new boolean[m * 2 + 1];

        Arrays.fill(h, -1);

        for (int j = 0; j < m; j++) {
            int a = nextInt(), b = nextInt();
            add(a, b);
            if (type == 1) {
                add(b, a);
            }
            dIn[b]++;
            dOut[a]++;
        }
        if (type == 1) {
            for (int j = 1; j <= n; j++) {
                if ((dIn[j] + dOut[j]) % 2 == 1) {
                    out.println("NO");
                    out.flush();
                    return;
                }
            }

        } else {
            for (int j = 1; j <= n; j++) {
                if (dIn[j] != dOut[j]) {
                    out.println("NO");
                    out.flush();
                    return;
                }

            }

        }
        for (int j = 1; j <= n; j++) {
            if (h[j] != -1) {
                dfs(j);
                break;
            }
        }
//        out.println(cnt);
        if (cnt < m) {
            out.println("NO");
            out.flush();
            return;
        } else {
            out.println("YES");

        }
        for (int j = cnt; n!=1&&j > 0; j--) {
            out.print(ans[j] + " ");
        }

        out.flush();
    }
}
