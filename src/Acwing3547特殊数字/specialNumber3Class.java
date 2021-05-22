package Acwing3547特殊数字;

import java.util.Scanner;

/**
 * @see
 */
public class specialNumber3Class {
    static int isDivByFour(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum % 4 ;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = isDivByFour(n);
            while (x!=0){
                if (x==1&&n%10<9){
                    System.out.println(n+3);
                    break;
                } if (x==3&&n%10<9){
                    System.out.println(n+1);
                    break;
                }else if (x==2&&n%10<9){
                    System.out.println(n+2);
                    break;
                }else {
                    n+=1;
                }
                x = isDivByFour(n);
            }
            if (x==0){
                System.out.println(n);
            }

    }
}
