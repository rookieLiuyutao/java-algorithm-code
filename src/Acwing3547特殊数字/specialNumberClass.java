package Acwing3547特殊数字;

import java.util.Scanner;

/**
 * @see https://www.acwing.com/problem/content/3550/
 */
public class specialNumberClass {
    static int temp;


    static boolean isDivByFour(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        if (sum%4==0){
            return true;
        }
        return false;
    }

    static boolean check(int x, int n) {
        if (isDivByFour(x)){
            int r = x-1;
            while (n < r) {
                int mid = n + r + 1>> 1;
                if (check(mid, n)) {
                    return false;
                } else {
                    r = mid -1;
                }
            }

        }else {
           return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = n, r = 1003;
        while (l < r) {
            int mid = l + r + 1>> 1;
            if (check(mid, n)) {
                l = mid;
            } else {
                r = mid -1;
            }

        }
        System.out.println(r);
    }

}
