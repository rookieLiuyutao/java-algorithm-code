package ccf201512_1数位之和;

import java.util.Scanner;

public class SumOfDigits {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        char []strs = sc.next().toCharArray();
        int res = 0;
        for (char str : strs) {
            res += str - '0';
        }
        System.out.println(res);
    }

}
