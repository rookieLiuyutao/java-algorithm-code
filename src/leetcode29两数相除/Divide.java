package leetcode29两数相除;

import java.util.ArrayList;

/**
 * 倍增 快速幂
 * https://leetcode-cn.com/problems/divide-two-integers/
 */
public class Divide {

    public int divide(int x, int y) {
        ArrayList<Long> list = new ArrayList<>();
        boolean isFu = x < 0 && y > 0 || x > 0 && y < 0;
        long a = x,b = y;
        if (a < 0) {
            a = -a;
        }
        if (b < 0) {
            b = -b;
        }
        for (long i = b; i <= a; i += i) {
            list.add(i);
        }
        long res = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (a >= list.get(i)) {
                a -= list.get(i);
                res += 1L << i;
            }
        }
        if (isFu) {
            res = -res;
        }
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(new Divide().divide(-2147483648,-1));
    }
}
