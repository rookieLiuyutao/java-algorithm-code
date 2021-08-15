package ccf201409_2画图;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/3206/
 */
public class Drawing {

    static boolean[][] g = new boolean[100][100];
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        while (n-- > 0) {
            int x1 = sc.nextInt(),y1 = sc.nextInt(),x2 = sc.nextInt(),y2 = sc.nextInt();
            for(int i = x1; i <x2; i++) {
              for(int j = y1; j <y2; j++) {
                g[i][j] = true;
              }
            }
        }
        int res = 0;
        for(int i = 0; i <100; i++) {
          for(int j = 0; j <100; j++) {
            if (g[i][j]){
                res++;
            }
          }
        }
        System.out.println(res);
    }

}
