package Acwing3577选择数字;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @see 哈希表 https://www.acwing.com/problem/content/3580/
 */
public class Main {
    static HashSet<Integer> hashSet = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            hashSet.add(a[i]);
        }
        int m = sc.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
            hashSet.add(b[i]);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int x = a[i] + b[j];
                if (!hashSet.contains(x)) {
                    System.out.println(a[i] + " " + b[j]);
                    count++;
                    break;
                }
            }
            if (count != 0) break;


        }


    }
}
