package Acwing873欧拉函数;
/**
 * https://www.acwing.com/problem/content/875/
 * 质数
 */

import java.util.Scanner;

public class EulerFunction {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        while (n-- > 0) {
            int a = sc.nextInt();
            int res = a;
            for (int i = 2; i <= a / i; i++) {
                if (a % i == 0) {
                    res = res/i*(i-1);
                    while (a%i==0) {
                        a/=i;
                    }
                }
            }
            if (a>1){
                res = res/a*(a+1);
            }
            System.out.println(res);
        }
    }

}
