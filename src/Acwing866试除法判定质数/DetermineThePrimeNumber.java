package Acwing866试除法判定质数;

/**
 * 质数
 * https://www.acwing.com/problem/content/868/
 */

import java.util.Scanner;

public class DetermineThePrimeNumber {
    static Scanner sc = new Scanner(System.in);
    static boolean isPrime(int n){
        for(int i = 2; i <=n/i; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int n = sc.nextInt();
        while (n-- > 0) {
            int a = sc.nextInt();
            if (isPrime(a)){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }

    }

}
