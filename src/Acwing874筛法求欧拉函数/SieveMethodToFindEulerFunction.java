package Acwing874筛法求欧拉函数;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/876/
 *
 */
public class SieveMethodToFindEulerFunction {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        long startTime = System.currentTimeMillis();
        int count = 0;
        int[] eh = new int[n + 1], p = new int[n + 1];
        boolean[] st = new boolean[n + 1];
        eh[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (!st[i]) {
                p[count++] = i;
                eh[i] = i - 1;
            }
            for (int j = 0; p[j] <= n / i; j++) {
                st[p[j] * i] = true;
                if (i % p[j] == 0) {
                    eh[p[j] * i] = p[j] * eh[i];
                    break;
                }
                eh[p[j] * i] = eh[i] * (p[j] - 1);

            }
        }
        long res = 0;
        for (int i = 1; i <= n; i++) {
            res += eh[i];
        }
        System.out.println(res);
        long endT = System.currentTimeMillis();
        System.out.println(endT-startTime+"ms");
    }

}
