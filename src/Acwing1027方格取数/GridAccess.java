package Acwing1027方格取数;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

/**
 * 线性dp 数字三角形模型
 * https://www.luogu.com.cn/problem/P1004
 */
public class GridAccess {
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
        int x,y,val;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;

        }
    }
    static int [][] dp1 = new int[11][11] ,dp2 = new int[11][11] ,w = new int[11][11];
    static ArrayList<Point> cont = new ArrayList<>();
    public static void main(String[] args)throws Exception {
        int n = nextInt();

        for(int i = 0; i <n; i++) {
          int x = nextInt();
          int y = nextInt();
          int val = nextInt();
          w[x][y] = val;
        }
        System.out.println();
        for(int i = 1; i <=9; i++) {
            for(int j = 1; j <=9; j++) {
                System.out.printf("%4d",w[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        for(int i = 1; i <=9; i++) {
            for(int j = 1; j <=9; j++) {
                dp1[i][j] = Math.max(dp1[i-1][j],dp1[i][j-1])+w[i][j];
            }
        }

        for(int i = 1; i <=9; i++) {
            for(int j = 1; j <=9; j++) {
                System.out.printf("%4d",dp1[i][j]);
            }
            System.out.println();
        }
        int res = dp1[9][9];
        
        for (int i = 9;i>=1;i--){
            for (int j = 9;j>=1;j--){
                if (dp1[i][j]-dp1[i-1][j]!=0&&dp1[i][j]-dp1[i][j-1]!=0){
                    if (dp1[i][j] == dp1[i-1][j]+w[i][j]){
                        cont.add(new Point(i,j,w[i][j]));

                    }

                }
            }
        }

        for (Point p:cont){
            System.out.println(p.x+" "+p.y+" "+p.val);
            w[p.x][p.y] = 0;
        }

        for(int i = 1; i <=9; i++) {
            for(int j = 1; j <=9; j++) {
                dp2[i][j] = Math.max(dp2[i-1][j],dp2[i][j-1])+w[i][j];
            }
        }
        for(int i = 1; i <=9; i++) {
            for(int j = 1; j <=9; j++) {
                System.out.printf("%4d",w[i][j]);
            }
            System.out.println();
        }
        out.println(dp1[9][9]);
        out.println(dp1[9][9]+dp2[9][9]);

        out.flush();
    }


}
