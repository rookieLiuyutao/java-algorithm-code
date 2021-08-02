package Acwing868筛质数_埃式筛法;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/870/
 * 质数
 */
public class SievePrime {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] p = new int[n + 1];
        //布尔数组的默认值为false
        boolean[] st = new boolean[n + 1];

        int count = 0;
        for(int i = 2; i <=n; i++) {
            if (!st[i]){
                //p中保存小于n的所有质数
                p[count++] = n;
                for(int j = i+i; j <=n; j++) {
                  st[j] = true;
                }
            }
        }
        System.out.println(count);
        System.out.println(Arrays.toString(p));
    }

}
