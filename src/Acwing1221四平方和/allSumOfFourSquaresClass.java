package Acwing1221四平方和;
/**
 * @see 1221. 数学题 https://www.acwing.com/problem/content/description/1223/
 */

import java.util.*;
public class allSumOfFourSquaresClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        int len = (int) Math.sqrt(sum);
        for (int d = 0; d <= len; d++) {
            int abcLen = sum - d * d;
            int abc = (int) Math.sqrt(sum - d * d);
            for (int c = 0; c <= abc; c++) {
                int abLen = sum - abcLen;
                int ab = (int) Math.sqrt(sum - abcLen);
                for (int b = 0; b <= ab; b++) {
                    int a = (int) Math.sqrt(sum - abLen);
                    if (a * a + b * b + c * c + d * d == sum) {
                        System.out.println(d+" "+c+" "+b+" "+a);
                        break;
                    }

                }
            }
        }
    }


}



