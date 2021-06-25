package Acwing90六十四位整数乘法;

import java.io.*;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @see 位运算 https://www.acwing.com/problem/content/description/92/
 */
public class _64BitIntegerMultiplicationClass {



    public static void main(String[] args)throws Exception {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long p  =sc.nextLong();
        BigDecimal res = new BigDecimal(0);

        while (b != 0) {
            if ((b & 1) != 0) {
                res = (res.add(BigDecimal.valueOf(a))).remainder(BigDecimal.valueOf(p));

            }
            a = a*2%p;
            b>>=1;
        }
        System.out.println(res);
    }


}
