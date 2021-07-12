package leetcode986区间列表的交集;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/interval-list-intersections/
 */
public class IntervalIntersection {

    public int[][] intervalIntersection(int[][] a, int[][] b) {
        List<int[]> res = new ArrayList<>();
        int n = a.length, m = b.length;
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (a[i][1] >= b[j][0] && a[i][0] <= b[j][1]) {
                res.add(new int[]{Math.max(a[i][0], b[j][0]), Math.min(a[i][1], b[j][1])});
            }
            if (a[i][1] < b[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

}
