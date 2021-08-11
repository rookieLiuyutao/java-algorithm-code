package ccf201312_4有趣的数;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/description/3198/
 */
public class InterestingNumber {

    static Scanner sc = new Scanner(System.in);
    static final int MOD = (int) 1e9+7;

    public static void main(String[] args) {
        int n = sc.nextInt();
        int [][]c = new int[n+1][n+1];
        for(int i = 0; i <=n; i++) {
          for(int j = 0; j <=i; j++) {
              if (i == 0 || j == 0) {
                  c[i][j] = 1;
              }else {
                  c[i][j] = (c[i-1][j-1]+c[i-1][j])%MOD;
              }
          }
        }
        int res = 0;
        for(int k = 2; k <=n-2; k++) {
          res +=(int) ((long)c[n-1][k]*(n-k-1)%MOD*(k-1))%MOD;
        }
        System.out.println(res);
    }

}
