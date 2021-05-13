package leetcode1720解码异或后的数组;

/**
 * @see 异或 https://leetcode-cn.com/problems/decode-xored-array/
 */
public class decodeClass {
    /**
     * 异或运算有“周期性”
     * 相同数值异或，结果为 0
     * 任意数值与 0 进行异或，结果为数值本身
     * 异或本身满足交换律
     * @param encoded
     * @param first
     * @return
     */
    public int[] decode(int[] encoded, int first) {
        int n = encoded.length;
        int[] res  = new int[n+1];
        res[0] = first;
        for(int i = 0; i <n; i++) {
          res[i+1] = encoded[i]^ res[i];
        }
        return res;
    }


}
