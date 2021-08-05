package Acwing870约数个数;

import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/872/
 */
public class ApproximateNumber {
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
            if (a>1) {
                map.put(a, map.getOrDefault(a,0)+1);
            }
        }
        System.out.println(map.keySet());
        System.out.println(map.values());
        long res = 1;
        for (int x : map.values()) {
            res = res * (x + 1) % MOD;
        }
        System.out.println(res);
    }

}
