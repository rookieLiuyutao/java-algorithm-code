package Acwing852spfa判断负环;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/854/
 */
public class SpfaJudgesNegativeRing {

    static Scanner sc = new Scanner(System.in);
    static final int N = 100010;
    static int[] e = new int[N], ne = new int[N], h = new int[N], w = new int[N], dis = new int[N], cnt = new int[N];
    static boolean[] st = new boolean[N];
    static int n, m, idx;
    static ArrayDeque<Integer> q = new ArrayDeque<>();

    static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    static boolean spfaJudge() {
        for (int i = 1; i <= n; i++) {
            q.add(i);
            st[i] = true;
        }
        while (!q.isEmpty()) {
            int t = q.poll();
            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = ne[i];
                if (dis[j] > dis[t] + w[i]) {
                    dis[j] = dis[t] + w[i];
                    cnt[j] = cnt[i] + 1;
                }
                if (cnt[i] >= n) {
                    return true;
                }
                if (!st[j]){
                    q.add(j);
                    st[j] = true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();
        Arrays.fill(h, -1);
        while (m-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            add(a, b, c);
        }
        if (spfaJudge()){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
    }

}
