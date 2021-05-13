package Acwing1221四平方和;

/**
 * @see 1221. 四平方和 https://www.acwing.com/problem/content/description/1223/
 */


import java.util.*;


public class sumOfFourSquaresClass {
    private static int n;
    private static final int N = 5000010;
    private static int[] cSet = new int[N];
    private static int[] dSet = new int[N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        Arrays.fill(cSet, -1);
        for (int c = 0; c * c <= n; c++) {
            for (int d = c; d * d + c * c <= n; d++) {
                int s = c * c + d * d;
                if (cSet[s] == -1) {
                    cSet[s] = c;
                    dSet[s] = d;
                }
            }
        }

        for (int a = 0; a * a <= n; a++) {
            for (int b = a; b * b + a * a <= n; b++) {
                int s = n - a * a - b * b;
                if (cSet[s] != -1) {
                    System.out.println(a + " " + b + " " + cSet[s] + " " + dSet[s]);
                    return;
                }
            }
        }
    }


}





