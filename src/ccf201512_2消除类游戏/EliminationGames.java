package ccf201512_2消除类游戏;
/**
 * https://www.acwing.com/problem/content/3226/
 * 多指针模拟
 */

import java.util.Scanner;

public class EliminationGames {

    static Scanner sc = new Scanner(System.in);
    static int [][]g = new int[33][33];
    static boolean[][] st = new boolean[33][33];

    public static void main(String[] args) {
        int n = sc.nextInt(),m = sc.nextInt();
        for(int i = 0; i <n; i++) {
          for(int j = 0; j <m; j++) {
            g[i][j] = sc.nextInt();
          }
        }
        for(int i = 0; i <n; i++) {
          for(int j = 0; j <m; j++) {
            int x = g[i][j],l = j,r = j,u = i,d = i;
            while (l>=0&&g[i][l]==x)l--;
            while (r<m&&g[i][r]==x)r++;
            while (u>=0&&g[u][j]==x)u--;
            while (d<n&&g[d][j]==x)d++;
            if (r-l-1>=3||d-u-1>=3){
                st[i][j] = true;
            }
          }
        }
        for(int i = 0; i <n; i++) {
            for(int j = 0; j <m; j++) {
                if (st[i][j]){
                    System.out.print(0+" ");
                }else {
                    System.out.print(g[i][j]+" ");
                }
            }
            System.out.println();
        }
    }

}
