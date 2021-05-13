package Acwing1055股票买卖2;
/**
 * @see 贪心 https://www.acwing.com/problem/content/1057/
 */

import java.util.*;

public class maxProfitClass {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int lastPrices = 0;
        if (n<=1){
            return 0;
        }
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            if (j <= n - 1 && prices[j] - prices[i] > 0) {
                lastPrices+=prices[j] - prices[i];
            }
        }
        return lastPrices;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(maxProfit(arr));
    }
}
