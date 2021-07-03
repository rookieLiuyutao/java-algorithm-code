package Acwing895最长上升子序列;

/**
 * @see 动态规划模板 https://www.acwing.com/problem/content/897/
 */
import java.util.Scanner;

public class LengthOfLISDichotomousOptimization {
    static int N = 1010;
    static int[] arr = new int[N];
    static int[] save = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res =0;
        //这里从数组第二个数开始读入，也可以从第一个开始读入，因为状态转移方程没有涉及到i-1；
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        //集合： 所有以i结尾的上升子序列的长度
        //属性：长度的最大值
        //集合的划分：以第i-1的数的状态来分类
        //即 倒数第二个数是哪个数
        //所有以j结尾的上升子序列的长度是dp[j]+1

        for (int i = 0; i < n; i++) {
            //遍历所有arr[i]之前的数，所以是j < i
            int l = 0,r = res;
            while (l < r) {
                int mid = l+r+1>>1;
                if (save[mid]<arr[i]){
                    l = mid;
                }else {
                    r = mid-1;
                }
            }
            save[l+1] = arr[i];
            res = Math.max(res,l+1);
        }
        System.out.println(res);
    }


}
