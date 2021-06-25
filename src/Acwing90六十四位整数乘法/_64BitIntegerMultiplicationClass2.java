package Acwing90六十四位整数乘法;

import java.math.BigDecimal;
import java.util.Scanner;

public class _64BitIntegerMultiplicationClass2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigDecimal a = new BigDecimal(sc.next());
        BigDecimal b = new BigDecimal(sc.next());
        BigDecimal p = new BigDecimal(sc.next());
        BigDecimal res = a.multiply(b).remainder(p);

        System.out.println(res);
    }
}
