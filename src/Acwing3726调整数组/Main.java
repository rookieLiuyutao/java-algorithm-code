package Acwing3726调整数组;

import java.io.*;
import java.util.Scanner;

/**
 * @see https://www.acwing.com/problem/content/3729/
 */
public class Main {

    static int N = 110;
    static int[] arr;

    public static void main(String[] args)throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int count=1;
            arr = new int[n];
            for(int i = 0; i <n; i++) {
              arr[i]  = sc.nextInt();
            }
            int s = arr[0]%2;
            for(int i = 1; i <n; i++) {
              if (arr[i]%2== s){
                  count++;
              }

            }
            if (count == n ) {
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }


    }


}
