package Acwing10有依赖的背包问题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acwing.com/solution/content/5014/
 */
public class DependentKnapsackProblem {

    static Scanner sc = new Scanner(System.in);
    static final int N = 110;
    static int n, m, idx;
    static int[] h = new int[N], ne = new int[N], e = new int[N], w = new int[N], v = new int[N];
    static int [][]dp = new int[N][N];
    static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    static void dfs(int u) {
        for (int i = h[u]; i != -1; i = ne[i]) {
            int son = e[i];
            dfs(son);
            for (int j = m - v[u]; j >= 0; j--) {
                for (int k = 0; k <= j; k++) {
                    dp[u][j] = Math.max(dp[u][j], dp[u][j-k] + dp[son][k]);
                }
            }
        }
        for(int i = m; i >=v[u]; i--) {
          dp[u][i] = Math.max(dp[u][i],dp[u][i-v[u]]+w[u]);
        }
        for(int i = 0; i <v[u]; i++) {
          dp[u][i] = 0;
        }
    }

    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();
        int root = -1;
        Arrays.fill(h, -1);
        for (int i = 1; i <= n; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
            int p = sc.nextInt();
            if (p == -1) {
                root = i;
            } else {
                add(root, i);
            }
        }
        dfs(root);
        System.out.println(dp[root][m]);
    }

}
