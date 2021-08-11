package AcWing889满足条件的01序列;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/891/
 * 卡特兰数
 */
public class CattleyaNumber {

    static Scanner sc = new Scanner(System.in);
    static final int N = 200010, MOD = (int) 1e9 + 7;
    static int[] f = new int[N], inf = new int[N];

    static int qim(int a, int b) {
        int res = 1 % MOD;
        while (b != 0) {
            if ((b & 1) != 0) {
                res = (int) ((long) res * a % MOD);
            }
            a = (int) ((long) a * a % MOD);
            b >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        f[0] = inf[0] = 1;
        for (int i = 1; i < N; i++) {
            f[i] = (int) ((long) f[i - 1] * i % MOD);
            inf[i] = (int) ((long) inf[i - 1] * qim(i, MOD - 2)) % MOD;
        }
        int n = sc.nextInt();
        long res = (long) f[2 * n] * inf[n] % MOD * inf[n] % MOD * qim(n + 1, MOD - 2) % MOD;
        System.out.println(res);
    }

}
