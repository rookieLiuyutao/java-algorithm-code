package Acwing135最大子序和;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @see 前缀和 单调队列 https://www.acwing.com/problem/content/description/137/
 * 用Java Deque
 */
public class maximumWordOrderSumClass {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] sum = new int[n + 1];
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            int x = sc.nextInt();
            sum[i] += sum[i - 1] + x;
        }

        int res = Integer.MIN_VALUE;
        //前缀和数组中用sum[0]来防止越界，但入队的时候没有sum[0],所以提前把0入队起到了相同的作用
        q.add(0);
//---------------------暴力方法-------------------------
//        for(int i = 1; i <=n; i++) {
//            for(int len = 1; len <=m; len++) {
//                if (i-len>=0){
//                    res = Math.max(res,sum[i]-sum[i-len]);
//                }
//            }
//        }
//--------------------------------------------------------------
        for (int i = 1; i <= n; i++) {

            if (i - q.peekFirst() > m) {
                q.poll();
            }
            res = Math.max(res, sum[i] - sum[q.peekFirst()]);
            while (!q.isEmpty() && sum[i] <= sum[q.peekLast()]) {
                q.pollLast();
            }
            q.add(i);
        }
        System.out.println(res);
    }

}
