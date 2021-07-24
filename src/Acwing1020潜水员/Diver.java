package Acwing1020潜水员;
import java.util.Arrays;
import java.util.Scanner;

/**
 *  http://ybt.ssoier.cn:8088/problem_show.php?pid=1271
 *  从【不超过某一上限】变为【至少满足某个值】
 */
public class Diver {

    static Scanner sc = new Scanner(System.in);
    static final int N = 85;
    //表示从前i个物品中选，
    static int [][]dp = new int[N][N];
    public static void main(String[] args) {
        int v = sc.nextInt(),m = sc.nextInt(),n = sc.nextInt();
        for(int i = 0; i <N; i++) {
            Arrays.fill(dp[i],Integer.MAX_VALUE/2);
        }
        dp[0][0] = 0;
        for(int i = 0; i <n; i++) {
          int a = sc.nextInt(),b = sc.nextInt(),c = sc.nextInt();
          for(int j = v; j >=0; j--) {
            for(int k = m; k >=0; k--) {
              dp[j][k] = Math.min(dp[j][k],dp[Math.max(0,j-a)][Math.max(0,k-b)]+c);
            }
          }
        }

        System.out.println(dp[v][m]);
    }

}
