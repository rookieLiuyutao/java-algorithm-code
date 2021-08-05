package Acwing869试除法求约数;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 * https://www.acwing.com/problem/content/871/
 * 约数
 */
public class TryToDivide {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Integer> getDivide(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n / i; i++) {
            if (n % i == 0) {
                res.add(i);
                if (i != n / i) {
                    res.add(n/i);
                }
            }
            Collections.sort(res);
        }
        return res;
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        while (n-- > 0) {
            int x = sc.nextInt();
            ArrayList<Integer> list = getDivide(x);
            for (int t:list){
                System.out.print(t+" ");
            }
            System.out.println();
        }
    }
}
