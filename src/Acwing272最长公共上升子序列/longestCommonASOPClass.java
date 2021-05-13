package Acwing272最长公共上升子序列;

import java.util.Scanner;

public class longestCommonASOPClass {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n + 1];
        int[] arr2 = new int[n + 1];
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            arr2[i] = sc.nextInt();
        }

        //集合：所有在arr1[1,j]和arr2[1,j]都出现过且以arr2[j]结尾的上升子序列的集合
        //属性：Max
        //集合划分：所有不包含arr1[i]的子序列；所有包含arr1[i]的子序列
        for (int i = 1; i <= n; i++) {
            int maxL = 1;
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                if (arr1[i] == arr2[j]) {
                    dp[i][j] = Math.max(maxL, dp[i][j]);
                }
                if (arr2[j] < arr1[i]) {
                    maxL = Math.max(maxL, dp[i - 1][j] + 1);
                }
            }
        }
//        for(int i = 1; i <=n; i++) {
//            for(int j = 1; j <=n; j++) {
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }
        int res = 0;
        for (int k = 1; k <= n; k++) {
            res = Math.max(res, dp[n][k]);
        }
        System.out.println(res);
    }
}
