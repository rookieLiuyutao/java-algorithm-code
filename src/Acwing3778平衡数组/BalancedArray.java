package Acwing3778平衡数组;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/3781/
 */
public class BalancedArray {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(n);
            for(int i = 1; i <=n; i++) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

}
