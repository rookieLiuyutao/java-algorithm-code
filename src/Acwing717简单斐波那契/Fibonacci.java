package Acwing717简单斐波那契;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/719/
 */
public class Fibonacci {

    static Scanner sc = new Scanner(System.in);
    static int n ;
    public static void main(String[] args) {
        n = sc.nextInt();
        int []ans = new int[n];
        for(int i = 0; i <n; i++) {
          if (i==0){
              ans[i] = 0;
          }else if (i==1){
              ans[i] = 1;
          }else {
              ans[i] = ans[i-1]+ans[i-2];
          }
        }
        for (int x:ans){
            System.out.print(x+" ");
        }

    }

}
