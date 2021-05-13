package leetcode633平方数之和;

/**
 * @see 数学题 https://leetcode-cn.com/problems/sum-of-square-numbers/
 */
import java.util.*;

public class squareNumberClass {
    public static boolean judgeSquareSum1(int c) {
        for (long a = 0; a * a <= c; a++) {
            long bb = c - a * a;
            int b = (int) Math.sqrt(bb);
            if ((long) b * b == bb) {
                return true;
            }
        }
        return false;
    }

    public static boolean judgeSquareSum2(int c) {
        int max  = (int) Math.sqrt(c);
        for (int i = 0; i <= max; i++) {
            int b = (int)Math.sqrt(c-i*i);
            if (i*i+b*b==c) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("方法1：" +judgeSquareSum1(n));
        System.out.println("方法2：" +judgeSquareSum2(n));
    }

}





