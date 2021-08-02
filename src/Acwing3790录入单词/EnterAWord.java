package Acwing3790录入单词;

import java.util.Scanner;

public class EnterAWord {

    static Scanner sc = new Scanner(System.in);
    static int[] a = new int[100010];

    public static void main(String[] args) {
        int n = sc.nextInt();
        int c = sc.nextInt();
        int res = 0, last = 0;
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
          if (a[i]-last>c) {
              res = 0;
          }
          res++;
          last = a[i];
        }
        System.out.println(res);
    }

}
