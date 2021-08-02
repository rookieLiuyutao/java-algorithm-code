package ccf201312_3最大的矩形;

import java.util.Scanner;

public class LargestRectangle {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int []a = new int[n+1],l = new int[n+2],r = new int[n+2],q = new int[n+2];
        a[0] = a[n+1] = -1;
        for(int i = 1; i <=n; i++) {
          a[i] = sc.nextInt();
        }
        int tt = 0;
        q[0] = 0;
        for(int i = 1; i <=n; i++) {
            while (a[i]<=a[q[tt]]){
                tt--;
            }
            l[i] = q[tt];
            q[++tt] = i;
        }
        q[0] = 0;
        tt = 0;
        for(int i = n; i >0; i--) {
          while (a[i]>a[q[tt]]){
              tt--;
          }
          r[i] = q[tt];
          q[++tt] = i;
        }
        long res = 0;
        for(int i = 1; i <=n; i++) {
            res = Math.max(res,(long) (r[i]-l[i]-1)*a[i]);
        }
        System.out.println(res);
    }

}
