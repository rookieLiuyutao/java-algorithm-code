package Acwing890能被整除的数;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/892/
 * 容斥原理
 */
public class DivisibleNumber {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt(), m = sc.nextInt();
        int[] p = new int[m];
        for (int i = 0; i < m; i++) {
            p[i] = sc.nextInt();
        }
        int res = 0;
        for (int i = 1; i < 1 << m; i++) {
            int t = 1, count = 0;
            for (int j = 0; j < m; j++) {
                if ((i >> j & 1) != 0) {
                    if ((long) t * p[j] != 0) {
                        t = -1;
                        break;
                    }
                    count++;
                    t *= p[j];
                }
            }
            if (t == -1) {
                continue;
            }
            if ((count & 1) != 0) {
                res += n / t;
            } else {
                res -= n / t;
            }
        }
        System.out.println(res);
    }

}
