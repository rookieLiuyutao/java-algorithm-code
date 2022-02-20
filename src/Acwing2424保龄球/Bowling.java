package Acwing2424保龄球;
/*
 * https://www.acwing.com/problem/content/2426/
 */
import java.util.Scanner;

public class Bowling {
    static Scanner sc = new Scanner(System.in);

    static class PII {
        int x, y;

        public PII(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public PII() {
        }
    }

    static int n, m,ans;
    static PII[] q;

    static void swap(int a, int b) {
        PII t = q[a];
        q[a] = q[b];
        q[b] = t;
    }

    static int calc() {
        int res = 0;
        for (int i = 0; i < m; i++) {
            res += q[i].x + q[i].y;
            if (i<n){
                if (q[i].x == 10) {
                    res += q[i + 1].x + q[i + 1].y;
                } else if (q[i].x + q[i].y == 10) {
                    res+=q[i+1].x;
                }
            }

        }
        ans = Math.max(ans,res);
        return res;

    }

    static void sa() {
        for (double t = 1e4; t > 1e-4; t *= 0.98) {
            int a = (int) (Math.random() * m), b = (int) (Math.random() * m);
            int p = calc();
            swap(a,b);
            int f = q[n - 1].x == 10 ? 1 : 0;
            if (n+f==m){
                int u = calc();
                int d = u - p;
                if (Math.pow(Math.E, d / t)<Math.random()){
                    swap(a,b);
                }
            }else{
                swap(a,b);
            }
        }
    }

    public static void main(String[] args) {
        n = sc.nextInt();
        q = new PII[n+5];
        for(int i = 0; i <n+5; i++) {
            q[i] = new PII();
        }
        for(int i = 0; i <n; i++) {
          q[i] = new PII(sc.nextInt(),sc.nextInt());
        }
        if (q[n-1].x==10){
            m = n+1;
            q[n] = new PII(sc.nextInt(),sc.nextInt());
        } else m = n;
        for(int i = 0; i <85; i++) {
          sa();
        }
        System.out.println(ans);
    }
}
