package ACwing3完全背包问题;

import java.util.Scanner;

public class completeBagDoubleOptimizationPlusClass {

    static int N = 1010;
    static int[] dp = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  =sc.nextInt(),bagVolume = sc.nextInt();
        //一定要注意，输入输出版的背包问题，2个数组都是从第二个数开始填入的
        for(int i = 1; i <= n; i++) {
            int volume = sc.nextInt(),worth = sc.nextInt();
            for (int j = volume; j <=bagVolume ; j++)
                dp[j] = Math.max(dp[j], dp[j-volume]+worth);
        }
        System.out.println(dp[bagVolume]);
    }
}
