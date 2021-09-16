package Acwing327玉米田;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/329/
 */
public class YuMi {
    static final int N = 14,MOD = 100000000;
    static Scanner sc = new Scanner(System.in);
    static int[][] dp = new int[N][1 << N];
    static int[] g = new int[N];
    static ArrayList<Integer> state = new ArrayList<>();
    static ArrayList<Integer>[] head = new ArrayList[1 << N];
    static int n, m;

    static boolean check(int x) {
        for (int i = 0; i < m; i++) {
            if ((x >> i & 1) == 1 && ((x >> i + 1) & 1) == 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            int t = 0;
            for (int j = 1; j <= m; j++) {
                int x = sc.nextInt();
                if (x == 0) {
                    t+=1<<j;
                }
            }
            g[i]+=t;
        }
        //预处理出每一行没有相邻玉米的状态
        for (int i = 0; i < 1 << m; i++) {
            if (check(i)) {
                state.add(i);
            }
        }
        //预处理出行之间的合法状态
        for (int i = 0; i < state.size(); i++) {
            head[i] = new ArrayList<>();
            for (int j = 0; j < state.size(); j++) {
                if ((state.get(i) & state.get(j)) == 0) {
                    head[i].add(j);
                }
            }
        }
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < state.size(); j++) {
                if ((state.get(j) & g[i]) == 0) {
                    for (int k:head[j]){
                        dp[i][j]  = (dp[i][j]+dp[i-1][k])%MOD;
                    }
                }
            }
        }
        long res = 0;
        for(int i = 0; i <1<<m; i++) {
          res = (res+dp[n][i])%MOD;
        }
        System.out.println(res);
        System.out.println(state);
    }
}
