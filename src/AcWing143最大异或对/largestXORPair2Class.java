package AcWing143最大异或对;

import java.util.Scanner;

/**
 * @see trie树 https://www.acwing.com/problem/content/description/145/
 * 暴力解法
 */

public class largestXORPair2Class {
    static int n;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n =  sc.nextInt();
        arr = new int[n];
        for(int i = 0; i <n; i++) {
          arr[i] = sc.nextInt();
        }
        int max = 0;
        for(int i = 0; i <n; i++) {
            for(int j = 0; j <n; j++) {
                 max = Math.max(max,arr[i]^arr[j]);
            }
        }
        System.out.println(max);
    }


}
