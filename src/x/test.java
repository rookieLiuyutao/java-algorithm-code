package x;

import java.math.BigDecimal;
import java.util.Scanner;

class test {
    static int N = 21;
    static int n, sum, res;
    static int [] path  = new int[N];
    static boolean[] isPass = new boolean[N];
    static int[][] weight = new int[N][N];


    static void dfs(int u,int count){
        //终止条件
        if (u == n){
            int onePathsSum = 0;

            for (int i = 0; i < n; i++) {
                onePathsSum+=path[i];
            }
            res = Math.min(res,onePathsSum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isPass[i]&&u!=i){
                //处理节点，本题即为把当前数选入结果集
                path[i] = weight[u][i];
                //更新状态
                isPass[i] = true;
                //递归处理
                dfs(i,count+1);
                //回溯，撤销当前选择
                isPass[i]= false;
                path[i] = 0;

            }
        }



    }


    public static void main(String[] args) throws Exception {
//        Scanner sc = new Scanner(System.in);
//        res = Integer.MAX_VALUE/2;
//        n = sc.nextInt();
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                weight[i][j] = sc.nextInt();
//            }
//        }
//        dfs(0, 0);
//        System.out.println(res);
        String s = "2CaOH2";
        System.out.println(s.substring(1,4));
    }
}

