package ccf201609_1最大波动;

import java.util.Scanner;

public class MaximumFluctuation {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            int j = i + 1;
            res = Math.max(res, (Math.abs(a[i]-a[j])));
        }
        System.out.println(res);
    }

}
