package Acwing3770最小消耗;

import java.io.*;
import java.util.Scanner;
/**
 * https://www.acwing.com/problem/content/3773/
 */
public class MinimumConsumption {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)throws Exception {
        int t = sc.nextInt();

        while (t-- > 0) {
            int res = 0;
            int n  = sc.nextInt(),a = sc.nextInt(),b = sc.nextInt(),c = sc.nextInt();
            String s = sc.next();
            for(int i = 0; i <n; i++) {
              int x= (s.charAt(i)-'0');
              if (c+a>b){
                if (c+b>a){
                    if (x == 0) {
                        res+=a;
                    }else {
                        res+=b;
                    }
                }else {
                    if (x == 0) {
                        res+=b+c;
                    }else {
                        res+=b;
                    }
                }
              }else {
                if (c+b>a){
                    if (x == 0) {
                        res+=a;
                    }else {
                        res+=a+c;
                    }
                }else {
                    if (x == 0) {
                        res+=b+c;
                    }else {
                        res+=a+c;
                    }
                }
              }

            }
            System.out.println(res);

        }
    }


}
