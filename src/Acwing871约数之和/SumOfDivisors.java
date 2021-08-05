package Acwing871约数之和;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/description/873/
 */
public class SumOfDivisors {

    static final int MOD = (int) 1e9 + 7;
    static Scanner sc = new Scanner(System.in);
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        int n = sc.nextInt();
        while (n-- > 0) {
            int a = sc.nextInt();
            for (int i = 2; i <= a / i; i++) {
                while (a % i == 0) {
                    a /= i;
                    map.put(i, map.getOrDefault(i, 0) + 1);
                }
            }
            if (a > 1) {
                map.put(a, map.getOrDefault(a, 0) + 1);
            }
        }

        long res = 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            long t = 1;
            int x = entry.getKey(), y = entry.getValue();
            while (y-- > 0) {
                t = (t * x + 1) % MOD;
            }
            res = res * t % MOD;
        }
        System.out.println(res);
    }

}
