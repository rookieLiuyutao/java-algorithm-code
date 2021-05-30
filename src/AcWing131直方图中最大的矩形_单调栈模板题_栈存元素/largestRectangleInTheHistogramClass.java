package AcWing131直方图中最大的矩形_单调栈模板题_栈存元素;

import java.util.Scanner;

/**
 * @see 单调栈 https://www.acwing.com/problem/content/133/
 */
public class largestRectangleInTheHistogramClass {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            int[] height = new int[n + 2];
            int[] widthArr = new int[n + 2];
            int[] q = new int[n + 2];
            for (int i = 1; i <= n; i++) {
                height[i] = sc.nextInt();
            }
            int tt;
            long res = 0;
            tt = height[n + 1] = 0;
            for (int i = 1; i <= n + 1; i++) {
                if (height[i] > q[tt]) {
                    q[++tt] = height[i];
                    widthArr[tt] = 1;
                } else {
                    int width = 0;
                    while (height[i] < q[tt]) {
                        width += widthArr[tt];
                        res = Math.max(res, (long) width * q[tt]);
                        tt--;
                    }
                    q[++tt] = height[i];
                    widthArr[tt] = width + 1;
                }
            }
            System.out.println(res);
        }
    }
}
