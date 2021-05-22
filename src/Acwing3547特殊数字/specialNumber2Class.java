package Acwing3547特殊数字;

import java.util.Scanner;

/**
 * @see
 */
public class specialNumber2Class {
    static boolean isDivByFour(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum % 4 == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =  sc.nextInt();
        int i=n;
        while (i<1004){
            if (isDivByFour(i)){
                System.out.println(i);
                break;
            }
            i++;
        }
    }

}
