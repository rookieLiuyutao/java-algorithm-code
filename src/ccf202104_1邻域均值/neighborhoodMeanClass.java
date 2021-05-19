package ccf202104_1邻域均值;

import java.util.Scanner;

/**
 * @see 邻域均值 https://www.acwing.com/problem/content/3415/
 */
public class neighborhoodMeanClass {
    /**
     * L 输入矩阵的数的最大范围
     * n 矩阵的阶
     * r 邻域的范围
     * t 输入的阈值
     */
    static int N = 610;
    static int n,L,r,t;
    static int[][] s = new int[N][N];
    public static int getSum(int x1,int y1,int x2,int y2){
        return s[x2][y2]-s[x1-1][y2]-s[x2][y1-1]+s[x1-1][y1-1];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        L = sc.nextInt();
        r = sc.nextInt();
        t = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <=n ; j++) {
                int x=sc.nextInt();
                s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + x;

            }
        }
        int res =0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <=n ; j++) {
                int a = Math.max(i-r,1),b = Math.max(j-r,1),c = Math.min(i+r,n),d= Math.min(j+r,n);
                //这里算平均值时用除法会引起取整的问题,用double也无法解决，因此把除数乘到t上用乘法比
                int average = getSum(a,b,c,d);
//                int average = (s[c][d] - s[a - 1][d] - s[c][b - 1] + s[a - 1][b - 1])/((c-a+1)*(d-b+1));
//                double average = (s[c][d] - s[a - 1][d] - s[c][b - 1] + s[a - 1][b - 1])/((c-a+1)*(d-b+1));
                if (average<t*((c-a+1)*(d-b+1))){
                    res++;
                }

            }
        }
        System.out.println(res);
    }

}
