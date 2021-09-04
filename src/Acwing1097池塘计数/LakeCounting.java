package Acwing1097池塘计数;
/**
 * https://www.luogu.com.cn/problem/P1596
 */


import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * http://poj.org/problem?id=2386
 */
public class LakeCounting {
    static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static Scanner sc = new Scanner(System.in);
    static int n,m;
    static char[][]g;
    static boolean[][]st;
    static void bfs(int sx,int sy){
        ArrayDeque<Point> q = new ArrayDeque<>();
        q.add(new Point(sx,sy));
        while (!q.isEmpty()){
            Point t = q.poll();
            for(int i = t.x-1; i <=t.x+1; i++) {
                for(int j = t.y-1; j <=t.y+1; j++) {
                    if (i==t.x&&j==t.y){
                        continue;
                    }
                    if (i>=n||i<0||j<0||j>=m||g[i][j]=='.'||st[i][j]){
                        continue;
                    }
                    st[i][j] = true;
                    q.add(new Point(i,j));
                }
            }
        }
    }

    public static void main(String[] args)throws Exception {
         n = sc.nextInt();
         m = sc.nextInt();
        g = new char[n+1][m+1];
        st= new boolean[n+1][m+1];
        for(int i = 0; i <n; i++) {
          g[i] =  sc.next().toCharArray();
        }
//        for(int i = 0; i <n; i++) {
//            for(int j = 0; j <m; j++) {
//                System.out.print(g[i][j]+" ");
//            }
//            System.out.println();
//        }
        int res = 0;
        for(int i = 0; i <n; i++) {
            for(int j = 0; j <m; j++) {
                if (g[i][j]=='W' &&!st[i][j]){
                    res++;
                    bfs(i,j);
                }
            }
        }
        System.out.println(res);
    }

}
