package Acwing154滑动窗口;

import java.io.BufferedInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @see 滑动窗口 https://www.acwing.com/problem/content/description/156/
 */
public class slidingWindowClass {
    static int N = 1000010;

    static int[] arr = new int[N], queue = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int arrLen = sc.nextInt();
        int queueLen = sc.nextInt();

        for (int i = 0; i < arrLen; i++) {
            arr[i] = sc.nextInt();
        }
//        System.out.println();

        int head = 0, end = -1;
        for (int i = 0; i < arrLen; i++) {
            if (head <= end && queue[head] < i - queueLen + 1) head++;
            while (head <= end && arr[queue[end]] >= arr[i]) end--;
            queue[++end] = i;
            if (i >= queueLen - 1) out.print(arr[queue[head]] + " ");

        }
        System.out.println();

        head = 0;
        end = -1;
        for (int i = 0; i < arrLen; i++) {
            if (head <= end && queue[head] < i - queueLen + 1) head++;
            while (head <= end && arr[queue[end]] <= arr[i]) end--;
            queue[++end] = i;
            if (i >= queueLen - 1) out.print(arr[queue[head]] + " ");

        }
//        out.print(111111);

    }


}
