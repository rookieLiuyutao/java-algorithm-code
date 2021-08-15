package ccf201409_1相邻数对;
/**
 * https://www.acwing.com/problem/content/3205/
 */

import java.util.Scanner;

public class AdjacentPairs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []a = new int[n];
        int res = 0;
        for(int i = 0; i <n; i++) {
            a[i] = sc.nextInt();
          for(int j = 0; j <i; j++) {
              if (Math.abs(a[i] - a[j]) == 1) {
                  res++;
              }
          }
            System.out.println(res);
        }
    }

}
