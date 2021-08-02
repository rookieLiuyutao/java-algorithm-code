package Acwing867分解质因数;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/869/
 * 质数
 */
public class DecomposePrimeFactors {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        while (n-- > 0) {
            int a = sc.nextInt();
            for (int i = 2; i <= a / i; i++) {
                if (a % i == 0) {
                    int s = 0;
                    while (a % i == 0) {
                        a /= i;
                        s++;
                    }
                    System.out.println(i+" "+  s);

                }
            }
            if (a>1){
                System.out.println(a+" "+1);
            }
            System.out.println();
        }
    }

}
