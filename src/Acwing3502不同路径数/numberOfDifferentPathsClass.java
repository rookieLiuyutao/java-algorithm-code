package Acwing3502不同路径数;

import java.util.Scanner;

/**
 * @see dfs https://www.acwing.com/problem/content/3505/
 */
public class numberOfDifferentPathsClass {
    static int N = 7;
    static int n, m, k;
    static int[][] path = new int[N][N];
    static void dfs(int start,int d,int k){
        if (k==0) return;


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
        int start;
        for(int i = 0; i <n; i++) {
            for(int j = 0; j <m; j++) {
              start = path[i][j] ;

            }
        }


    }

}
