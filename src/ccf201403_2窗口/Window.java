package ccf201403_2窗口;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/3201/
 */
public class Window {
    private static class Win {
        int x1, y1, x2, y2;
        int id;

        public Win(int x1, int y1, int x2, int y2, int id) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.id = id;
        }
    }
    static int n,m;
    static Scanner sc = new Scanner(System.in);
    static final int N = 12;
    static Win []p = new Win[N];
    static int getF(int x,int y){
        for (int i = n; i > 0; i--) {
            if (x>=p[i].x1&&x<=p[i].x2&&y>=p[i].y1&&y<=p[i].y2){
                return i;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
         n = sc.nextInt();
         m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            p[i] = new Win(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), i);
        }
        while (m-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int t = getF(x,y);
            if (t == 0) {
                System.out.println("IGNORED");
            }else {
                System.out.println(p[t].id);
                Win temp = new Win(p[t].x1,p[t].y1,p[t].x2,p[t].y2,t);
                if (n - t >= 0) {
                    System.arraycopy(p, t + 1, p, t, n - t);
                }
                p[n] = temp;
            }
        }

    }

}
