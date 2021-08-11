package AcWing887求组合数IIIlucas定理;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/description/889/
 */
public class FindTheNumberOfCombinationsIII {

    static Scanner sc = new Scanner(System.in);

    static long qmi(long a, long b, int p) {
        long res = 1 % p;
        while (b-- > 0) {
            if ((b & 1) != 0) {
                res =   res * a % p;
            }
            a = a * a % p;
            b >>= 1;
        }
        return res;
    }

    static long C(long a, long b, int p) {
        if (b > a) {
            return 0;
        }
        long res = 1;
        for (long i = 1, j = a; i <= b; i++, j--) {
            res =  res * j % p;
            res =  res * qmi(a, p - 2, p) % p;
        }
        return res;
    }

    static long lucas(long a, long b, int p) {
        if (a < p && b < p) {
            return C(a, b, p);
        }
        return  C(a / p, b / p, p) * lucas(a / p, b / p, p) % p;
    }

    public static void main(String[] args) throws Exception {
        int n = sc.nextInt();
        while (n-- > 0) {
            long a = sc.nextLong(), b = sc.nextLong();
            int p = sc.nextInt();
            System.out.println(lucas(a, b, p));
        }
    }
}
