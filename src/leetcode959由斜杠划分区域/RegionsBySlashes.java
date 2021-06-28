package leetcode959由斜杠划分区域;

import java.util.HashSet;

/**
 * @see 并查集 https://leetcode-cn.com/problems/regions-cut-by-slashes/
 */
public class RegionsBySlashes {

    int[] p;
    int n;

    int find(int x) {
        if (x != p[x]) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    /**
     * 将每个格子划分的4个小格子编号
     * 同时，这也是多维数组转化成一维数组的编号方法
     * 对于n维数组f(0,1,....,n) 的某个坐标f(i,j,...z),其在1维数组的坐标是:((i*j的维度+j)*k的维度+l)...
     *
     * @param i
     * @param j
     * @param k
     * @return
     */
    int get(int i, int j, int k) {
        return (i * n + j) * 4 + k;
    }

    public int regionsBySlashes(String[] grid) {
        n = grid.length;
        int num = n * n * 4;
        p = new int[num];
        for (int i = 0; i < num; i++) {
            p[i] = i;
        }
        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                for (int k = 0; k < 4; k++) {
                    int x = i + dx[k], y = j + dy[k];
                    if (x >= 0 && x < n && y >= 0 && y < n) {
                        p[find(get(i, j, k))] = find(get(x, y, k ^ 2));
                    }
                }
                if (grid[i].charAt(j) != '/') {
                    p[find(get(i, j, 0))] = find(get(i, j, 1));
                    p[find(get(i, j, 2))] = find(get(i, j, 3));
                }
                if (grid[i].charAt(j) != '\\') {
                    p[find(get(i, j, 1))] = find(get(i, j, 2));
                    p[find(get(i, j, 0))] = find(get(i, j, 3));
                }
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < num; i++) {
            set.add(find(i));
        }
        return set.size();
    }

}
