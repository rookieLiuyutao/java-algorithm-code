package Acwing898数字三角形;

/**
 * @see 路径动态规划 https://www.luogu.com.cn/problem/P1216
 */

import java.util.Scanner;
public class digitalTriangleClass {
    static int[][] tr, dp;
    static int N = 510;
    static int ans = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[N][N];
        tr = new int[N][N];

        //注意读入三角形的for循环的写法
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                tr[i][j] = sc.nextInt();
            }
        }
        //  为什么要初始化为-无穷：因为输入的数里有负数，状态转移方程中有求最大值
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i + 1; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

//---------------------------------------

        dp[1][1] = tr[1][1];

//---------------------------------------

/**
 * 集合：所有从起点开始，走到(i,j)的路径 ，
 * 属性：路径之和的最大值
 */
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                //路径的来源有2个：左上角和右上角
                //当前数加上左上角或右上角中的较大者，即得到了数值最大的路径
                dp[i][j] =   Math.max(dp[i - 1][j], dp[i - 1][j - 1])+tr[i][j];
            }
        }
        //走到最后一行，有可能走到最后一行每一个数，所以要遍历最后一行，找到最后一行的最大值
        for (int i=1;i<=n;i++){
            ans = Math.max(ans,dp[n][i]);
        }
        System.out.println(ans);
    }
}
