package leetcode190翻转二进制数;

/**
 * @see 二进制 https://leetcode-cn.com/problems/reverse-bits/
 */
public class everseBit {
    public static int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res << 1) + (n >> i & 1);
        }
        return res;
    }

    public static void main(String[] args) {
       int n= 0b00000010100101000001111010011100;
        System.out.println(reverseBits(n));
    }

}

