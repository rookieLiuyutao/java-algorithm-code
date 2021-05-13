package Acwing907区间覆盖;
/**
 * @see 区间覆盖 https://www.acwing.com/solution/content/26847/
 */

import java.util.*;
;
public class intervalCoverageClass {
    public static int intervalCoverage(int n, int[] interval, int[][] arr) {
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int res = 0;
        //双指针循环
        for (int i = 0; i < n; i++) {
            int j = i;
            //将选出的满足条件的区间右端点的最大值初始化为负无穷
            int maxOfRight = Integer.MIN_VALUE;
            while (j < n && arr[j][0] <= interval[0]) {
                maxOfRight = Math.max(maxOfRight, arr[i][1]);
                j++;
            }
            if (maxOfRight < interval[0]) {
                res = -1;
                break;
            }
            res++;
            //当最后一个区间的右端点小于线段的右端点，不满足条件，返回-1
            if (i == n - 1 && maxOfRight <= interval[1]) {
                res=-1;
                break;
            }
            //将线段的左端点更新，以便下一次循环
            interval[0] = maxOfRight;
            // 更新i指针 变成j-1后经过i++，i指针就恢复为j，因为arr[j][0]不满足<=interval[0]，但是arr[j][0]可能满足下一次迭代的条件
            i = j - 1;

        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] interval = new int[2];
        for (int i = 0; i < 2; i++) {
            interval[i] = sc.nextInt();
        }
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(intervalCoverage(n, interval, arr));
    }
}
