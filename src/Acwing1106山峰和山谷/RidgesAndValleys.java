package Acwing1106山峰和山谷;

import java.io.*;
import java.util.ArrayDeque;

/**
 * https://www.luogu.com.cn/problem/P3456
 * http://ybt.ssoier.cn:8088/problem_show.php?pid=1454
 */
public class RidgesAndValleys {
    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    static int nextInt() throws Exception{
        in.nextToken();
        return (int)in.nval;
    }
    static String next()throws Exception{
        in.nextToken();
        return in.sval;
    }
    static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static final int N = 1010;
    static int [][]g = new int[N][N];
    static boolean hasRidges = false,hasValleys = false;
    static boolean[][]st = new boolean[N][N];
    static int n;
    static void bfs(int sx,int sy){
        ArrayDeque<Point>q = new ArrayDeque<>();
        q.add(new Point(sx,sy));
        st[sx][sy] = true;
        while (!q.isEmpty()){
            Point t = q.poll();
            for(int i = t.x-1; i <=t.x+1; i++) {
              for(int j = t.y-1; j <=t.y+1; j++) {
                  if (i < 0 || i >= n || j < 0 || j >= n) {
                      continue;
                  }
                  if (i == t.x && j == t.y) {
                      continue;
                  }
                  if (g[i][j]!=g[t.x][t.y]){
                      if (g[i][j]>g[t.x][t.y]){
                          hasRidges = true;
                      }else {
                          hasValleys = true;
                      }
                  }else {
                      if (!st[i][j]){
                          q.add(new Point(i,j));
                          st[i][j] = true;
                      }
                  }
              }
            }
        }
    }

    public static void main(String[] args)throws Exception {
        n = nextInt();
        for(int i = 0; i <n; i++) {
          for(int j = 0; j <n; j++) {
            g[i][j] = nextInt();
          }
        }
        int ridges = 0,valleys = 0;
        for(int i = 0; i <n; i++) {
            for(int j = 0; j <n; j++) {
                hasValleys = false;
                hasRidges = false;
                if (!st[i][j]){
                    bfs(i,j);
                    if (!hasRidges){
                        ridges++;
                    }
                    if (!hasValleys){
                        valleys++;
                    }
                }
            }
        }
        System.out.println(ridges+" "+ valleys);
    }

}
