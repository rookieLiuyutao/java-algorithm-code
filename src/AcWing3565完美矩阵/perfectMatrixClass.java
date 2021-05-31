package AcWing3565完美矩阵;

import java.io.*;
import java.util.*;

/**
 * @see 哈希集合 https://www.acwing.com/problem/content/3568/
 */
public class perfectMatrixClass {

    static final int N = 105;
    static int n, m;
    static int[][] matrix = new int[N][N];
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

    static long work(Set<int[]> set) {
        List<Integer> list = new ArrayList<>();
        for (int[] i : set) {
            list.add(matrix[i[0]][i[1]]);
        }
        Collections.sort(list);
        long ans = 0;
        for (int j = 0; j < list.size(); j++) {
            ans += Math.abs(list.get(j) - list.get(list.size() / 2));
        }

        return ans;
    }

    public static void main(String[] args) throws Exception {
        int count = nextInt();
        while (count-- != 0) {
            n = nextInt();
            m = nextInt();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix[n][m] = nextInt();
                }
            }
            long res = 0;
            for (int i = 0; i <= n - 1 - i; i++) {
                for (int j = 0; j < m - 1 - j; j++) {
                    Set<int[]> set = new HashSet<>();
                    set.add(new int[]{i,j});
                    set.add(new int[]{i,m-1-j});
                    set.add(new int[]{n-1-i,j});
                    set.add(new int[]{n-1-i,m-1-j});

                    res += work(set);

                }
            }
            System.out.println(res);
        }
    }

}
