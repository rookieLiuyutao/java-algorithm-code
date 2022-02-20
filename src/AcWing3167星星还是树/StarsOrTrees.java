package AcWing3167星星还是树;


import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/3170/
 */


public class StarsOrTrees {
    static Scanner sc = new Scanner(System.in);

    static class PDD{
        double x,y;

        public PDD(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }


    static PDD[] q ;



    static double ans = 1e8;
    static int n;
    static double rand(double l, double r) {
        return Math.random()  * (r - l) + l;
    }

    static double get_dist(PDD a, PDD b) {
        double dx = a.x - b.x;
        double dy = a.y - b.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * 计算当前点到其他所有点的距离
     * @param p
     * @return
     */
    static double calc(PDD p) {
        double res = 0.0;
        for (int i = 0; i < n; i++) {
            res += get_dist(p, q[i]);
        }
        ans = Math.min(ans,res);
        return res;
    }
    static void sa() {
        PDD cur = new PDD(rand(0, 10000), rand(0, 10000));
        for (double t = 1e4; t > 1e-4; t *= 0.9) {
            PDD np = new PDD(rand(Math.max(0,cur.x - t), cur.x + t), rand(Math.max(0,cur.y - t), cur.y + t));
            double dt = calc(np)- calc(cur);
            if (Math.pow(Math.E,-dt/t)> Math.random()){
                cur = np;
            }

        }
    }

    public static void main(String[] args)throws Exception {
//        System.out.println(ans);
        n = sc.nextInt();
        q = new PDD[n];
        for(int i = 0; i <n; i++) {
          double x = sc.nextDouble(),y = sc.nextDouble();
//            System.out.println(x+ " "+ y);
          q[i] = new PDD(x,y);
        }
        for(int i = 0; i <100; i++) {
          sa();
        }
        System.out.printf("%.0f",ans);
    }

}
