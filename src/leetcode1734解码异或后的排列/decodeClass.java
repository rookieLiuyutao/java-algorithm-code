package leetcode1734解码异或后的排列;

import java.util.Arrays;

/**
 * @see 异或 https://leetcode-cn.com/problems/decode-xored-permutation/
 */

public class decodeClass {
    public int[] decode(int[] encoded) {
        int m = encoded.length;
        int n = m + 1;
        int sum = 0;
        int[] ans = new int[n];
        for (int i = 1; i <= n; i++) {
            sum ^= i;
//            System.out.println(i);
        }
        int jiSum = 0;
        for (int i = 1; i < m; i += 2) {
            jiSum ^= encoded[i];
        }
        ans[0] = sum ^ jiSum;
        for (int i = 0; i < m; i++) {
            ans[i + 1] = encoded[i] ^ ans[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {6, 5, 4, 6};
        System.out.println(Arrays.toString(new decodeClass().decode(arr)));
    }

}
