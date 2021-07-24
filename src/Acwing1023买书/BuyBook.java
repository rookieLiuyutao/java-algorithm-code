package Acwing1023买书;

import java.util.Scanner;

/**
 * http://ybt.ssoier.cn:8088/problem_show.php?pid=1293
 * 完全背包应用
 */
public class BuyBook {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int m = sc.nextInt();
        int[]dp = new int[m+1];
        int[] v = {10,20,50,100};
        int i = v.length;
        while (i-- > 0) {
            for(int j = 0; j <=m; j++) {
              if (j>=v[i]){
                  dp[j]+=dp[j-v[i]];
              }
            }
        }
        System.out.println(dp[m]);
    }

}
