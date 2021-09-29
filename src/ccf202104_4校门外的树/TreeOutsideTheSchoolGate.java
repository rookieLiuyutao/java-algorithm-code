package ccf202104_4校门外的树;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 */
public class TreeOutsideTheSchoolGate {

    static Scanner sc = new Scanner(System.in);
    static final int MOD = (int) 1e9 + 7, M = 1010, N = 100010;
    static ArrayList<Integer>[] q = new ArrayList[N];

    static boolean[] st = new boolean[N];

    public static void main(String[] args) {
        for (int i = 0; i < N; i++) {
            q[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++) {
            for (int j = i * 2; j < N; j += i) {
                q[j].add(i);
            }
        }
        for(int i = 1; i <=10; i++) {
            System.out.println(q[i]);
        }
        int n = sc.nextInt();
        int[] a = new int[n+1];
        long[] dp = new long[n + 1];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            Arrays.fill(st, false);
            for (int j = i - 1; j >= 0; j--) {
                int d = a[i] - a[j];
                int count = 0;
                for (int k : q[d]) {
                    if (!st[k]) {
                        count++;
                        st[k] = true;
                    }
                }
                //自己本身不能用
                st[d] = true;
                dp[i] = (dp[j] * count + dp[i]) % MOD;
            }
        }
        System.out.println(dp[n-1]);
    }

}
