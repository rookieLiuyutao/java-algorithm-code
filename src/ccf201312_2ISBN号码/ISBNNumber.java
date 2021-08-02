package ccf201312_2ISBN号码;

import java.util.Scanner;

public class ISBNNumber {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String str = sc.next();
        String[] temp = str.split("-");
        StringBuilder ss = new StringBuilder();
        for (int i = 0; i < temp.length - 1; i++) {
            ss.append(temp[i]);
        }
        int sum = 0;
        for (int i = 0; i < ss.length(); i++) {
            sum += (i + 1) * (ss.charAt(i) - '0');
        }
//        System.out.println(sum);
        if ('X' == (temp[3].charAt(0)) && sum % 11 == 10) {
            System.out.println("Right");
        } else if (sum % 11 == (temp[3].charAt(0) - '0')) {
            System.out.println("Right");
        } else {
            String st = str.substring(0, 12);
            if (sum % 11 == 10) {
                System.out.println(st + "X");
            } else {
                System.out.println(st + sum % 11);
            }
        }
    }

}
