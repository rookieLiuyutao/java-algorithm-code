package Acwing3493最大的和;

import java.util.Scanner;
/**
 * @see 双指针 滑动窗口 https://www.acwing.com/problem/content/description/3496/
 */
public class largestSumClass {
    static int N = 100010;
    static int[] arr = new int[N];
    static int[] isOn = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            isOn[i] = sc.nextInt();
        }
        long sum = 0;
        for (int i = 0; i < n; i++) {
            if (isOn[i] != 0) {
                sum += arr[i];
            }
        }
        long max = 0,window = 0;
        for (int i = 0; i < n; i++) {
//----------------实现了滑动窗口--------
            if (isOn[i] == 0) {
                window += arr[i];
            }
            if (i >= k && isOn[i - k] == 0) {
                window -= arr[i-k];
            }
//------------------------------------------
            max = Math.max(max, window);
        }
        System.out.println(sum + max);
    }
}
