package ccf201409_3字符串匹配;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/3207/
 */
public class StringMatch {
    static Scanner sc = new Scanner(System.in);
    static String p;

    static void caseSensitive(String x) {
        int n = p.length();
        if (n > x.length()) {
            return;
        }
        for (int i = 0; i + n <= x.length(); i++) {
            String t = x.substring(i, i + n);
            if (t.equals(p)) {
                System.out.println(x);
                return;
            }
        }
    }

    static void caseInsensitive(String x) {
        int n = p.length();
        if (n > x.length()) {
            return;
        }
        for (int i = 0; i + n <= x.length(); i++) {
            int count = 0;
            for (int j = i; j < n + i; j++) {
                char c = x.charAt(j);
                char ac;
                if ((c - 'a') >= 0) {
                    ac = (char) (c - 32);
                } else {
                    ac = (char) (c + 32);
                }
                if (!(x.charAt(j) == p.charAt(j - i) || ac == p.charAt(j - i))) {
                    break;
                } else {
                    count++;
                }
            }
            if (count == n) {
                System.out.println(x);
                return;
            }
        }

    }

    public static void main(String[] args) {
        p = sc.next();
        int m = sc.nextInt();
        int n = sc.nextInt();

        while (n-- > 0) {
            String x = sc.next();
            if (m == 1) {
                caseSensitive(x);
            } else {
                caseInsensitive(x);
            }
        }
    }

}
