package ccf201609_2火车购票;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/3236/
 */
public class TrainTicket {

    static Scanner sc = new Scanner(System.in);
    static int[] ticket = new int[110];
    static boolean[] st = new boolean[110];

    public static void main(String[] args) {
        int n = sc.nextInt();
        while (n-- > 0) {
            int p = sc.nextInt();
            boolean success = false;
            for (int i = 1; i <= 100; i += 5) {
                for (int j = 0; j < 5; j++) {
                    int s = 0;
                    for(int k = j; k <5; k++) {
                      if (!st[i+k]){
                          s++;
                      }else {
                          break;
                      }
                    }

                    if (s >= p) {
                        for (int k = 0; k < p; k++) {
                            int t = i + j + k;
                            System.out.print(t+" ");
                            st[t] = true;
                        }
                        System.out.println();
                        success = true;
                        break;
                    }
                }
                if (success){
                    break;
                }
            }
            if (!success){
                for(int i = 1; i <=100; i++) {
                    if (p > 0&&!st[i]) {
                        System.out.print(i+" ");
                        st[i] = true;
                    }
                }
                System.out.println();
            }
        }
    }
}
