package Acwing3502不同路径数;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @see 深搜 https://www.acwing.com/problem/content/3505/
 */
public class numberOfDifferentPathsClass {
    static int N = 7;
    static int n, m, k;
    static int[][] path = new int[N][N];
    static int[] directionX = {0, 0, 1, -1};
    static int[] directionY = {1, -1, 0, 0};
    static Set<Integer> set= new HashSet<>();

    static void dfs(int start,int x,int y,int step){
        if (step>k){
            set.add(start);
        }else {
            for (int i = 0; i < 4; i++) {
                int a = directionX[i] + x;
                int b = directionY[i] + y;
                if (a >= 0 && a < n && b >= 0 && b < m ) {
                    dfs(start*10+path[a][b],a,b,step+1);
                }
            }
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        for(int i = 0; i <n; i++) {
            for(int j = 0; j <m; j++) {
                path[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i <n; i++) {
            for(int j = 0; j <m; j++) {
              int start = path[i][j] ;
              dfs(start,i,j,1);
            }
        }
        System.out.println(set.size());

    }

}
