package leetcode7整数翻转;

import java.util.Arrays;

/**
 * @see 垃圾题 https://leetcode-cn.com/problems/reverse-integer/
 */
public class reverseIntClass {
    public static int reverse(int x) {
        String ss = Integer.toString(x);
        if (x<0) {
            ss=ss.substring(1);
        }
        StringBuilder s = new StringBuilder(ss);
        long y=  Long.parseLong(String.valueOf(s.reverse()).trim());
        if (y*-1 < Integer.MIN_VALUE  || y > Integer.MAX_VALUE) {
            return 0;
        }
        int z = Integer.parseInt(String.valueOf(s).trim());
        return x>=0? z:z*-1;
    }

    public static void main(String[] args) {
        int x = -2147483412;
        System.out.println(reverse(x));
    }
}
