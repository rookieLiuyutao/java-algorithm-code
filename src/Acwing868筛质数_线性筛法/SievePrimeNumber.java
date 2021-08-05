package Acwing868筛质数_线性筛法;
/**
 * https://www.acwing.com/problem/content/870/
 * 质数
 */
import java.util.Scanner;
public class SievePrimeNumber {
    
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        boolean[]st = new boolean[n];
        int []p = new int[n];
        int count = 0;
        for(int i = 2; i <=n; i++) {
            if (!st[i]) {
                p[count++] = i;
            }
            for(int j = 0; p[j]<n; j++) {
                st[p[j]*i] = true;
                if (i % p[j] == 0) {
                    break;
                }
            }
        }
        System.out.println(count);
    }
    
}
