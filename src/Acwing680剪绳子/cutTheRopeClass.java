package Acwing680剪绳子;
/**
 * AcWing 680. 剪绳子 https://www.acwing.com/problem/content/682/
 */

import java.util.Scanner;

public class cutTheRopeClass {
    static int n, m;
    static int[] arr ;


    static boolean check(double len) {
        int count = 0;
        //统计以当前枚举长度切后，绳子的数量
        for (int i :arr) {
            count += i / len;
        }
        return count < m;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
            //eqs一般比题目要求返回的精度多2位，本题要求返回2位小数
            double eqs = 1e-4;
            double left = 0, right = 1e9;
            while (right - left > eqs) {
                double mid = (left + right) / 2;
                //check函数的返回值与mid的移动一定要对应
                if (check(mid)) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            //最终结果是left还是right要根据题目具体分析
            System.out.printf("%.2f\n",right);
        }



}
