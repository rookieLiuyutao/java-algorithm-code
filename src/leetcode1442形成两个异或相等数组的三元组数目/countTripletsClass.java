package leetcode1442形成两个异或相等数组的三元组数目;

/**
 * @see 前缀和 https://leetcode-cn.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/
 */
public class countTripletsClass {

    public int countTriplets(int[] arr) {
        int count = 0;
        int n = arr.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            sum[i] = sum[i - 1] ^ arr[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                int a = sum[i]^sum[j-1];
                for (int k = 1; k <= j - 1; k++) {
                    int b = sum[j-1]^sum[k-1];
                    if (a==b) count++;
                }
            }
        }
        return count;

    }

    public static void main(String[] args) {
        int[]arr = {2,3,1,6,7};
        System.out.println(new countTripletsClass().countTriplets(arr));
    }


}
