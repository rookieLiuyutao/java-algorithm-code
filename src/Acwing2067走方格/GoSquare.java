package Acwing2067走方格;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/2069/
 */
public class GoSquare {
    static Scanner sc = new Scanner(System.in);
    static final int N = 35;
    static int [][]dp = new int[N][N];
    public static void main(String[] args) {
        int x = sc.nextInt();
        int y = sc.nextInt();
        dp[1][1] = 1;
        for(int i = 1; i <=x; i++) {
//            dp[i][1] = 1;
            for(int j = 1; j <=y; j++) {
//                dp[1][j] = 1;
                if (i%2==0&&j%2==0){
                    dp[i][j] =0;
                }else {
                    dp[i][j]+=dp[i-1][j]+dp[i][j-1];

                }
            }
        }
//        for(int i = 1; i <=x; i++) {
//            for(int j = 1; j <=y; j++) {
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }
        System.out.println(dp[x][y]);
    }
}
