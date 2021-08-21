package ccf201604_2俄罗斯方块;

import java.util.Arrays;
import java.util.Scanner;

public class Tetris {
    static Scanner sc = new Scanner(System.in);
    static int [][]g = new int[20][20];
    static int [][]s = new int[20][20];
    static int [][]p = new int[4][4];
    static boolean draw(int x,int y){
        for(int i = 0; i <16; i++) {
            System.arraycopy(g[i], 0, s[i], 0, 10);
        }
        for(int i = 0; i <4; i++) {
            for(int j = 0; j <4; j++) {
                if (p[i][j] != 0) {
                    int a = x+i,b = y+j;
                    s[a][b]++;
                    if (s[a][b] == 2) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        for(int i = 0; i <15; i++) {
            for(int j = 0; j <10; j++) {
                g[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i <10; i++) {
          g[15][i] = 1;
        }
        for(int i = 0; i <4; i++) {
            for(int j = 0; j <4; j++) {
                p[i][j] = sc.nextInt();
            }
        }
        int n = sc.nextInt();

        for(int i = 0; ; i++) {
          if (draw(i,n-1)){
              draw(i-1,n-1);
              break;
          }
        }
        for(int i = 0; i <15; i++) {
            for(int j = 0; j <10; j++) {
                System.out.print(s[i][j]);
            }
            System.out.println();
        }

    }

}
