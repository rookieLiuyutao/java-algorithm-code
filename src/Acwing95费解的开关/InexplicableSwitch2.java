package Acwing95费解的开关;



import java.util.Arrays;
import java.util.Scanner;

/**
 * @see 递推 https://www.acwing.com/activity/content/19/
 */
public class InexplicableSwitch2 {

    static Scanner sc = new Scanner(System.in);
    static final int N = 6;
    static char[][] g = new char[N][N], temp = new char[N][N];
    static int[] dx = {-1, 0, 1, 0, 0}, dy = {0, 1, 0, -1, 0};

    static void turn(int x, int y) {
        for (int i = 0; i < 5; i++) {

            int a = x + dx[i], b = y + dy[i];
            if (a < 0 || a >= 5 || b < 0 || b >= 5) {
                continue;
            }
            g[a][b] ^= 1;

        }
    }

    public static void main(String[] args) throws Exception {

        int T = sc.nextInt();
        while (T-- > 0) {
            for (int i = 0; i < 5; i++) {
                String s = sc.next();
                // System.out.println(s);
                for (int j = 0; j < 5; j++) {
                    temp[i][j] = s.charAt(j);
                    // g[i][j] = temp[i][j];
                }
            }

            int res = 100;
            for (int op = 0; op < 32; op++) {
                for(int i = 0; i <5; i++) {
                    System.arraycopy(temp[i], 0, g[i], 0, 5);
                }
                int step = 0;
                for (int i = 0; i < 5; i++) {
                    if ((op >> i & 1) !=0) {
                        step++;
                        turn(0, i);
                    }
                }
                for (int i = 0; i < 4; i++) {

                    for (int j = 0; j < 5; j++) {
                        if (g[i][j] == '0') {
                            step++;
                            turn(i + 1, j);
                        }
                    }

                }
                boolean dark = false;
                for (int i = 0; i < 5; i++) {
                    if (g[4][i] == '0') {
                        dark = true;
                        break;
                    }
                }
                if (!dark) {
                    res = Math.min(res, step);
                }

            }
            if (res > 6) {
                res = -1;
            }
            System.out.println(res);
        }

    }

}
