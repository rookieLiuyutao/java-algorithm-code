package leecode5767检查是否区域内所有整数都被覆盖;

import java.util.Arrays;
import java.util.Comparator;

public class isCoveredClass {
    public static int intervalCoverage(int n, int[] interval, int[][] arr) {
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });


        for (int i = 0; i < n; i++) {
            int j = i;
            //将选出的满足条件的区间右端点的最大值初始化为负无穷
            int maxOfRight = Integer.MIN_VALUE;
            while (j < n && arr[j][0] <= interval[0]) {
                maxOfRight = Math.max(maxOfRight, arr[i][1]);
                j++;
            }
            if (maxOfRight < interval[0]) {

                break;
            }

            //当最后一个区间的右端点小于线段的右端点，不满足条件，返回-1
            if (i == n - 1 && maxOfRight <= interval[1]) {
                break;
            }
            //将线段的左端点更新，以便下一次循环
            interval[0] = maxOfRight;
            // 更新i指针 变成j-1后经过i++，i指针就恢复为j，因为arr[j][0]不满足<=interval[0]，但是arr[j][0]可能满足下一次迭代的条件
            i = j - 1;

        }
      return 0;
    }

    public boolean isCovered(int[][] ranges, int left, int right) {
        int n = ranges.length;
        boolean haveL,haveR;

        Arrays.sort(ranges, Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < n; i++) {
            int j = i;
            //将选出的满足条件的区间右端点的最大值初始化为负无穷
            int maxOfRight = Integer.MIN_VALUE;
            while (j < n && ranges[j][0] <= left) {
                maxOfRight = Math.max(maxOfRight, ranges[i][1]);
                j++;
            }
            if (maxOfRight < left) {
                haveL=true;
                break;
            }

            //当最后一个区间的右端点小于线段的右端点，不满足条件，返回-1
            if (i == n - 1 && maxOfRight <= right) {
                return false;
            }
            //将线段的左端点更新，以便下一次循环
            left = maxOfRight;
            // 更新i指针 变成j-1后经过i++，i指针就恢复为j，因为arr[j][0]不满足<=interval[0]，但是arr[j][0]可能满足下一次迭代的条件
            i = j - 1;

        }

        return true;
    }

}
