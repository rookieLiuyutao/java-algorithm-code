package leetcode300最长递增子序列;

/**
 * @see 动态规划模板 https://www.acwing.com/problem/content/897/
 */

import java.util.Scanner;
public class lengthOfLISClassIO {
    static int N = 1010;
    static int[] arr = new int[N];
    static int[] dp = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //这里从数组第二个数开始读入，也可以从第一个开始读入，因为状态转移方程没有涉及到i-1；
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        //集合： 所有以i结尾的上升子序列的长度
        //属性：长度的最大值
        //集合的划分：以第i-1的数的状态来分类
        //即 倒数第二个数是哪个数
        //所有以j结尾的上升子序列的长度是dp[j]+1

        for (int i = 1; i <= n; i++) {
            dp[i] = 1;//最坏情况只有arr[i]一个数

            //遍历所有arr[i]之前的数，所以是j < i
            for (int j = 1; j < i; j++) {
                if (arr[j]<arr[i])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }
        int res = 0;
        for (int i=1;i<=n;i++){
            res = Math.max(res,dp[i]);
        }
        System.out.println(res);
    }

}
