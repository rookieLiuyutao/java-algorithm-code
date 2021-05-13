package Acwing1453移掉k位数字;
/**
 * @see 贪心 https://www.acwing.com/problem/content/1455/
 */

import java.io.*;
import java.util.*;

public class removeKDigitsClass {
    /**
     *
     * @param num 输入字符串表示的整数
     * @param k 移除k位数字
     * @return 剩下的最小的字符串
     */
    public static String removeKDigits(StringBuilder num, int k) {
        StringBuilder res = new StringBuilder();
        //开一个字符串保存最后结果
        res.append('0');
        /**
         * 遍历num，每次把当前位加入res结果串，
         * 如果res当前加入的数比上一次加入的数小
         * 就删掉res的最后一位（可以简单理解为上一位）
         */
        for (int i = 0; i < num.length(); i++) {
            while (k != 0 && num.charAt(i) < res.charAt(res.length() - 1)) {
                res.deleteCharAt(res.length() - 1);
                k--;
            }
            res.append(num.charAt(i));
        }
        /**
         * 如果执行完上面的循环，还没有删完k个数
         * 则说明num中有连续的一段是升序的，这段的长度大于k
         */
        while (k-- != 0) {
            res.deleteCharAt(res.length() - 1);
        }
        /**
         * 删除所有的先导0
         */
        k = 0;
        while (k + 1 < res.length() && res.charAt(k) == '0') {
            k++;
        }
        return res.substring(k);
    }
    public static void main(String[] args) {
        //读入num和k
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        String num = sc.nextLine();
        StringBuilder num2 = new StringBuilder(num);
        int k = sc.nextInt();
        System.out.println(removeKDigits(num2,k));
    }
}

