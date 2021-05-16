package Acwing843n皇后;

import java.util.Scanner;

/**
 * @see 深搜 https://www.acwing.com/problem/content/845/
 */
public class nQueen2Class {
    static final int N = 20;
    static int n;
    static char[][] checkerboard;
    static boolean[] row = new boolean[N], col = new boolean[N], lDiagonal = new boolean[N], rDiagonal = new boolean[N];

    /**
     * 按行搜索：每行只能放一个皇后，所以我们枚举一行的各种情况下的放法
     *
     * @param u
     */
    static void dfs( int x, int y,int num) {
        if (y == n) {
            y = 0;
            x++;
        }
        if (x == n) {
            if (num == n) {
                for (int i = 0; i < n; i++) {
                    System.out.println(checkerboard[i]);
                }
                System.out.println();
            }
            return;
        }
        //不放棋子
        dfs(x,y+1,num);
        //放棋子
        if (!row[x] && !col[y] && !lDiagonal[x + y] && !rDiagonal[x - y + n]) {
            checkerboard[x][y] = 'Q';
            row[x] = col[y] = lDiagonal[x + y] = rDiagonal[x - y + n] = true;
            dfs(x, y + 1, num + 1);
            row[x] = col[y] = lDiagonal[x + y] = rDiagonal[x - y + n] = false;
            checkerboard[x][y] = '.';
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        checkerboard = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                checkerboard[i][j] = '.';
            }
        }
        dfs(0,0,0);
    }


}
