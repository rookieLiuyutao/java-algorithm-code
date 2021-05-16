package Acwing94递归实现排列性枚举;

import java.util.Scanner;

/**
 * @see 深搜 https://www.acwing.com/problem/content/description/96/
 */
public class arrangementClass {
    final static int N = 10;
    static int n ;
    static int[]path  = new int[N];
    static boolean[] isUse= new boolean[N];
    static void dfs(int u){
        if (u==n){
            for(int i = 0; i <n; i++) {
                System.out.print(path[i]+" ");
            }
            System.out.println();

        }
        for(int i = 1; i <=n; i++) {
            if (!isUse[i]){
                path[u] = i;
                isUse[i] = true;
                dfs(u+1);
                isUse[i] = false;
            }


        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         n = sc.nextInt();
        dfs(0);
    }

}
