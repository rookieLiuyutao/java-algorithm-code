package Acwing2066解码;

import java.util.Scanner;

/**
 * 字符串
 * https://www.acwing.com/problem/content/2068/
 */
public class Decoding {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String s = sc.nextLine();
        StringBuilder res = new StringBuilder();
        int n = s.length();
        res.append(s.charAt(0));
        for(int i = 1; i <n; i++) {
          if (!Character.isDigit(s.charAt(i))||s.charAt(i)-'1'>9){
              res.append(s.charAt(i));
          }else {
              int x = s.charAt(i)-'1';
              for(int j = 0; j <x; j++) {
                res.append(s.charAt(i-1));
              }
          }
        }
        System.out.println(res);
    }


}
