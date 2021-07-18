package Acwing187导弹防御系统;

import java.util.Arrays;
import java.util.Scanner;
/**
 * dfs求最小步数
 * https://www.acwing.com/problem/content/189/
 */
public class MissileDefenseSystem {
    static Scanner sc = new Scanner(System.in);
    static final int N = 55;
    static int []arr = new int[N],up = new int[N],down = new int[N];
    static int res,n;

    /**
     *
     * @param u 当前枚举的数
     * @param sUp 以当前数为结尾上升子序列的个数
     * @param sDown 以当前数为结尾下降子序列的个数
     */
    static void dfs(int u,int sUp,int sDown){
        if (sUp+sDown>=res){
            return;
        }
        if (u==n){
            res = sUp+sDown;
            return;
        }
        int k = 0;
        while (k<sUp&&up[k]>=arr[u]){
            k++;
        }
        int t = up[k];
        up[k] = arr[u];
        if(k<sUp){
            dfs(u+1,sUp,sDown);
        }else {
            dfs(u+1,sUp+1,sDown);
        }
        up[k] = t;
        k = 0;
        while (k<sDown&&down[k]<=arr[u]){
            k++;
        }
        t = down[k];
        down[k] = arr[u];
        if (k<sDown){
            dfs(u+1,sUp,sDown);
        }else {
            dfs(u+1,sUp,sDown+1);
        }
        down[k] = t;

    }

    public static void main(String[] args) {
        while (sc.hasNext()){
             n = sc.nextInt();
            if (n == 0) {
                break;
            }
            for(int i = 0; i <n; i++) {
              arr[i] = sc.nextInt();
            }
            res = n;
            dfs(0,0,0);
            System.out.println(res);
        }

    }



}
