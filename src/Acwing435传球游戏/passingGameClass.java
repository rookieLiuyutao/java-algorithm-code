package Acwing435传球游戏;

import java.util.Scanner;

/**
 * @see 环形dp 路径dp https://www.acwing.com/problem/content/437/
 */
public class passingGameClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;
        dp[1][1]  =1;
        //集合：第m次传球传给了第i个人
        //集合划分：第m-1次传球传给了第i-1个人；第m-1次传球传给了第i+1个人
        //属性：最后传回给第1个人的方案数
        for(int i = 1; i <=m; i++) {
            for(int j = 0; j <n; j++) {
                dp[i][j] = dp[i-1][(j+1)%n]+dp[i-1][(j-1+n)%n];
            }
        }
        for(int i = 0; i <=m; i++) {
            for(int j = 0; j <=n; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println(dp[m][1]);
    }


}
