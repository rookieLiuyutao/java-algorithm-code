package ccf201604_1折点计数;

import java.util.Scanner;

public class BreakpointCount {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int []a = new int[n];
        for(int i = 0; i <n; i++) {
          a[i] = sc.nextInt();
        }
        int res = 0;
        for(int i = 1; i <n-1; i++) {
          if ((a[i-1]>a[i]&&a[i]<a[i+1])||(a[i-1]<a[i]&&a[i+1]<a[i])){
              res++;
          }
        }
        System.out.println(res);
    }

}
