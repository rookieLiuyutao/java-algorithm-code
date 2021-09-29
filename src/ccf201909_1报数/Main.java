package ccf201909_1报数;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static HashSet<Integer> set = new HashSet<>();

    static boolean check(int x) {
        while (x > 0) {
            if (x % 10 == 7) {
                return true;
            }
            x /= 10;
        }
        return false;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 666; i++) {
            if (check(i) || i % 7 == 0) {
                set.add(i);
            }
        }
        int n = sc.nextInt();
        int[] arr = new int[4];
        int tol = 0, cnt = 0;
        while (cnt < n) {
            for (int i = 0; i < 4; i++) {
                cnt++;
                tol++;
                if (set.contains(tol)) {
                    arr[i]++;
                    cnt--;
                }
                if (cnt == n) {
                    break;
                }
            }
        }
        for(int i = 0; i <4; i++) {
            System.out.println(arr[i]);
        }
        System.out.println(set);
    }

}
