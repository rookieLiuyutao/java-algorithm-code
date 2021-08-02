package Acwing3779相等的和;

import java.io.*;
import java.util.HashMap;

/**
 * https://www.acwing.com/problem/content/3782/
 */
public class Main {
    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static int nextInt() throws Exception {
        in.nextToken();
        return (int) in.nval;
    }

    static String next() throws Exception {
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
    public static void main(String[] args) throws Exception {
        int k = nextInt();
        HashMap<Integer, Point> map = new HashMap<>();
        for (int i = 1; i <= k; i++) {
            int n = nextInt();
            int[] a = new int[n + 1];
            int sum = 0;

            for (int j = 1; j <= n; j++) {
                a[j] = nextInt();
                sum += a[j];
            }
            for (int j = 1; j <= n; j++) {
                if (map.containsKey(sum - a[j]) && map.get(sum - a[j]).x!=i) {
                    out.println("YES");
                    out.println(i + " " + j);
                    out.println(map.get(sum-a[j]).x+" "+map.get(sum-a[j]).y);
                    out.flush();
                    return;
                }
                map.put(sum-a[j],new Point(i,j));
            }

        }
        out.println("NO");
        out.flush();
    }


}
