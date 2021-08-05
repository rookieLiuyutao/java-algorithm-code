package Acwing874筛法求欧拉函数;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/876/
 */
public class SieveMethodToFindEulerFunctionAcSber {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int []eh = new int[n+1];
        long startTime = System.currentTimeMillis();
        for(int i = 1; i <=n; i++) {
          eh[i] = i;
        }
        for(int i = 2; i <=n; i++) {
          if (eh[i]==i){
              for(int j = i; j <=n; j+=i) {
                eh[j] = eh[j]/i*(i-1);
              }
          }
        }
        long res = 0;
        for(int x:eh){
            res+=x;
        }
        System.out.println(res);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime+"ms");
    }
}
