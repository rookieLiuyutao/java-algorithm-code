package 背包问题;

import java.util.Scanner;

public class o1bagClass {
    public static int o1bagSolution(int[] weight, int[] value, int bagWeight) {
        int num = weight.length;
        int[][] dp = new int[num + 1][bagWeight + 1];
        //注意函数版本的背包；2个数组都是从第一个数开始填入的，所以状态转移方程有所差别
        for (int i = 1; i <= num; i++) {
            for (int j = 0; j <= bagWeight; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= weight[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                }

            }

        }
        /**
         * 以下注释段可以打印矩阵
         */
//        for (int[] ints : dp) {
//            for (int j = 0; j < dp[num].length; j++) {
//                System.out.print(ints[j] + " ");
//            }
//            System.out.println();
//        }

        return dp[num][bagWeight];
    }

    public static int o1bagSolutionOptimization
            (int[] volume, int[] worth, int bagWeight) {
        int num = volume.length;
        int[] dp = new int[bagWeight + 1];

        for (int i = 1; i <= num; i++) {
            for (int j = bagWeight; j >= volume[i - 1]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - volume[i - 1]] + worth[i - 1]);
            }
        }

        return dp[bagWeight];
    }


//    public static void main(String[] args) {
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
//        System.out.println(o1bagSolutionOptimization(weight, value, bagWeight));
//    }
    public static void main(String[] args) {
        int[] weight ={2,3,4,5};
        int[] value = {3,4,5,6};
        System.out.println(o1bagSolutionOptimization(weight,value,8));

}

}
