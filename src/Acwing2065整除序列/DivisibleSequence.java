package Acwing2065整除序列;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/2067/
 */
public class DivisibleSequence {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        long n = sc.nextLong();
        ArrayList<Long> list = new ArrayList<>();
        while (n >=1) {
            list.add(n);
            n/=2;
        }
        for (long x:list){
            System.out.print(x+" ");
        }
    }
}
