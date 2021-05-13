package Acwing4多重背包问题;
/**
 * @see 多重背包 https://www.acwing.com/problem/content/6/
 */

import java.util.*;

public class multipleKnapsackOptimizationClass {
    static int N = 12010;
    static int n, bagVolume;
    static int[] volume = new int[N];
    static int[] worth = new int[N];
    static int[] dp = new int[N];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        bagVolume = sc.nextInt();
        int count = 0;
        //一定要注意，输入输出版的背包问题，2个数组都是从第二个数开始填入的
        for (int i = 1; i <= n; i++) {
            int curVolume, curWorth, curSolidNumber;
            curVolume = sc.nextInt();
            curWorth = sc.nextInt();
            curSolidNumber = sc.nextInt();
            int groupContain = 1;
            while (groupContain <= curSolidNumber) {
                count++;
                volume[count] = curVolume * groupContain;
                worth[count] = curWorth * groupContain;
                curSolidNumber -= groupContain;
                groupContain *= 2;
            }
            if (curSolidNumber > 0) {
                count++;
                volume[count] = curVolume * curSolidNumber;
                worth[count] = curWorth * curSolidNumber;
            }
        }
        n = count;

        for (int i = 1; i <= n; i++) {
            for (int j = bagVolume; j >= volume[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - volume[i]] + worth[i]);
            }
        }
        System.out.println(dp[bagVolume]);

    }

}
