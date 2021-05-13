package 背包问题;

import java.util.Scanner;

public class completeBackpack {
    public static int completeBag(int[] weight, int[] value, int bagWeight) {
        int num = weight.length;
        int[][] dp = new int[num + 1][bagWeight + 1];

        for (int i = 1; i <= num; i++) {
            for (int j = 0; j <= bagWeight; j++) {
                for (int k = 0; k * weight[i - 1] <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * weight[i - 1]] + value[i - 1] * k);
                }

            }

        }
//        for (int[] ints : dp) {
//            for (int j = 0; j < dp[num].length; j++) {
//                System.out.print(ints[j] + " ");
//            }
//            System.out.println();
//        }
        return dp[num][bagWeight];
    }

    public static int completeBagOptimization(int[] weight, int[] value, int bagWeight) {
        int num = weight.length;
        int[][] dp = new int[num + 1][bagWeight + 1];

        for (int i = 1; i <= num; i++) {
            for (int j = 0; j <= bagWeight; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= weight[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - weight[i - 1]] + value[i - 1]);
                }
            }

        }
//        for (int[] ints : dp) {
//            for (int j = 0; j < dp[num].length; j++) {
//                System.out.print(ints[j] + " ");
//            }
//            System.out.println();
//        }
        return dp[num][bagWeight];
    }
    public static int completeBagOptimization2
            (int[] volume, int[] worth, int bagWeight){
        int num = volume.length;
        int[] dp = new int[bagWeight + 1];

        for(int i = 1; i <=num ; i++) {
            for(int j = volume[i-1]; j <=bagWeight ; j++) {
                dp[j] = Math.max(dp[j],dp[j-volume[i]]+worth[i] );
            }
        }
        return dp[bagWeight];

    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int itemsNumber = sc.nextInt();
//        int bagWeight = sc.nextInt();
//        int[][] arr = new int[itemsNumber][2];
//        int[] weight = new int[itemsNumber];
//        int[] value = new int[itemsNumber];
//        for(int i = 0; i < itemsNumber; i++) {
//            for(int j = 0; j < 2; j++) {
//                arr[i][j] = sc.nextInt();
//            }
//            weight[i] = arr[i][0];
//            value[i]=   arr[i][1];
//        }
        int[] weight ={2,3,4,5};
        int[] value = {3,4,5,6};
        System.out.println(completeBagOptimization2(weight, value, 8));
    }
}
