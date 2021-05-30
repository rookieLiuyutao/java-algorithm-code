package Acwing3578最大中位数;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @see 二分 https://www.acwing.com/problem/content/3581/
 */
public class maximumMedianClass {
    static int n, k;

    static boolean check(int[] arr, long mid) {
        int sum = 0;
        for (int i = n >> 1; i < n; i++) {
            if (arr[i] >= mid) {
                return true;
            }
            sum += mid - arr[i];
            if (sum > k) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        long l = 1, r = (int) 2e9;
        while (l < r) {
            long mid = l + r + 1 >> 1;
            if (check(arr, mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(l);
    }
}
