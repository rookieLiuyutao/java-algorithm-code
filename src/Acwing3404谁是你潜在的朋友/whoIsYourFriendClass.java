package Acwing3404谁是你潜在的朋友;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @see 哈希表 https://www.acwing.com/problem/content/3407/
 */

public class whoIsYourFriendClass {

    static final int N = 210;
    static int[] book = new int[N];
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            book[i] = sc.nextInt();
            map.put(book[i], map.getOrDefault(book[i], 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            if (map.get(book[i]) == 1) {
                System.out.println("BeiJu");
            } else {
                System.out.println(map.get(book[i]) - 1);
            }
        }
    }

}
