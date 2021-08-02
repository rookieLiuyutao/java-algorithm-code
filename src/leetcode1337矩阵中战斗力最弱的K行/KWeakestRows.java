package leetcode1337矩阵中战斗力最弱的K行;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/the-k-weakest-rows-in-a-matrix/
 * 比较器排序
 */
public class KWeakestRows {

    public int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length,m = mat[0].length;
        int [][]all = new int[n][2];
        int []res = new int[k];
        for(int i = 0; i <n; i++) {
          int s = 0;
          for(int x:mat[i]){
              s+=x;
          }
          all[i] = new int[]{i,s};
        }
        Arrays.sort(all,(o1, o2) -> o1[1]==o2[1]?o1[0]-o2[0] :o1[1]-o2[1] );
        for(int i = 0; i <k; i++) {
          res[i] = all[i][0];
        }
        return res;
    }

}
