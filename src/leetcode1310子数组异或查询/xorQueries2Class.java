package leetcode1310子数组异或查询;
/**
 * https://leetcode-cn.com/problems/xor-queries-of-a-subarray/
 */

import java.util.Arrays;

public class xorQueries2Class {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int m = queries.length;
        int[] sum = new int[n + 1];
        //因为前缀和模板：
//        S[i] = a[1] + a[2] + ... a[i]
//        a[l] + ... + a[r] = S[r] - S[l - 1]
        //l-1处可能发生数组越界，所以在建立前缀和数组式，会在最前边留出一位0
        for (int i = 1; i <= n; i++) {
            sum[i] ^= sum[i - 1] ^ arr[i - 1];
        }
        System.out.println("前缀和数组：" + Arrays.toString(sum));
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            //所以在应用时，r,l需要整体右移一位
            //       原： a[l] + ... + a[r] = S[r] - S[l - 1]
            //数组加长后：  a[l] + ... + a[r] = S[r + 1] - S[l]
            ans[i] = sum[queries[i][1] + 1] ^ sum[queries[i][0]];
        }


        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 8};
        int[][] queryArr = {{0, 1}, {1, 2}, {0, 3}, {3, 3}};

        System.out.println(Arrays.toString(new xorQueries2Class().xorQueries(arr, queryArr)));
    }

}
